package com.exceptions.manuscriptTypeManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptTypeDelNotExistentException extends Exception{
    public ManuscriptTypeDelNotExistentException(){}
    public ManuscriptTypeDelNotExistentException(String message){
        super(message);
    }
}
