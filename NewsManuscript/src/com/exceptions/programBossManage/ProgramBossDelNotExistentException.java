package com.exceptions.programBossManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramBossDelNotExistentException extends Exception{
    public ProgramBossDelNotExistentException(){}
    public ProgramBossDelNotExistentException(String message){
        super(message);
    }
}
