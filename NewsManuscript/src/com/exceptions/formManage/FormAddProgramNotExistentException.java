package com.exceptions.formManage;

/**
 * Created by ruan on 6/6/15.
 */
public class FormAddProgramNotExistentException extends Exception{
    public FormAddProgramNotExistentException(){}
    public FormAddProgramNotExistentException(String message){
        super(message);
    }
}
