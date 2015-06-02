package com.exceptions.programChiefManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramChiefAddProgramNotExistentException extends Exception{
    public ProgramChiefAddProgramNotExistentException(){}
    public ProgramChiefAddProgramNotExistentException(String message){
        super(message);
    }
}
