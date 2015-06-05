package com.exceptions.refereeManage;

/**
 * Created by ruanqx on 2015/6/5.
 */
public class RefereeAddRefereePersonNotExistentException extends Exception{
    public RefereeAddRefereePersonNotExistentException(){}
    public RefereeAddRefereePersonNotExistentException(String message){
        super(message);
    }
}
