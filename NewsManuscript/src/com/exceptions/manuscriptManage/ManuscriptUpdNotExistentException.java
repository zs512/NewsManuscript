package com.exceptions.manuscriptManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptUpdNotExistentException extends Exception{
    public ManuscriptUpdNotExistentException(){}
    public ManuscriptUpdNotExistentException(String message){
        super(message);
    }
}
