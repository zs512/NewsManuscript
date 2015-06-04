package com.exceptions.manuscriptManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptAddManuscriptTypeNotExistentException extends Exception{
    public ManuscriptAddManuscriptTypeNotExistentException(){}
    public ManuscriptAddManuscriptTypeNotExistentException(String message){
        super(message);
    }
}
