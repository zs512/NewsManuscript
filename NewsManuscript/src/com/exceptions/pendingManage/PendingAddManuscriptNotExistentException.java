package com.exceptions.pendingManage;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class PendingAddManuscriptNotExistentException extends Exception{
    public PendingAddManuscriptNotExistentException(){}
    public PendingAddManuscriptNotExistentException(String message){
        super(message);
    }
}
