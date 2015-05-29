package com.exceptions.userManage;

/**
 * Created by ruanqx on 2015/5/29.
 */
public class UserCheckBeforeAddException extends Exception{
    public UserCheckBeforeAddException(){}
    public UserCheckBeforeAddException(String message){
        super(message);
    }
}
