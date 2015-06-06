package com.manage;

import com.dao.ComFormDAO;
import com.dao.ComManuscriptDAO;
import com.dao.ComManuscriptFormDAO;
import com.domain.ComForm;
import com.domain.ComManuscript;
import com.domain.ComManuscriptForm;
import com.exceptions.manuscriptFormManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruan on 6/6/15.
 */
public class ManuscriptFormManage extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComManuscriptFormDAO comManuscriptFormDAO = (ComManuscriptFormDAO)applicationContext.getBean("ComManuscriptFormDAO");
    ComManuscriptDAO comManuscriptDAO = (ComManuscriptDAO)applicationContext.getBean("ComManuscriptDAO");
    ComFormDAO comFormDAO = (ComFormDAO)applicationContext.getBean("ComFormDAO");

    private boolean checkManuscriptIsExistent(String manuscriptId){
        if(manuscriptId == null) return false;
        ComManuscript comManuscript = comManuscriptDAO.findById(manuscriptId);
        return (comManuscript != null && comManuscript.getManuscriptId() != null);
    }

    private boolean checkFormIsExistent(String formId){
        if(formId == null) return false;
        ComForm comForm = comFormDAO.findById(formId);
        return (comForm != null && comForm.getFormId() != null);
    }

    private boolean checkManuscriptFormIsExistent(String manuscriptFormId){
        if(manuscriptFormId == null) return false;
        ComManuscriptForm comManuscriptForm = comManuscriptFormDAO.findById(manuscriptFormId);
        return (comManuscriptForm != null && comManuscriptForm.getManuscriptFormId() != null);
    }

    private void checkBeforeAdd(ComManuscriptForm manuscriptForm) throws ManuscriptFormCheckBeforeAddException {

        try{
            /*
             * check object
             */
            if(manuscriptForm == null)
                throw new NullPointerException("manuscriptForm is null");

            /*
             * check manuscript
             */
            if(manuscriptForm.getComManuscript() == null)
                throw new NullPointerException("manuscriptForm's manuscript is null");
            else if(!checkManuscriptIsExistent(manuscriptForm.getComManuscript().getManuscriptId()))
                throw new ManuscriptFormAddManuscriptNotExistentException();

            /*
             * check form
             */
            if(manuscriptForm.getComForm() == null)
                throw new NullPointerException("manuscriptForm's form is null");
            else if(!checkFormIsExistent(manuscriptForm.getComForm().getFormId()))
                throw new ManuscriptFormAddFormNotExistentException();

            /*
             * check serial number
             */
            if(manuscriptForm.getSerialNumber() <= 0)
                throw new ManuscriptFormAddSerialNumberException("serial number is less than 1");


        }catch(ManuscriptFormAddManuscriptNotExistentException e) {
            e.printStackTrace();
            throw new ManuscriptFormCheckBeforeAddException();
        }catch(ManuscriptFormAddFormNotExistentException e) {
            e.printStackTrace();
            throw new ManuscriptFormCheckBeforeAddException();
        }catch(ManuscriptFormAddSerialNumberException e) {
            e.printStackTrace();
            throw new ManuscriptFormCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComManuscriptForm manuscriptForm) throws ManuscriptFormCheckBeforeDelException {

        try{
            /*
             * check object
             */
            if(manuscriptForm == null || manuscriptForm.getManuscriptFormId() == null)
                throw new NullPointerException("manuscriptForm is null");

            /*
             * check manuscriptForm is existent or not
             */
            if(!checkManuscriptFormIsExistent(manuscriptForm.getManuscriptFormId()))
                throw new ManuscriptFormDelNotExistentException("manuscriptForm is null or is not existent");

        }catch(ManuscriptFormDelNotExistentException e){
            e.printStackTrace();
            throw new ManuscriptFormCheckBeforeDelException();
        }
    }

    private void checkBeforeUpd(ComManuscriptForm manuscriptForm) throws ManuscriptFormCheckBeforeUpdException{

        try{
            /*
             * check object
             */
            if(manuscriptForm == null || manuscriptForm.getManuscriptFormId() == null)
                throw new NullPointerException("manuscriptForm is null");

            /*
             * check manuscriptForm is existent or not
             */
            if(!checkManuscriptFormIsExistent(manuscriptForm.getManuscriptFormId()))
                throw new ManuscriptFormUpdNotExistentException("manuscript is null or is not existent");

            /*
             * check manuscript
             */
            if(manuscriptForm.getComManuscript() == null)
                throw new NullPointerException("manuscriptForm's manuscript is null");
            else if(!checkManuscriptIsExistent(manuscriptForm.getComManuscript().getManuscriptId()))
                throw new ManuscriptFormUpdManuscriptNotExistentException();

            /*
             * check form
             */
            if(manuscriptForm.getComForm() == null)
                throw new NullPointerException("manuscriptForm's form is null");
            else if(!checkFormIsExistent(manuscriptForm.getComForm().getFormId()))
                throw new ManuscriptFormUpdFormNotExistentException();

            /*
             * check serial number
             */
            if(manuscriptForm.getSerialNumber() <= 0)
                throw new ManuscriptFormUpdSerialNumberException("serial number is less than 1");

        }catch(ManuscriptFormUpdNotExistentException e){
            e.printStackTrace();
            throw new ManuscriptFormCheckBeforeUpdException();
        }catch(ManuscriptFormUpdSerialNumberException e) {
            e.printStackTrace();
            throw new ManuscriptFormCheckBeforeUpdException();
        }catch(ManuscriptFormUpdFormNotExistentException e) {
            e.printStackTrace();
            throw new ManuscriptFormCheckBeforeUpdException();
        }catch(ManuscriptFormUpdManuscriptNotExistentException e) {
            e.printStackTrace();
            throw new ManuscriptFormCheckBeforeUpdException();
        }
    }

    public void addManuscriptForm(ComManuscriptForm manuscriptForm){

        try{
            checkBeforeAdd(manuscriptForm);

            manuscriptForm.setStatus(0);
            comManuscriptFormDAO.save(manuscriptForm);
        }catch(ManuscriptFormCheckBeforeAddException e){
            e.printStackTrace();
        }
    }

    public void delManuscriptForm(ComManuscriptForm manuscriptForm){

        try{
            checkBeforeDel(manuscriptForm);

            manuscriptForm.setStatus(1);
            comManuscriptFormDAO.attachDirty(manuscriptForm);
        }catch(ManuscriptFormCheckBeforeDelException e){
            e.printStackTrace();
        }

    }

    public void updManuscriptForm(ComManuscriptForm manuscriptForm){

        try{
            checkBeforeUpd(manuscriptForm);

            manuscriptForm.setStatus(0);
            comManuscriptFormDAO.attachDirty(manuscriptForm);
        }catch(ManuscriptFormCheckBeforeUpdException e){
            e.printStackTrace();
        }
    }
}
