package com.exceptions.formManage;

/**
 * Created by ruan on 6/6/15.
 */
public class FormCheckBeforeUpdException extends Exception{
    public FormCheckBeforeUpdException(){}
    public FormCheckBeforeUpdException(String message){
        super(message);
    }
}
