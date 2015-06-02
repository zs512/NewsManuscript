package com.exceptions.programProducerManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramProducerUpdUserNotExistentException extends Exception{
    public ProgramProducerUpdUserNotExistentException(){}
    public ProgramProducerUpdUserNotExistentException(String message){
        super(message);
    }
}
