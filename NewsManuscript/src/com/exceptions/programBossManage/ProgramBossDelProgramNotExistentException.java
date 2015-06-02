package com.exceptions.programBossManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramBossDelProgramNotExistentException extends Exception{
    public ProgramBossDelProgramNotExistentException(){}
    public ProgramBossDelProgramNotExistentException(String message){
        super(message);
    }
}
