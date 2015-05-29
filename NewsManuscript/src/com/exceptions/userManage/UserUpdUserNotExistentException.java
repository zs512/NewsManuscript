package com.exceptions.userManage;

/**
 * Created by ruanqx on 2015/5/29.
 */
public class UserUpdUserNotExistentException extends Exception{
    public UserUpdUserNotExistentException(){}
    public UserUpdUserNotExistentException(String message){
        super(message);
    }
}
