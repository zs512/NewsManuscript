package com.manage;

import com.dao.ComManuscriptDAO;
import com.dao.ComManuscriptTypeDAO;
import com.dao.ComRefereeDAO;
import com.dao.ComUserDAO;
import com.domain.ComManuscript;
import com.domain.ComManuscriptType;
import com.domain.ComReferee;
import com.domain.ComUser;
import com.exceptions.refereeManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruanqx on 2015/6/5.
 */
public class Referee extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComRefereeDAO comRefereeDAO = (ComRefereeDAO)applicationContext.getBean("ComRefereeDAO");
    ComUserDAO comUserDAO = (ComUserDAO)applicationContext.getBean("ComUserDAO");
    ComManuscriptTypeDAO comManuscriptTypeDAO = (ComManuscriptTypeDAO)applicationContext.getBean("ComManuscriptTypeDAO");
    ComManuscriptDAO comManuscriptDAO = (ComManuscriptDAO)applicationContext.getBean("ComManuscriptDAO");

    private boolean checkRefereePersonIsExistent(String refereeId){
        if(refereeId == null) return false;
        ComUser comUser = comUserDAO.findById(refereeId);
        return (comUser != null && comUser.getUserId() != null);
    }

    private boolean checkManuscriptTypeIsExistent(String manuscriptTypeId){
        if(manuscriptTypeId == null) return false;
        ComManuscriptType comManuscriptType = comManuscriptTypeDAO.findById(manuscriptTypeId);
        return (comManuscriptType != null && comManuscriptType.getManuscriptTypeId() != null);
    }

    private boolean checkManuscriptIsExistent(String manuscriptId){
        if(manuscriptId == null) return false;
        ComManuscript comManuscript = comManuscriptDAO.findById(manuscriptId);
        return (comManuscript != null && comManuscript.getManuscriptId() != null);
    }

    private void checkBeforeAdd(ComReferee referee) throws RefereeCheckBeforeAddException {

        try{
            /*
             * check object
             */
            if(referee == null)
                throw new NullPointerException("referee is null");

            /*
             * check referee person
             */
            if(referee.getComUser() == null)
                throw new NullPointerException("referee's person is null");
            else if(referee.getComUser().getUserId() == null)
                throw new NullPointerException("referee's person's id is null");
            else if(!checkRefereePersonIsExistent(referee.getComUser().getUserId()))
                throw new RefereeAddRefereePersonNotExistentException("referee person is null or is not existent");

            /*
             * check manuscript type
             */
            if(referee.getComManuscriptType() == null)
                throw new NullPointerException("referee's manuscriptType is null");
            else if(referee.getComManuscriptType().getManuscriptTypeId() == null)
                throw new NullPointerException("referee's manuscriptType's id is null");
            else if(!checkManuscriptTypeIsExistent(referee.getComManuscriptType().getManuscriptTypeId()))
                throw new RefereeAddManuscriptTypeNotExistentException("manuscriptType is null or is not existent");

            /*
             * check manuscript
             */
            if(referee.getComManuscript() == null)
                throw new NullPointerException("referee's manuscript is null");
            else if(referee.getComManuscript().getManuscriptId() == null)
                throw new NullPointerException("referee's manuscript's id is null");
            else if(!checkManuscriptIsExistent(referee.getComManuscript().getManuscriptId()))
                throw new RefereeAddManuscriptNotExistentException("manuscript is null or is not existent");

            /*
             * check referee time
             */
            if(referee.getRefereeTime() == null)
                throw new NullPointerException("refereeTime is null");

            /*
             * check referee result
             */
            if(referee.getRefereeResult() < 0 || referee.getRefereeResult() > 3)
                throw new RefereeAddResultException("refereeResult is not in [0, 3]");


        }catch(RefereeAddRefereePersonNotExistentException e){
            e.printStackTrace();
            throw new RefereeCheckBeforeAddException();
        }catch(RefereeAddManuscriptTypeNotExistentException e){
            e.printStackTrace();
            throw new RefereeCheckBeforeAddException();
        }catch(RefereeAddManuscriptNotExistentException e){
            e.printStackTrace();
            throw new RefereeCheckBeforeAddException();
        }catch(RefereeAddResultException e){
            e.printStackTrace();
            throw new RefereeCheckBeforeAddException();
        }
    }

    public void addReferee(ComReferee referee){


    }
}
