package com.exceptions.departmentManage;

/**
 * Created by ruanqx on 2015/5/29.
 */
public class DepartmentCheckBeforeDelException extends Exception{
    public DepartmentCheckBeforeDelException(){}
    public DepartmentCheckBeforeDelException(String message){
        super(message);
    }
}
