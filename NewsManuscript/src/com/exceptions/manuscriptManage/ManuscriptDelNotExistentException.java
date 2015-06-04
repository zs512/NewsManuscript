package com.exceptions.manuscriptManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptDelNotExistentException extends Exception{
    public ManuscriptDelNotExistentException(){}
    public ManuscriptDelNotExistentException(String message){
        super(message);
    }
}
