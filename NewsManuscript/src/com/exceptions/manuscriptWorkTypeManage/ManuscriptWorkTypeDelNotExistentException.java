package com.exceptions.manuscriptWorkTypeManage;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class ManuscriptWorkTypeDelNotExistentException extends Exception{
    public ManuscriptWorkTypeDelNotExistentException(){}
    public ManuscriptWorkTypeDelNotExistentException(String message){
        super(message);
    }
}
