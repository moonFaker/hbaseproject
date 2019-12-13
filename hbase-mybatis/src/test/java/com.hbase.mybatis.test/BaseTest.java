package com.hbase.mybatis.test;

import com.hbase.mybatis.HosDataSourceConfig;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by jixin on 18-3-8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Import(HosDataSourceConfig.class)
@PropertySource("classpath:application.properties")
@ComponentScan("com.hbase.*")
@MapperScan("com.hbase.*")
public class BaseTest {

}
