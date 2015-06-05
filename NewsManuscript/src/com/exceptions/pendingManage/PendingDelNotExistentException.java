package com.exceptions.pendingManage;

/**
 * Created by ruanqx on 2015/6/5.
 */
public class PendingDelNotExistentException extends Exception{
    public PendingDelNotExistentException(){}
    public PendingDelNotExistentException(String message){
        super(message);
    }
}
