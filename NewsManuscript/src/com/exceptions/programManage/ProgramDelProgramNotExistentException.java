package com.exceptions.programManage;

/**
 * Created by ruanqx on 2015/6/1.
 */
public class ProgramDelProgramNotExistentException extends Exception{
    public ProgramDelProgramNotExistentException(){}
    public ProgramDelProgramNotExistentException(String message){
        super(message);
    }
}
