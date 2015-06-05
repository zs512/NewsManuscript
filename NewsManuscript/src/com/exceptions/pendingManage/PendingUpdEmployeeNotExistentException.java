package com.exceptions.pendingManage;

/**
 * Created by ruanqx on 2015/6/5.
 */
public class PendingUpdEmployeeNotExistentException extends Exception{
    public PendingUpdEmployeeNotExistentException(){}
    public PendingUpdEmployeeNotExistentException(String message){
        super(message);
    }
}
