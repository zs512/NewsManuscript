package com.exceptions.userManage;

/**
 * Created by ruanqx on 2015/5/29.
 */
public class UserAddDepartmentNotExistentException extends Exception{
    public UserAddDepartmentNotExistentException(){}
    public UserAddDepartmentNotExistentException(String message){
        super(message);
    }
}
