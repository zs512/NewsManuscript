package com.exceptions.formManage;

/**
 * Created by ruan on 6/6/15.
 */
public class FormDelNotExistentException extends Exception{
    public FormDelNotExistentException(){}
    public FormDelNotExistentException(String message){
        super(message);
    }
}
