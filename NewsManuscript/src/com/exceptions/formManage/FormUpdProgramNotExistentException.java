package com.exceptions.formManage;

/**
 * Created by ruan on 6/6/15.
 */
public class FormUpdProgramNotExistentException extends Exception{
    public FormUpdProgramNotExistentException(){}
    public FormUpdProgramNotExistentException(String message){
        super(message);
    }
}
