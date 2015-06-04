package com.exceptions.manuscriptManage;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptCheckBeforeAddException extends Exception{
    public ManuscriptCheckBeforeAddException(){}
    public ManuscriptCheckBeforeAddException(String message){
        super(message);
    }
}
