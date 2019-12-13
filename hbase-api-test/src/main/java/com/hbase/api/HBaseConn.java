
package com.hbase.api;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;


/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/5 18:16
 **/


public class HBaseConn {

    private  static  final HBaseConn INSTANCE=new HBaseConn();
    private static Configuration configuration;
   private  static Connection connection;
   private HBaseConn(){
       try {
           if(configuration==null){
               configuration=HBaseConfiguration.create();
               configuration.set("hbase.zookeeper.quorum","47.110.76.197:2181");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
   }

   private  Connection getConnection(){
       if(connection==null||connection.isClosed()){
           try {
               connection=ConnectionFactory.createConnection(configuration);
           }catch (Exception e){
               e.printStackTrace();
           }
       }
       return  connection;
   }

   public   static  Connection getHbaseConn(){
       return INSTANCE.getConnection();
   }
   public  static Table getTable(String tableName){
       try {
           return  INSTANCE.getConnection().getTable(TableName.valueOf(tableName));

       }catch (Exception e){
           e.printStackTrace();
       }
       return  null;
   }

   private  static  void closeConn(){
       if(connection!=null){
           try {
                connection.close();
           }catch (Exception e){
               e.printStackTrace();
           }
       }
   }

}

