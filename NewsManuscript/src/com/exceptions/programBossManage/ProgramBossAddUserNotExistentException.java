package com.exceptions.programBossManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramBossAddUserNotExistentException extends Exception{
    public ProgramBossAddUserNotExistentException(){}
    public ProgramBossAddUserNotExistentException(String message){
        super(message);
    }
}
