package com.exceptions.userManage;

/**
 * Created by ruanqx on 2015/5/29.
 */
public class UserDelUserNotExistentException extends Exception{
    public UserDelUserNotExistentException(){}
    public UserDelUserNotExistentException(String message){
        super(message);
    }
}
