package com.exceptions.manuscriptManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptCheckBeforeDelException extends Exception{
    public ManuscriptCheckBeforeDelException(){}
    public ManuscriptCheckBeforeDelException(String message){
        super(message);
    }
}
