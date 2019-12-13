
import com.hbase.api.HBaseConn;
import com.hbase.api.HBaseUtil;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/5 21:03
 **/

public class HBaseUtilTest {

    @Test
    public  void  createTable(){
        System.out.println("123");
        HBaseUtil.createTable("FileTable4",new String[]{"fileInfo","saveInfo"});
    }

    @Test
    public  void addFileDetails(){
        HBaseUtil.putRow("FileTable","rowkey1","fileInfo","name","file1.txt");
        HBaseUtil.putRow("FileTable","rowkey1","fileInfo","type","txt");
        HBaseUtil.putRow("FileTable","rowkey1","fileInfo","size","1024");
        HBaseUtil.putRow("FileTable","rowkey1","saveInfo","creator","jixin");
        HBaseUtil.putRow("FileTable","rowkey2","fileInfo","name","file2.txt");
        HBaseUtil.putRow("FileTable","rowkey2","fileInfo","type","txt");
        HBaseUtil.putRow("FileTable","rowkey2","fileInfo","size","2048");
        HBaseUtil.putRow("FileTable","rowkey1","saveInfo","creator","luobin");
    }
    @Test
    public  void getFileDetails(){
        Result result= HBaseUtil.getRow("FileTable","rowkey1");
        if(result!=null){
            System.out.println("rowkey="+Bytes.toString(result.getRow()));
        }
    }
    @Test
    public  void writeImg(){
        try {
            Table table= HBaseConn.getTable("FileTable");
            FileInputStream inputStream=new FileInputStream("d:/treeicon_1.png");
            byte []b=new byte[inputStream.available()];
            inputStream.read(b);
            inputStream.close();

            Put put=new Put(Bytes.toBytes("rowkey3"));
            put.addColumn(Bytes.toBytes("fileInfo"),Bytes.toBytes("img"),b);
            table.put(put);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public  void getImg(){
        try {
            Table table= HBaseConn.getTable("FileTable");
            Get get=new Get(Bytes.toBytes("rowkey3"));
            Result result= table.get(get);
            byte []b=result.getValue(Bytes.toBytes("fileInfo"),Bytes.toBytes("img"));
            FileOutputStream outputStream=new FileOutputStream("d:/www.png");
            outputStream.write(b);
            outputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

