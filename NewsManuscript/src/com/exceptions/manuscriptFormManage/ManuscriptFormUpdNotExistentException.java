package com.exceptions.manuscriptFormManage;

/**
 * Created by ruan on 6/7/15.
 */
public class ManuscriptFormUpdNotExistentException extends Exception{
    public ManuscriptFormUpdNotExistentException(){}
    public ManuscriptFormUpdNotExistentException(String message){
        super(message);
    }
}
