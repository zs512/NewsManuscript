package com.exceptions.pendingManage;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class PendingCheckBeforeAddException extends Exception{
    public PendingCheckBeforeAddException(){}
    public PendingCheckBeforeAddException(String message){
        super(message);
    }
}
