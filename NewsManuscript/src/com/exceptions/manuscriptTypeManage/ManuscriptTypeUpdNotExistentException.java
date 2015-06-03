package com.exceptions.manuscriptTypeManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptTypeUpdNotExistentException extends Exception{
    public ManuscriptTypeUpdNotExistentException(){}
    public ManuscriptTypeUpdNotExistentException(String message){
        super(message);
    }
}
