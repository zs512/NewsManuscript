package com.exceptions.manuscriptTypeManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptTypeAddNameIsExistentException extends Exception{
    public ManuscriptTypeAddNameIsExistentException(){}
    public ManuscriptTypeAddNameIsExistentException(String message){
        super(message);
    }
}
