package com.manage;

import com.dao.ComManuscriptDAO;
import com.dao.ComManuscriptTypeDAO;
import com.dao.ComUserDAO;
import com.domain.ComManuscript;
import com.domain.ComManuscriptType;
import com.domain.ComUser;
import com.exceptions.manuscriptManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptManage extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComManuscriptDAO comManuscriptDAO = (ComManuscriptDAO)applicationContext.getBean("ComManuscriptDAO");
    ComUserDAO comUserDAO = (ComUserDAO)applicationContext.getBean("ComUserDAO");
    ComManuscriptTypeDAO comManuscriptTypeDAO = (ComManuscriptTypeDAO)applicationContext.getBean("ComManuscriptTypeDAO");

    private boolean checkUserIsExistent(String authorId){
        ComUser comUser = comUserDAO.findById(authorId);
        return (comUser != null && comUser.getUserId() != null);
    }

    private boolean checkManuscriptTypeIsExistent(String manuscriptTypeId){
        ComManuscriptType comManuscriptType = comManuscriptTypeDAO.findById(manuscriptTypeId);
        return (comManuscriptType != null && comManuscriptType.getManuscriptTypeId() != null);
    }

    private boolean checkManuscriptIsExistent(String manuscriptId){
        ComManuscript comManuscript = comManuscriptDAO.findById(manuscriptId);
        return (comManuscript != null && comManuscript.getManuscriptId() != null);
    }

    private void checkBeforeAdd(ComManuscript manuscript) throws ManuscriptCheckBeforeAddException{

        try{
            /*
             * check object
             */
            if(manuscript == null)
                throw new NullPointerException("manuscript is null");

            /*
             * check author
             */
            if(manuscript.getComUserByAuthorId() == null)
                throw new NullPointerException("manuscript's author is null");
            else if(!checkUserIsExistent(manuscript.getComUserByAuthorId().getUserId()))
                throw new ManuscriptAddAuthorNotExistentException("manuscript's author is not existent");

            /*
             * check update person
             */
            if(manuscript.getComUserByUpdatePersonId() == null)
                throw new NullPointerException("manuscript's update person is null");
            else if(!checkUserIsExistent(manuscript.getComUserByUpdatePersonId().getUserId()))
                throw new ManuscriptAddUpdatePersonNotExistentException("manuscript's update person is not existent");

            /*
             * check manuscriptType
             */
            if(manuscript.getComManuscriptType() == null)
                throw new NullPointerException("manuscript's manuscriptType is null");
            else if(!checkManuscriptTypeIsExistent(manuscript.getComManuscriptType().getManuscriptTypeId()))
                throw new ManuscriptAddManuscriptTypeNotExistentException("manuscript's manuscriptType is not existent");

            /*
             * check manuscript's title
             */
            if(manuscript.getManuscriptTitle() != null)
                if(!checkSizeIsLegal(manuscript.getManuscriptTitle(), 0, 50))
                    throw new ManuscriptAddTitleSizeException("size of manuscript's title is not in [0, 50]");

            /*
             * check manuscript's body
             */
            if(manuscript.getManuscriptBody() != null)
                if(!checkSizeIsLegal(manuscript.getManuscriptBody(), 0, 2000))
                    throw new ManuscriptAddBodySizeException("size of manuscript's body is not in [0, 2000]");

            /*
             * check create time
             */
            if(manuscript.getCreateTime() == null)
                throw new NullPointerException("manuscript' create time is null");

            /*
             * check update time
             */
            if(manuscript.getUpdateTime() == null)
                throw new NullPointerException("manuscript's update time is null");
            else if(manuscript.getUpdateTime().compareTo(manuscript.getCreateTime()) < 0)
                throw new ManuscriptAddCreateUpdateTimeCompareException("updateTime should more than createTime");

            /*
             * check manuscript's path
             */
            if(manuscript.getManuscriptPath() == null)
                throw new NullPointerException("manuscript's path is null");
            else if(!checkSizeIsLegal(manuscript.getManuscriptPath(), 1, 500))
                throw new ManuscriptAddPathSizeException("file's path is not in (0, 500]");

        }catch(ManuscriptAddAuthorNotExistentException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeAddException();
        }catch(ManuscriptAddUpdatePersonNotExistentException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeAddException();
        }catch(ManuscriptAddManuscriptTypeNotExistentException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeAddException();
        }catch(ManuscriptAddTitleSizeException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeAddException();
        }catch(ManuscriptAddBodySizeException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeAddException();
        }catch(ManuscriptAddCreateUpdateTimeCompareException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeAddException();
        }catch(ManuscriptAddPathSizeException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComManuscript manuscript) throws ManuscriptCheckBeforeDelException{

        try{
            /*
             * check object
             */
            if(manuscript == null || manuscript.getManuscriptId() == null)
                throw new NullPointerException("manuscript is null");

            /*
             * check manuscript is existent
             */
            if(!checkManuscriptIsExistent(manuscript.getManuscriptId()))
                throw new ManuscriptDelNotExistentException("manuscript is not existent");
        }catch(ManuscriptDelNotExistentException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeDelException();
        }
    }

    private void checkBeforeUpd(ComManuscript manuscript) throws ManuscriptCheckBeforeUpdException{

        try{
            /*
             * check object
             */
            if(manuscript == null || manuscript.getManuscriptId() == null)
                throw new NullPointerException("manuscript is null");

            /*
             * check manuscript is existent
             */
            if(!checkManuscriptIsExistent(manuscript.getManuscriptId()))
                throw new ManuscriptUpdNotExistentException("manuscript is not existent");

            /*
             * check author
             */
            if(manuscript.getComUserByAuthorId() == null)
                throw new NullPointerException("manuscript's author is null");
            else if(!checkUserIsExistent(manuscript.getComUserByAuthorId().getUserId()))
                throw new ManuscriptUpdAuthorNotExistentException("manuscript's author is not existent");

            /*
             * check person
             */
            if(manuscript.getComUserByUpdatePersonId() == null)
                throw new NullPointerException("manuscript's update person is null");
            else if(!checkUserIsExistent(manuscript.getComUserByUpdatePersonId().getUserId()))
                throw new ManuscriptUpdUpdatePersonNotExistentException("manuscript's update person is not existent");

            /*
             * check manuscriptType
             */
            if(manuscript.getComManuscriptType() == null)
                throw new NullPointerException("manuscript's manuscriptType is null");
            else if(!checkManuscriptTypeIsExistent(manuscript.getComManuscriptType().getManuscriptTypeId()))
                throw new ManuscriptUpdManuscriptTypeNotExistentException("manuscript's manuscriptType is not existent");

            /*
             * check manuscript's title
             */
            if(manuscript.getManuscriptTitle() != null)
                if(!checkSizeIsLegal(manuscript.getManuscriptTitle(), 0, 50))
                    throw new ManuscriptUpdTitleSizeException("size of manuscript's title is not in [0, 50]");

            /*
             * check manuscript's body
             */
            if(manuscript.getManuscriptBody() != null)
                if(!checkSizeIsLegal(manuscript.getManuscriptBody(), 0, 2000))
                    throw new ManuscriptUpdBodySizeException("size of manuscript's body is not in [0, 2000]");

            /*
             * check manuscriptStatus
             */
            if(manuscript.getManuscriptStatus() < 0 || manuscript.getManuscriptStatus() > 3)
                throw new ManuscriptUpdManuscriptStatusException("manuscriptStatue is not in [0, 3]");

            /*
             * check create time
             */
            if(manuscript.getCreateTime() == null)
                throw new NullPointerException("manuscript' create time is null");

            /*
             * check update time
             */
            if(manuscript.getUpdateTime() == null)
                throw new NullPointerException("manuscript's update time is null");
            else if(manuscript.getUpdateTime().compareTo(manuscript.getCreateTime()) < 0)
                throw new ManuscriptUpdCreateUpdateTimeCompareException("updateTime should more than createTime");

            /*
             * check manuscript's path
             */
            if(manuscript.getManuscriptPath() == null)
                throw new NullPointerException("manuscript's path is null");
            else if(!checkSizeIsLegal(manuscript.getManuscriptPath(), 1, 500))
                throw new ManuscriptUpdPathSizeException("file's path is not in (0, 500]");

        }catch(ManuscriptUpdNotExistentException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeUpdException();
        }catch(ManuscriptUpdAuthorNotExistentException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeUpdException();
        }catch(ManuscriptUpdUpdatePersonNotExistentException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeUpdException();
        }catch(ManuscriptUpdManuscriptTypeNotExistentException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeUpdException();
        }catch(ManuscriptUpdTitleSizeException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeUpdException();
        }catch(ManuscriptUpdBodySizeException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeUpdException();
        }catch(ManuscriptUpdManuscriptStatusException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeUpdException();
        }catch(ManuscriptUpdCreateUpdateTimeCompareException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeUpdException();
        }catch(ManuscriptUpdPathSizeException e){
            System.out.println(e.toString());
            throw new ManuscriptCheckBeforeUpdException();
        }
    }

    public void addManuscript(ComManuscript manuscript){

        try{
            checkBeforeAdd(manuscript);

            manuscript.setManuscriptStatus(0);
            manuscript.setStatus(0);
            comManuscriptDAO.save(manuscript);
        }catch(ManuscriptCheckBeforeAddException e){
            System.out.println(e.toString());
        }
    }

    public void delManuscript(ComManuscript manuscript){

        try{
            checkBeforeDel(manuscript);

            manuscript.setStatus(1);
            comManuscriptDAO.attachDirty(manuscript);
        }catch(ManuscriptCheckBeforeDelException e){
            System.out.println(e.toString());
        }
    }

    public void updManuscript(ComManuscript manuscript){

        try{
            checkBeforeUpd(manuscript);

            manuscript.setStatus(0);
            comManuscriptDAO.attachDirty(manuscript);
        }catch(ManuscriptCheckBeforeUpdException e){
            System.out.println(e.toString());
        }
    }
}
