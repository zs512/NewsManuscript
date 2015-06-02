package com.exceptions.programChiefManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramChiefUpdNotExistentException extends Exception{
    public ProgramChiefUpdNotExistentException(){}
    public ProgramChiefUpdNotExistentException(String message){
        super(message);
    }
}
