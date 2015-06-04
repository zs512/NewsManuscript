package com.exceptions.workTypeManage;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class WorkTypeCheckBeforeDelException extends Exception{
    public WorkTypeCheckBeforeDelException(){}
    public WorkTypeCheckBeforeDelException(String message){
        super(message);
    }
}
