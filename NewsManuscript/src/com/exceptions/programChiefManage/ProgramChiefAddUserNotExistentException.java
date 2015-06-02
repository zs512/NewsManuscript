package com.exceptions.programChiefManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramChiefAddUserNotExistentException extends Exception{
    public ProgramChiefAddUserNotExistentException(){}
    public ProgramChiefAddUserNotExistentException(String message){
        super(message);
    }
}
