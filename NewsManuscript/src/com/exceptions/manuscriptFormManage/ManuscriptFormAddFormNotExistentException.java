package com.exceptions.manuscriptFormManage;

/**
 * Created by ruan on 6/6/15.
 */
public class ManuscriptFormAddFormNotExistentException extends Exception{
    public ManuscriptFormAddFormNotExistentException(){}
    public ManuscriptFormAddFormNotExistentException(String message){
        super(message);
    }
}
