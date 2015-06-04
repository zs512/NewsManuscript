package com.exceptions.manuscriptManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptAddUpdatePersonNotExistentException extends Exception{
    public ManuscriptAddUpdatePersonNotExistentException(){}
    public ManuscriptAddUpdatePersonNotExistentException(String message){
        super(message);
    }
}
