package com.exceptions.workTypeManage;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class WorkTypeUpdNotExistentException extends Exception{
    public WorkTypeUpdNotExistentException(){}
    public WorkTypeUpdNotExistentException(String message){
        super(message);
    }
}
