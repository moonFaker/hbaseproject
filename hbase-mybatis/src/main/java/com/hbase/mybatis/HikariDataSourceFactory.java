package com.hbase.mybatis;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/9 17:02
 **/
public class HikariDataSourceFactory extends UnpooledDataSourceFactory {
    public HikariDataSourceFactory(){
        this.dataSource=new HikariDataSource();
    }
}
