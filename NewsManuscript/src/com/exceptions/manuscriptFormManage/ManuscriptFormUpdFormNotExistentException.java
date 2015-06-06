package com.exceptions.manuscriptFormManage;

/**
 * Created by ruan on 6/7/15.
 */
public class ManuscriptFormUpdFormNotExistentException extends Exception{
    public ManuscriptFormUpdFormNotExistentException(){}
    public ManuscriptFormUpdFormNotExistentException(String message){
        super(message);
    }
}
