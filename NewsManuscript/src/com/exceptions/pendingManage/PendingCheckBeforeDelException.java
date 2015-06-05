package com.exceptions.pendingManage;

/**
 * Created by ruanqx on 2015/6/5.
 */
public class PendingCheckBeforeDelException extends Exception{
    public PendingCheckBeforeDelException(){}
    public PendingCheckBeforeDelException(String message){
        super(message);
    }
}
