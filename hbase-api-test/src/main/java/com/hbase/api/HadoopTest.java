
package com.hbase.api;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FSInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;


/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/10 11:02
 **/

public class HadoopTest {

    public static void main(String[] args) throws Exception {


        Configuration configuration=new Configuration();
        configuration.set("dfs.client.use.datanode.hostname","true");
        FileSystem fileSystem=FileSystem.get(new URI("hdfs://47.110.76.197:9000"),configuration,"root");
        Path path=new Path("/testhdfs/wwww.txt");
     /*        ;
        FSDataOutputStream fsDataOutputStream= fileSystem.create(path);

        FileInputStream fis=new FileInputStream("d:/a.txt");
        byte[] b=new byte[1024];
        while((fis.read(b))!=-1){
            fsDataOutputStream.write(b);
        }
        fsDataOutputStream.close();
        fis.close();
*/

 FSDataInputStream fsDataInputStream= fileSystem.open(path);

      FileOutputStream fileOutputStream=new FileOutputStream("d:/www2.txt");
        byte[] b=new byte[1024];
        while((fsDataInputStream.read(b))!=-1){
            fileOutputStream.write(b);
        }

        fileOutputStream.close();
        fsDataInputStream.close();



    }
}

