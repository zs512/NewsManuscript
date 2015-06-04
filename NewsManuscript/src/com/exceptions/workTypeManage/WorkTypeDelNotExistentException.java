package com.exceptions.workTypeManage;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class WorkTypeDelNotExistentException extends Exception{
    public WorkTypeDelNotExistentException(){}
    public WorkTypeDelNotExistentException(String message){
        super(message);
    }
}
