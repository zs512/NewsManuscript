package com.exceptions.programChiefManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramChiefDelNotExistentException extends Exception{
    public ProgramChiefDelNotExistentException(){}
    public ProgramChiefDelNotExistentException(String message){
        super(message);
    }
}
