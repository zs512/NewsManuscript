package com.exceptions.programAppraiserManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ProgramAppraiserDelNotExistentException extends Exception{
    public ProgramAppraiserDelNotExistentException(){}
    public ProgramAppraiserDelNotExistentException(String message){
        super(message);
    }
}
