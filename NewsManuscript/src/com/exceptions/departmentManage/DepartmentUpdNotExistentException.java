package com.exceptions.departmentManage;

/**
 * Created by ruanqx on 2015/5/28.
 */
public class DepartmentUpdNotExistentException extends Exception{
    public DepartmentUpdNotExistentException(){}
    public DepartmentUpdNotExistentException(String message){
        super(message);
    }
}
