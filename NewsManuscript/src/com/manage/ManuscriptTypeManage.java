package com.manage;

import com.dao.ComManuscriptTypeDAO;
import com.domain.ComManuscriptType;
import com.exceptions.manuscriptTypeManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ManuscriptTypeManage extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComManuscriptTypeDAO comManuscriptTypeDAO = (ComManuscriptTypeDAO)applicationContext.getBean("ComManuscriptTypeDAO");

    private boolean checkManuscriptTypeNameIsExistent(String manuscriptTypeName){

        List<ComManuscriptType> comManuscriptTypeList = comManuscriptTypeDAO.findByManuscripterTypeName(manuscriptTypeName);
        return (comManuscriptTypeList != null && comManuscriptTypeList.size() > 0);
    }

    private boolean checkManuscriptTypeIsExistent(String manuscriptTypeId){
        ComManuscriptType comManuscriptType = comManuscriptTypeDAO.findById(manuscriptTypeId);
        return (comManuscriptType != null && comManuscriptType.getManuscriptTypeId() != null);
    }

    private void checkBeforeAdd(ComManuscriptType manuscriptType) throws ManuscriptTypeCheckBeforeAddException{

        try{
            /*
             * check object manuscriptType
             */
            if(manuscriptType == null)
                throw new NullPointerException("manuscriptType is null");

            /*
             * check manuscript type name
             */
            if(manuscriptType.getManuscripterTypeName() == null)
                throw new NullPointerException("manuscriptType is null");
            else if(!checkSizeIsLegal(manuscriptType.getManuscripterTypeName(), 1, 32))
                throw new ManuscriptTypeAddNameSizeException("size of manuscriptType's name is not in (0, 32]");
            else if(checkManuscriptTypeNameIsExistent(manuscriptType.getManuscripterTypeName()))
                throw new ManuscriptTypeAddNameIsExistentException("manuscriptType's name is existent");
        }catch(ManuscriptTypeAddNameSizeException e){
            e.printStackTrace();
            throw new ManuscriptTypeCheckBeforeAddException();
        }catch(ManuscriptTypeAddNameIsExistentException e){
            e.printStackTrace();
            throw new ManuscriptTypeCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComManuscriptType manuscriptType) throws ManuscriptTypeCheckBeforeDelException{

        try{
            /*
             * check object
             */
            if(manuscriptType == null || manuscriptType.getManuscriptTypeId() == null)
                throw new NullPointerException("manuscriptType is null");

            /*
             * check manuscriptType is existent or not
             */
            if(!checkManuscriptTypeIsExistent(manuscriptType.getManuscriptTypeId()))
                throw new ManuscriptTypeDelNotExistentException("manuscriptType is not existent");

        }catch(ManuscriptTypeDelNotExistentException e){
            e.printStackTrace();
            throw new ManuscriptTypeCheckBeforeDelException();
        }
    }

    private void checkBeforeUpd(ComManuscriptType manuscriptType) throws ManuscriptTypeCheckBeforeUpdException{

        try{
            /*
             * check object
             */
            if(manuscriptType == null || manuscriptType.getManuscriptTypeId() == null)
                throw new NullPointerException("manuscriptType is null");

            /*
             * check manuscriptType is existent or not
             */
            if(!checkManuscriptTypeIsExistent(manuscriptType.getManuscriptTypeId()))
                throw new ManuscriptTypeUpdNotExistentException("manuscriptType is not existent");

            /*
             * check manuscriptType name
             */
            ComManuscriptType comManuscriptType = comManuscriptTypeDAO.findById(manuscriptType.getManuscriptTypeId());

            if(manuscriptType.getManuscripterTypeName() == null)
                throw new NullPointerException("manuscriptType's name is null");
            else if(!comManuscriptType.getManuscripterTypeName().equals(manuscriptType.getManuscripterTypeName())){
                if(!checkSizeIsLegal(manuscriptType.getManuscripterTypeName(), 1, 32))
                    throw new ManuscriptTypeUpdNameSizeException("size of manuscriptType's name is not in (0,32]");
                if(checkManuscriptTypeNameIsExistent(manuscriptType.getManuscripterTypeName()))
                    throw new ManuscriptTypeUpdNameRepeatException("manuscriptType's name is existent");
            }
        }catch(ManuscriptTypeUpdNotExistentException e){
            e.printStackTrace();
            throw new ManuscriptTypeCheckBeforeUpdException();
        }catch(ManuscriptTypeUpdNameSizeException e){
            e.printStackTrace();
            throw new ManuscriptTypeCheckBeforeUpdException();
        }catch(ManuscriptTypeUpdNameRepeatException e){
            e.printStackTrace();
            throw new ManuscriptTypeCheckBeforeUpdException();
        }
    }

    public void addManuscriptType(ComManuscriptType manuscriptType){

        try{
            checkBeforeAdd(manuscriptType);

            manuscriptType.setStatus(0);
            comManuscriptTypeDAO.save(manuscriptType);
        }catch(ManuscriptTypeCheckBeforeAddException e){
            e.printStackTrace();
        }
    }

    public void delManuscript(ComManuscriptType manuscriptType){

        try{
            checkBeforeDel(manuscriptType);

            manuscriptType.setStatus(1);
            comManuscriptTypeDAO.attachDirty(manuscriptType);
        }catch(ManuscriptTypeCheckBeforeDelException e){
            e.printStackTrace();
        }
    }

    public void updManuscript(ComManuscriptType manuscriptType){

        try{
            checkBeforeUpd(manuscriptType);

            manuscriptType.setStatus(0);
            comManuscriptTypeDAO.attachDirty(manuscriptType);
        }catch(ManuscriptTypeCheckBeforeUpdException e){
            e.printStackTrace();
        }
    }
}
