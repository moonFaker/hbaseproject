package com.hbase.core;

/**
 * @Description TODO
 * @Aauthor lb
 * @Date 2019/12/9 18:02
 **/
public abstract class HosException extends RuntimeException {
    protected String errorMessage;
    public  HosException(String message,Throwable cause){
        super(cause);
        this.errorMessage=message;
    }

    public  abstract  int errorCode();
    public  String errorMessage(){
        return  this.errorMessage;
    }
}
