package com.hbase.core.usermgr;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/9 18:17
 **/
public class CoreUtil {

    public  final  static String SYSTEM_USER="SuperAdmin";

    public  static  String getUUIDStr(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public  static  String getMd5Password(String str){
        String reStr=null;
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            byte[]bytes=md5.digest(str.getBytes());
            StringBuffer stringBuffer=new StringBuffer();
            for (byte aByte : bytes) {
                int bt =aByte&0xff;
                if(bt<16){
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr=stringBuffer.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  reStr;
    }
}
