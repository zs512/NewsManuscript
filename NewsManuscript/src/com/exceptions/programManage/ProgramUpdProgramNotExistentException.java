package com.exceptions.programManage;

/**
 * Created by ruanqx on 2015/6/1.
 */
public class ProgramUpdProgramNotExistentException extends Exception{
    public ProgramUpdProgramNotExistentException(){}
    public ProgramUpdProgramNotExistentException(String message){
        super(message);
    }
}
