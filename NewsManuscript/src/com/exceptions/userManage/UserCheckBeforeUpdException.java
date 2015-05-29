package com.exceptions.userManage;

/**
 * Created by ruanqx on 2015/5/29.
 */
public class UserCheckBeforeUpdException extends Exception{
    public UserCheckBeforeUpdException(){}
    public UserCheckBeforeUpdException(String message){
        super(message);
    }
}
