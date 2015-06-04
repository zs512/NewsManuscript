package com.exceptions.workTypeManage;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class WorkTypeUpdNameRepeatException extends Exception{
    public WorkTypeUpdNameRepeatException(){}
    public WorkTypeUpdNameRepeatException(String message){
        super(message);
    }
}
