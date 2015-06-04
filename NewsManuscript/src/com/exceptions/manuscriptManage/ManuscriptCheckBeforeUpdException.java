package com.exceptions.manuscriptManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptCheckBeforeUpdException extends Exception{
    public ManuscriptCheckBeforeUpdException(){}
    public ManuscriptCheckBeforeUpdException(String message){
        super(message);
    }
}
