package com.exceptions.pendingManage;

/**
 * Created by ruanqx on 2015/6/5.
 */
public class PendingCheckBeforeUpdException extends Exception{
    public PendingCheckBeforeUpdException(){}
    public PendingCheckBeforeUpdException(String message){
        super(message);
    }
}
