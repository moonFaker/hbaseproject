package com.hbase.core.usermgr;

import com.hbase.core.HosException;

/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/9 18:12
 **/
public class HosUsermgrException extends HosException {
    private int code;
    private  String message;
    public  HosUsermgrException(int code,String message,Throwable cause){
        super(message,cause);
        this.code=code;
        this.message=message;
    }
    public  HosUsermgrException(int code,String message){
        super(message,null);
        this.code=code;
        this.message=message;
    }
    public  int getCode(){
        return  code;
    }
    public  String getMessage(){
        return  message;
    }

    @Override
    public int errorCode() {
        return this.code;
    }
}
