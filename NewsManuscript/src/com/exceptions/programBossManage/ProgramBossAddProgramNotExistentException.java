package com.exceptions.programBossManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramBossAddProgramNotExistentException extends Exception{
    public ProgramBossAddProgramNotExistentException(){}
    public ProgramBossAddProgramNotExistentException(String message){
        super(message);
    }
}
