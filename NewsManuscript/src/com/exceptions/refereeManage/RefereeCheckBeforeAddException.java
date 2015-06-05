package com.exceptions.refereeManage;

/**
 * Created by ruanqx on 2015/6/5.
 */
public class RefereeCheckBeforeAddException extends Exception{
    public RefereeCheckBeforeAddException(){}
    public RefereeCheckBeforeAddException(String message){
        super(message);
    }
}
