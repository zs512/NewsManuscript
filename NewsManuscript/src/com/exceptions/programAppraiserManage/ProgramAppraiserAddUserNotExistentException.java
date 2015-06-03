package com.exceptions.programAppraiserManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ProgramAppraiserAddUserNotExistentException extends Exception{
    public ProgramAppraiserAddUserNotExistentException(){}
    public ProgramAppraiserAddUserNotExistentException(String message){
        super(message);
    }
}
