package com.exceptions.programDutyEditorManage;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramDutyEditorNotExistentException extends Exception{
    public ProgramDutyEditorNotExistentException(){}
    public ProgramDutyEditorNotExistentException(String message){
        super(message);
    }
}
