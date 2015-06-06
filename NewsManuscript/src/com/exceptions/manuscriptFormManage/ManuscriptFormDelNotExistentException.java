package com.exceptions.manuscriptFormManage;

/**
 * Created by ruan on 6/7/15.
 */
public class ManuscriptFormDelNotExistentException extends Exception{
    public ManuscriptFormDelNotExistentException(){}
    public ManuscriptFormDelNotExistentException(String message){
        super(message);
    }
}
