package com.exceptions.programProducerManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramProducerUpdProgramNotExistentException extends Exception{
    public ProgramProducerUpdProgramNotExistentException(){}
    public ProgramProducerUpdProgramNotExistentException(String message){
        super(message);
    }
}
