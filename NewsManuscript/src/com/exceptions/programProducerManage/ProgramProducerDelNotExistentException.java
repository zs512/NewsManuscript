package com.exceptions.programProducerManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramProducerDelNotExistentException extends Exception{
    public ProgramProducerDelNotExistentException(){}
    public ProgramProducerDelNotExistentException(String message){
        super(message);
    }
}
