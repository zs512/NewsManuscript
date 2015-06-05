package com.exceptions.pendingManage;

/**
 * Created by ruanqx on 2015/6/5.
 */
public class PendingUpdManuscriptNotExistentException extends Exception{
    public PendingUpdManuscriptNotExistentException(){}
    public PendingUpdManuscriptNotExistentException(String message){
        super(message);
    }
}
