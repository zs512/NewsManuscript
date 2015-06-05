package com.exceptions.pendingManage;

/**
 * Created by ruanqx on 2015/6/5.
 */
public class PendingUpdNotExistentException extends Exception{
    public PendingUpdNotExistentException(){}
    public PendingUpdNotExistentException(String message){
        super(message);
    }
}
