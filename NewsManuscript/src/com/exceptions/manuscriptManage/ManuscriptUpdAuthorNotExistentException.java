package com.exceptions.manuscriptManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptUpdAuthorNotExistentException extends Exception{
    public ManuscriptUpdAuthorNotExistentException(){}
    public ManuscriptUpdAuthorNotExistentException(String message){
        super(message);
    }
}
