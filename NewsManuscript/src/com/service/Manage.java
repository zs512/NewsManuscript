package com.service;

/**
 * Created by ruanqx on 2015/5/30.
 */
public class Manage {

    protected boolean checkSizeIsLegal(String departmentName, int leftBoundary, int rightBoundary){
        return (departmentName.length() >= leftBoundary && departmentName.length() <= rightBoundary);
    }
}
