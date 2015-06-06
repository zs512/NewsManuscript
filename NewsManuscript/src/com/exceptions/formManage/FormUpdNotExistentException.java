package com.exceptions.formManage;

/**
 * Created by ruan on 6/6/15.
 */
public class FormUpdNotExistentException extends Exception{
    public FormUpdNotExistentException(){}
    public FormUpdNotExistentException(String message){
        super(message);
    }
}
