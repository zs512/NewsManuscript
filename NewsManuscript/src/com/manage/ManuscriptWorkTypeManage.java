package com.manage;

import com.dao.ComManuscriptDAO;
import com.dao.ComManuscriptWorkTypeDAO;
import com.dao.ComWorkTypeDAO;
import com.domain.ComManuscript;
import com.domain.ComManuscriptWorkType;
import com.domain.ComWorkType;
import com.exceptions.manuscriptWorkTypeManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class ManuscriptWorkTypeManage extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComManuscriptWorkTypeDAO comManuscriptWorkTypeDAO = (ComManuscriptWorkTypeDAO)applicationContext.getBean("ComManuscriptWorkTypeDAO");
    ComWorkTypeDAO comWorkTypeDAO = (ComWorkTypeDAO)applicationContext.getBean("ComWorkTypeDAO");
    ComManuscriptDAO comManuscriptDAO = (ComManuscriptDAO)applicationContext.getBean("ComManuscriptDAO");

    private boolean checkWorkTypeIsExistent(String workTypeId){
        ComWorkType comWorkType = comWorkTypeDAO.findById(workTypeId);
        return (comWorkType != null && comWorkType.getWorkTypeId() != null);
    }

    private boolean checkManuscriptIsExistent(String manuscriptId){
        ComManuscript comManuscript = comManuscriptDAO.findById(manuscriptId);
        return (comManuscript != null && comManuscript.getManuscriptId() != null);
    }

    private boolean checkManuscriptWorkTypeIsExistent(String manuscriptWorkTypeId){
        ComManuscriptWorkType comManuscriptWorkType = comManuscriptWorkTypeDAO.findById(manuscriptWorkTypeId);
        return (comManuscriptWorkType != null && comManuscriptWorkType.getManuscriptWorkTypeId() != null);
    }

    private void checkBeforeAdd(ComManuscriptWorkType manuscriptWorkType) throws ManuscriptWorkTypeCheckBeforeAddException {

        try{
            /*
             * check object
             */
            if(manuscriptWorkType == null)
                throw new NullPointerException("manuscriptWorkType is null");

            /*
             * check work type
             */
            if(manuscriptWorkType.getComWorkType() == null || manuscriptWorkType.getComWorkType().getWorkTypeId() == null)
                throw new NullPointerException("manuscriptWorkType's workType is null");
            else if(!checkWorkTypeIsExistent(manuscriptWorkType.getComWorkType().getWorkTypeId()))
                throw new ManuscriptWorkTypeAddWorkTypeNotExistentException("workType is not existent");

            /*
             * check manuscript
             */
            if(manuscriptWorkType.getComManuscript() == null || manuscriptWorkType.getComManuscript().getManuscriptId() == null)
                throw new NullPointerException("manuscriptWorkType's manuscript is null");
            else if(!checkManuscriptIsExistent(manuscriptWorkType.getComManuscript().getManuscriptId()))
                throw new ManuscriptWorkTypeAddManuscriptNotExistentException("manuscript is not existent");

        }catch(ManuscriptWorkTypeAddWorkTypeNotExistentException e){
            System.out.println(e.toString());
            throw new ManuscriptWorkTypeCheckBeforeAddException();
        }catch(ManuscriptWorkTypeAddManuscriptNotExistentException e){
            System.out.println(e.toString());
            throw new ManuscriptWorkTypeCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComManuscriptWorkType manuscriptWorkType) throws ManuscriptWorkTypeCheckBeforeDelException {

        try{
            /*
             * check object
             */
            if(manuscriptWorkType == null || manuscriptWorkType.getManuscriptWorkTypeId() == null)
                throw new NullPointerException("manuscriptWorkType is null");

            /*
             * check manuscriptWorkType is existent or not
             */
            if(!checkManuscriptWorkTypeIsExistent(manuscriptWorkType.getManuscriptWorkTypeId()))
                throw new ManuscriptWorkTypeDelNotExistentException("manuscriptWorkType is not existent");

        }catch(ManuscriptWorkTypeDelNotExistentException e){
            System.out.println(e.toString());
            throw new ManuscriptWorkTypeCheckBeforeDelException();
        }
    }

    public void addManuscriptWorkType(ComManuscriptWorkType manuscriptWorkType){

        try{
            checkBeforeAdd(manuscriptWorkType);

            manuscriptWorkType.setStatus(0);
            comManuscriptWorkTypeDAO.save(manuscriptWorkType);

        }catch(ManuscriptWorkTypeCheckBeforeAddException e){
            System.out.println(e.toString());
        }
    }

    public void delManuscriptWorkType(ComManuscriptWorkType manuscriptWorkType){

        try{
            checkBeforeDel(manuscriptWorkType);

            manuscriptWorkType.setStatus(0);
            comManuscriptWorkTypeDAO.attachDirty(manuscriptWorkType);
        }catch(ManuscriptWorkTypeCheckBeforeDelException e){
            System.out.println(e.toString());
        }
    }
}
