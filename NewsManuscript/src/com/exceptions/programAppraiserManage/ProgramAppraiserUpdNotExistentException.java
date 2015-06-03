package com.exceptions.programAppraiserManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ProgramAppraiserUpdNotExistentException extends Exception{
    public ProgramAppraiserUpdNotExistentException(){}
    public ProgramAppraiserUpdNotExistentException(String message){
        super(message);
    }
}
