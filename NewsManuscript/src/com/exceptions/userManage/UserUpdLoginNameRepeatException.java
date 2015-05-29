package com.exceptions.userManage;

/**
 * Created by ruanqx on 2015/5/29.
 */
public class UserUpdLoginNameRepeatException extends Exception{
    public UserUpdLoginNameRepeatException(){}
    public UserUpdLoginNameRepeatException(String message){
        super(message);
    }
}
