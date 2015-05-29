package com.exceptions.userManage;

/**
 * Created by ruanqx on 2015/5/29.
 */
public class UserCheckBeforeDelException extends Exception{
    public UserCheckBeforeDelException(){}
    public UserCheckBeforeDelException(String message){
        super(message);
    }
}
