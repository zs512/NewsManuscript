package com.exceptions.programProducerManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramProducerAddUserNotExistentException extends Exception{
    public ProgramProducerAddUserNotExistentException(){}
    public ProgramProducerAddUserNotExistentException(String message){
        super(message);
    }
}
