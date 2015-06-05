package com.exceptions.pendingManage;

/**
 * Created by ruanqx on 2015/6/5.
 */
public class PendingAddEmployeeNotExistentException extends Exception{
    public PendingAddEmployeeNotExistentException(){}
    public PendingAddEmployeeNotExistentException(String message){
        super(message);
    }
}
