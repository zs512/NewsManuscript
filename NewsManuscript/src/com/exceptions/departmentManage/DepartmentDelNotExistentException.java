package com.exceptions.departmentManage;

/**
 * Created by ruanqx on 2015/5/28.
 */
public class DepartmentDelNotExistentException extends Exception{
    public DepartmentDelNotExistentException(){}
    public DepartmentDelNotExistentException(String message){
        super(message);
    }
}
