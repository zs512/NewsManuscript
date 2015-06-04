package com.exceptions.manuscriptManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptAddAuthorNotExistentException extends Exception{
    public ManuscriptAddAuthorNotExistentException(){}
    public ManuscriptAddAuthorNotExistentException(String message){
        super(message);
    }
}
