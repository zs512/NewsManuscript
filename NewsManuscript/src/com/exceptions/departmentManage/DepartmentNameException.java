package com.exceptions.departmentManage;

import com.service.DepartmentManage;

/**
 * Created by ruanqx on 2015/5/28.
 */
public class DepartmentNameException extends Exception{
    public DepartmentNameException(){}
    public DepartmentNameException(String message){
        super(message);
    }
}
