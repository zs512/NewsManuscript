package com.exceptions.formManage;

/**
 * Created by ruan on 6/6/15.
 */
public class FormCheckBeforeDelException extends Exception{
    public FormCheckBeforeDelException(){}
    public FormCheckBeforeDelException(String message){
        super(message);
    }
}
