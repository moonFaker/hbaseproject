package com.hbase.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/9 17:03
 **/
@Configuration
@MapperScan(basePackages = HosDataSourceConfig.PACKAGE,
sqlSessionFactoryRef = "HosSqlSessionFactory")
public class HosDataSourceConfig {
    static  final String PACKAGE="com.hbase.**";

    @Bean(name = "HosDataSource")
    //多个实现类时优先注入
    @Primary
    public DataSource hosDataSource() throws IOException{
        ResourceLoader loader=new DefaultResourceLoader();
        InputStream inputStream=loader.getResource("classpath:application.properties").getInputStream();
        Properties properties=new Properties();
        properties.load(inputStream);
        Set<Object>keys=properties.keySet();
        Properties dsProperties=new Properties();
        for(Object key:keys){
            if(key.toString().startsWith("datasource")){
                dsProperties.put(key.toString().replace("datasource.",""),properties.get(key));
            }
        }
        HikariDataSourceFactory factory=new HikariDataSourceFactory();
        factory.setProperties(dsProperties);
        inputStream.close();
        return  factory.getDataSource();


    }

    @Bean(name = "HosSqlSessionFactory")
    @Primary
    public SqlSessionFactory hosSqlSessionFactory(@Qualifier("HosDataSource")DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourceLoader loader=new DefaultResourceLoader();
        sqlSessionFactoryBean.setConfigLocation(loader.getResource("classpath:mybatis-config.xml"));
        return  sqlSessionFactoryBean.getObject();

    }
}
