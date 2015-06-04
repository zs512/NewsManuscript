package com.exceptions.manuscriptWorkTypeManage;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class ManuscriptWorkTypeAddManuscriptNotExistentException extends Exception{
    public ManuscriptWorkTypeAddManuscriptNotExistentException(){}
    public ManuscriptWorkTypeAddManuscriptNotExistentException(String message){
        super(message);
    }
}
