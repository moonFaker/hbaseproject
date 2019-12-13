
import com.hbase.api.HBaseConn;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Table;
import org.junit.Test;


/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/5 18:22
 **/

public class HbaseConnTest {

    @Test
    public  void getConnTest() {

        Connection connection=HBaseConn.getHbaseConn();
        System.out.println(connection.isClosed());
    }
    @Test
    public  void getTableTest() {
      Table table= HBaseConn.getTable("FileTable");
      if(table!=null){
          System.out.println(table.getName().getNameAsString());
      }
    }
}
