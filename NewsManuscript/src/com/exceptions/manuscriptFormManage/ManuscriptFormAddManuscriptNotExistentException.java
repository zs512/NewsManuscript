package com.exceptions.manuscriptFormManage;

/**
 * Created by ruan on 6/6/15.
 */
public class ManuscriptFormAddManuscriptNotExistentException extends Exception{
    public ManuscriptFormAddManuscriptNotExistentException(){}
    public ManuscriptFormAddManuscriptNotExistentException(String message){
        super(message);
    }
}
