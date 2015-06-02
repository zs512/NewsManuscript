package com.exceptions.programBossManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramBossUpdNotExistentException extends Exception{
    public ProgramBossUpdNotExistentException(){}
    public ProgramBossUpdNotExistentException(String message){
        super(message);
    }
}
