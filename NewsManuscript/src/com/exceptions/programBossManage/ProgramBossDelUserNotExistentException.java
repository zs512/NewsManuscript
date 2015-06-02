package com.exceptions.programBossManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramBossDelUserNotExistentException extends Exception{
    public ProgramBossDelUserNotExistentException(){}
    public ProgramBossDelUserNotExistentException(String message){
        super(message);
    }
}
