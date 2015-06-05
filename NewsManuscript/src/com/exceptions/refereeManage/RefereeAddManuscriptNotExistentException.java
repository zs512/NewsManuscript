package com.exceptions.refereeManage;

/**
 * Created by ruanqx on 2015/6/5.
 */
public class RefereeAddManuscriptNotExistentException extends Exception{
    public RefereeAddManuscriptNotExistentException(){}
    public RefereeAddManuscriptNotExistentException(String message){
        super(message);
    }
}
