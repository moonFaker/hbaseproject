
package com.hbase.api;


import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.Arrays;
import java.util.List;


/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/5 18:46
 **/

public class HBaseUtil {

/**
     * 创建hbase表
     * @param tableName 表名
     * @param cfs 列族的数组
     * @return 是否创建成功
     */

    public  static  boolean createTable(String tableName,String[]cfs){
        try {
          HBaseAdmin admin= ( HBaseAdmin)HBaseConn.getHbaseConn().getAdmin();
          if(admin.tableExists(tableName)){
              return  false;
          }else{
              final HTableDescriptor tableDescriptor=new HTableDescriptor(TableName.valueOf(tableName));
              Arrays.stream(cfs).forEach(cf->{
                  HColumnDescriptor columnDescriptor=new HColumnDescriptor(cf);
                  columnDescriptor.setMaxVersions(1);
                  tableDescriptor.addFamily(columnDescriptor);
              });
              admin.createTable(tableDescriptor);
          }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  true;
    }


/**
     * 删除hbase表
     * @param tableName 表名
     * @return 是否创建成功
     *//*

    public  static  boolean deleteTable(String tableName){
        try {
            HBaseAdmin admin= ( HBaseAdmin)HBaseConn.getHbaseConn().getAdmin();
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  true;
    }


/**
     * hbase插入一条数据
     * @param tableName 表名
     * @param rowKey 唯一标识
     * @param cfName 列族名
     * @param qualifier 列标识
     * @param data 数据
     * @return 是否插入成功
     */
    public  static  boolean putRow(String tableName,String rowKey,String cfName,String qualifier,String data){
    try {
        Table table=HBaseConn.getTable(tableName);
        Put put=new Put((Bytes.toBytes(rowKey)));
        put.addColumn(Bytes.toBytes(cfName),Bytes.toBytes(qualifier),Bytes.toBytes(data));
        table.put(put);
    }catch (Exception e){
        e.printStackTrace();
    }
    return  true;
    }

    public  static  boolean putRows(String tableName, List<Put>puts){
        try {
            Table table=HBaseConn.getTable(tableName);
            table.put(puts);
        }catch (Exception e){
            e.printStackTrace();
        }

        return  true;
    }



/**
     * 获取单条数据
     * @param tableName  表名
     * @param rowKey 唯一标识
     * @return
     */

    public  static Result getRow(String tableName,String rowKey){

        try {
            Table table=HBaseConn.getTable(tableName);
            Get get=new Get(Bytes.toBytes(rowKey));
            return table.get(get);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public  static Result getRow(String tableName, String rowKey, FilterList filterList){
        try {
            Table table=HBaseConn.getTable(tableName);
            Get get=new Get(Bytes.toBytes(rowKey));
            get.setFilter(filterList);
            return table.get(get);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    public  static ResultScanner getScanner(String tableName){
        try {
            Table table=HBaseConn.getTable(tableName);
            Scan scan=new Scan();
            scan.setCaching(1000);
            return  table.getScanner(scan);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }


/**
     * 批量检索数据
     * @param tableName 表名
     * @param startRowKey  起始rowkey
     * @param endRowKey  终止rowkey
     * @return
     *//*

    public  static ResultScanner getScanner(String tableName,String startRowKey,String endRowKey){
        try {
            Table table=HBaseConn.getTable(tableName);
            Scan scan=new Scan();
            scan.setCaching(1000);
            scan.setStartRow(Bytes.toBytes(startRowKey));
            scan.setStopRow(Bytes.toBytes(endRowKey));
            return  table.getScanner(scan);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }


/**
     * 批量检索数据
     * @param tableName 表名
     * @param startRowKey  起始rowkey
     * @param endRowKey  终止rowkey
     * @return
     */

    public  static ResultScanner getScanner(String tableName,String startRowKey,String endRowKey,FilterList filterList){
        try {
            Table table=HBaseConn.getTable(tableName);
            Scan scan=new Scan();
            scan.setCaching(1000);
            scan.setStartRow(Bytes.toBytes(startRowKey));
            scan.setStopRow(Bytes.toBytes(endRowKey));
            scan.setFilter(filterList);
            return  table.getScanner(scan);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }


/**
     * 删除一行记录
     * @param tableName 表名
     * @param rowKey 唯一标识
     * @return  是否成功标识
     */

    public  static  boolean deleteRow(String tableName,String rowKey){
        try {
            Table table=HBaseConn.getTable(tableName);

            Delete delete=new Delete(Bytes.toBytes(rowKey));
            table.delete(delete);


        }catch (Exception e){
            e.printStackTrace();
        }
        return  true;
    }


    public  static  boolean  deleteColumnFamily(String tableName,String cfName){
        try {
            HBaseAdmin admin=(HBaseAdmin)HBaseConn.getHbaseConn().getAdmin();
             admin.deleteColumn(tableName,cfName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  true;

    }

    public  static  boolean  deleteColumnQualifier(String tableName,String rowKey,String cfName,String qualifer){
        try {
            Table table=HBaseConn.getTable(tableName);
            Delete delete =new Delete( Bytes.toBytes(rowKey));
            delete.addColumn(Bytes.toBytes(cfName),Bytes.toBytes(qualifer));
            table.delete(delete);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  true;

    }
}

