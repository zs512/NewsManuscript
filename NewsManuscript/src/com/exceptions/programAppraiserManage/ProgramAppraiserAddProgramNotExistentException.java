package com.exceptions.programAppraiserManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ProgramAppraiserAddProgramNotExistentException extends Exception{
    public ProgramAppraiserAddProgramNotExistentException(){}
    public ProgramAppraiserAddProgramNotExistentException(String message){
        super(message);
    }
}
