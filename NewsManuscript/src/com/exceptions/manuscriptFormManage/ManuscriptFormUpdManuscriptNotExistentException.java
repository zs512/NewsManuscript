package com.exceptions.manuscriptFormManage;

/**
 * Created by ruan on 6/7/15.
 */
public class ManuscriptFormUpdManuscriptNotExistentException extends Exception{
    public ManuscriptFormUpdManuscriptNotExistentException(){}
    public ManuscriptFormUpdManuscriptNotExistentException(String message){
        super(message);
    }
}
