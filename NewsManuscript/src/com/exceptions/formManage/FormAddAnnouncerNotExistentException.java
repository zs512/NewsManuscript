package com.exceptions.formManage;

/**
 * Created by ruan on 6/6/15.
 */
public class FormAddAnnouncerNotExistentException extends Exception{
    public FormAddAnnouncerNotExistentException(){}
    public FormAddAnnouncerNotExistentException(String message){
        super(message);
    }
}
