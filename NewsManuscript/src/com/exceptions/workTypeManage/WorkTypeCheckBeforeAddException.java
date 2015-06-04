package com.exceptions.workTypeManage;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class WorkTypeCheckBeforeAddException extends Exception{
    public WorkTypeCheckBeforeAddException(){}
    public WorkTypeCheckBeforeAddException(String message){
        super(message);
    }
}
