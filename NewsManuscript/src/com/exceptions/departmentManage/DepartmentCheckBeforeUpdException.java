package com.exceptions.departmentManage;

/**
 * Created by ruanqx on 2015/5/29.
 */
public class DepartmentCheckBeforeUpdException extends Exception{
    public DepartmentCheckBeforeUpdException(){}
    public DepartmentCheckBeforeUpdException(String message){
        super(message);
    }
}
