package com.exceptions.formManage;

/**
 * Created by ruan on 6/6/15.
 */
public class FormAddProducerNotExistentException extends Exception{
    public FormAddProducerNotExistentException(){}
    public FormAddProducerNotExistentException(String message){
        super(message);
    }
}
