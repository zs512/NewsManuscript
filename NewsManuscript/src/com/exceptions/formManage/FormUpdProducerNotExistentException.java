package com.exceptions.formManage;

/**
 * Created by ruan on 6/6/15.
 */
public class FormUpdProducerNotExistentException extends Exception{
    public FormUpdProducerNotExistentException(){}
    public FormUpdProducerNotExistentException(String message){
        super(message);
    }
}
