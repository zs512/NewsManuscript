package com.manage;

import com.dao.ComManuscriptDAO;
import com.dao.ComPendingDAO;
import com.dao.ComUserDAO;
import com.domain.ComManuscript;
import com.domain.ComPending;
import com.domain.ComUser;
import com.exceptions.pendingManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class PendingManage extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComPendingDAO comPendingDAO = (ComPendingDAO)applicationContext.getBean("ComPendingDAO");
    ComManuscriptDAO comManuscriptDAO = (ComManuscriptDAO)applicationContext.getBean("ComManuscriptDAO");
    ComUserDAO comUserDAO = (ComUserDAO)applicationContext.getBean("ComUserDAO");

    private boolean checkManuscriptIsExistent(String manuscriptId){
        ComManuscript comManuscript = comManuscriptDAO.findById(manuscriptId);
        return (comManuscript != null && comManuscript.getManuscriptId() != null);
    }

    private boolean checkEmployeeIsExistent(String userId){
        ComUser comUser = comUserDAO.findById(userId);
        return (comUser != null && comUser.getUserId() != null);
    }

    private boolean checkPendingIsExistent(String pendingId){
        ComPending comPending = comPendingDAO.findById(pendingId);
        return (comPending != null && comPending.getPendingId() != null);
    }

    private void checkBeforeAdd(ComPending pending) throws PendingCheckBeforeAddException{

        try{
            /*
             * check object
             */
            if(pending == null)
                throw new NullPointerException("pending is null");

            /*
             * check manuscript
             */
            if(pending.getComManuscript() == null || pending.getComManuscript().getManuscriptId() == null)
                throw new NullPointerException("pending's manuscript is null");
            else if(!checkManuscriptIsExistent(pending.getComManuscript().getManuscriptId()))
                throw new PendingAddManuscriptNotExistentException("pending's manuscript is not existent");

            /*
             * check referee person
             */
            if(pending.getComUser() == null || pending.getComUser().getUserId() == null)
                throw new NullPointerException("pending's manuscript is null");
            else if(!checkEmployeeIsExistent(pending.getComUser().getUserId()))
                throw new PendingAddEmployeeNotExistentException("pending's employee is not existent");

        }catch(PendingAddManuscriptNotExistentException e){
            e.printStackTrace();
            throw new PendingCheckBeforeAddException();
        }catch(PendingAddEmployeeNotExistentException e){
            e.printStackTrace();
            throw new PendingCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComPending pending) throws PendingCheckBeforeDelException {

        try{
            /*
             * check object
             */
            if(pending == null || pending.getPendingId() == null)
                throw new NullPointerException("pending is null");

            /*
             * check pending is existent or not
             */
            if(!checkPendingIsExistent(pending.getPendingId()))
                throw new PendingDelNotExistentException("pending is not existent");

        }catch(PendingDelNotExistentException e){
            e.printStackTrace();
            throw new PendingCheckBeforeDelException();
        }

    }

    private void checkBeforeUpd(ComPending pending) throws PendingCheckBeforeUpdException {

        try{
            /*
             * check object
             */
            if(pending == null || pending.getPendingId() == null)
                throw new NullPointerException("pending is null");

            /*
             * check pending is existent or not
             */
            if(!checkPendingIsExistent(pending.getPendingId()))
                throw new PendingUpdNotExistentException("pending is not existent");

            /*
             * check manuscript is existent or not
             */
            if(pending.getComManuscript() == null || pending.getComManuscript().getManuscriptId() == null)
                throw new NullPointerException("pending's manuscript is null");
            if(!checkManuscriptIsExistent(pending.getComManuscript().getManuscriptId()))
                throw new PendingUpdManuscriptNotExistentException("pending's manuscript is not existent");

            /*
             * check referee person
             */
            if(pending.getComUser() == null || pending.getComUser().getUserId() == null)
                throw new NullPointerException("pending's manuscript is null");
            if(!checkEmployeeIsExistent(pending.getComUser().getUserId()))
                throw new PendingUpdEmployeeNotExistentException("pending's employee is not existent");

        }catch(PendingUpdNotExistentException e){
            e.printStackTrace();
            throw new PendingCheckBeforeUpdException();
        }catch(PendingUpdManuscriptNotExistentException e){
            e.printStackTrace();
            throw new PendingCheckBeforeUpdException();
        }catch(PendingUpdEmployeeNotExistentException e){
            e.printStackTrace();
            throw new PendingCheckBeforeUpdException();
        }
    }

    public void addPending(ComPending pending){

        try{
            checkBeforeAdd(pending);

            pending.setStatus(0);
            comPendingDAO.save(pending);
        }catch(PendingCheckBeforeAddException e){
            e.printStackTrace();
        }
    }

    public void delPending(ComPending pending){

        try{
            checkBeforeDel(pending);

            pending.setStatus(1);
            comPendingDAO.attachDirty(pending);
        }catch(PendingCheckBeforeDelException e){
            e.printStackTrace();
        }

    }

    public void updPending(ComPending pending){
        try{
            checkBeforeUpd(pending);

            pending.setStatus(0);
            comPendingDAO.attachDirty(pending);
        }catch(PendingCheckBeforeUpdException e){
            e.printStackTrace();
        }
    }
}
