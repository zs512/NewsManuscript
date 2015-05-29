package com.exceptions.departmentManage;

/**
 * Created by ruanqx on 2015/5/28.
 */
public class DepartmentDelSubdepartmentExistentException extends Exception{
    public DepartmentDelSubdepartmentExistentException(){}
    public DepartmentDelSubdepartmentExistentException(String message){
        super(message);
    }
}
