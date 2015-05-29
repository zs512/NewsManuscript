package com.exceptions.departmentManage;

/**
 * Created by ruanqx on 2015/5/29.
 */
public class DepartmentCheckBeforeAddException extends Exception{
    public DepartmentCheckBeforeAddException(){}
    public DepartmentCheckBeforeAddException(String message){
        super(message);
    }
}
