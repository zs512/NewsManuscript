package com.exceptions.formManage;

/**
 * Created by ruan on 6/6/15.
 */
public class FormCheckBeforeAddException extends Exception{
    public FormCheckBeforeAddException(){}
    public FormCheckBeforeAddException(String message){
        super(message);
    }
}
