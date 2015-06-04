package com.exceptions.manuscriptWorkTypeManage;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class ManuscriptWorkTypeAddWorkTypeNotExistentException extends Exception{
    public ManuscriptWorkTypeAddWorkTypeNotExistentException(){}
    public ManuscriptWorkTypeAddWorkTypeNotExistentException(String message){
        super(message);
    }
}
