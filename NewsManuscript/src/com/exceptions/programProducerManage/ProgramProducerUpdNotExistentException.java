package com.exceptions.programProducerManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramProducerUpdNotExistentException extends Exception{
    public ProgramProducerUpdNotExistentException(){}
    public ProgramProducerUpdNotExistentException(String message){
        super(message);
    }
}
