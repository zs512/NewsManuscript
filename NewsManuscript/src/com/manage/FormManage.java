package com.manage;

import com.dao.ComFormDAO;
import com.dao.ComProgramDAO;
import com.dao.ComUserDAO;
import com.domain.ComForm;
import com.domain.ComProgram;
import com.domain.ComUser;
import com.exceptions.formManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruan on 6/6/15.
 */
public class FormManage extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComFormDAO comFormDAO = (ComFormDAO)applicationContext.getBean("ComFormDAO");
    ComProgramDAO comProgramDAO = (ComProgramDAO)applicationContext.getBean("ComProgramDAO");
    ComUserDAO comUserDAO = (ComUserDAO)applicationContext.getBean("ComUserDAO");


    private boolean checkProgramIsExistent(String programId){
        if(programId == null) return false;
        ComProgram comProgram = comProgramDAO.findById(programId);
        return (comProgram != null && comProgram.getProgramId() != null);
    }

    private boolean checkUserIsExistent(String userId){
        if(userId == null) return false;
        ComUser comUser = comUserDAO.findById(userId);
        return (comUser != null && comUser.getUserId() != null);
    }

    private boolean checkFormIsExistent(String formId){
        ComForm comForm = comFormDAO.findById(formId);
        return (comForm != null && comForm.getFormId() != null);
    }

    private void checkBeforeAdd(ComForm form) throws FormCheckBeforeAddException {

        try{
            /*
             * check object
             */
            if(form != null)
                throw new NullPointerException("form is null");

            /*
             * check program
             */
            if(form.getComProgram() == null)
                throw new NullPointerException("form's program is null");
            else if(!checkProgramIsExistent(form.getComProgram().getProgramId()))
                throw new FormAddProgramNotExistentException("form's program is null or is not existent");

            /*
             * check editorCharge
             */
            if(form.getComUserByEditorChargeId() == null)
                throw new NullPointerException("form's EditorCharge is null");
            else if(!checkUserIsExistent(form.getComUserByEditorChargeId().getUserId()))
                throw new FormAddEditorChargeNotExistentException("form's EditorCharge is null or is not existent");

            /*
             * check announcer
             */
            if(form.getComUserByAnnouncerId() == null)
                throw new NullPointerException("form's announcer is null");
            else if(!checkUserIsExistent(form.getComUserByAnnouncerId().getUserId()))
                throw new FormAddAnnouncerNotExistentException("form's announcer is null or is not existent");

            /*
             * check producer
             */
            if(form.getComUserByProducerId() == null)
                throw new NullPointerException("form's producer is null");
            else if(!checkUserIsExistent(form.getComUserByProducerId().getUserId()))
                throw new FormAddProducerNotExistentException("form's producer is null or is not existent");
            /*
             * check form status
             */
            if(form.getFormStatus() < 0 || form.getFormStatus() > 3)
                throw new FormAddFormStatusException("form's status is not in (0, 3]");

        }catch(FormAddProgramNotExistentException e){
            e.printStackTrace();
            throw new FormCheckBeforeAddException();
        }catch(FormAddEditorChargeNotExistentException e){
            e.printStackTrace();
            throw new FormCheckBeforeAddException();
        }catch(FormAddAnnouncerNotExistentException e){
            e.printStackTrace();
            throw new FormCheckBeforeAddException();
        }catch(FormAddProducerNotExistentException e){
            e.printStackTrace();
            throw new FormCheckBeforeAddException();
        }catch(FormAddFormStatusException e){
            e.printStackTrace();
            throw new FormCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComForm form) throws FormCheckBeforeDelException {

        try{
            /*
             * check object
             */
            if(form == null || form.getFormId() == null)
                throw new NullPointerException("form is null");

            /*
             * check form is existent or not
             */
            if(!checkFormIsExistent(form.getFormId()))
                throw new FormDelNotExistentException("form is not existent");

        }catch(FormDelNotExistentException e){
            e.printStackTrace();
            throw new FormCheckBeforeDelException();
        }
    }


    private void checkBeforeUpd(ComForm form) throws FormCheckBeforeUpdException {

        try{
            /*
             * check object
             */
            if(form == null || form.getFormId() == null)
                throw new NullPointerException("form is null");

            /*
             * check form is existent or not
             */
            if(!checkFormIsExistent(form.getFormId()))
                throw new FormUpdNotExistentException("form is not existent");

            /*
             * check program
             */
            if(form.getComProgram() == null)
                throw new NullPointerException("form's program is null");
            else if(!checkProgramIsExistent(form.getComProgram().getProgramId()))
                throw new FormUpdProgramNotExistentException("form's program is null or is not existent");
            /*
             * check editorCharge
             */
            if(form.getComUserByEditorChargeId() == null)
                throw new NullPointerException("form's EditorCharge is null");
            else if(!checkUserIsExistent(form.getComUserByEditorChargeId().getUserId()))
                throw new FormUpdEditorChargeNotExistentException("form's EditorCharge is null or is not existent");

            /*
             * check announcer
             */
            if(form.getComUserByAnnouncerId() == null)
                throw new NullPointerException("form's announcer is null");
            else if(!checkUserIsExistent(form.getComUserByAnnouncerId().getUserId()))
                throw new FormUpdAnnouncerNotExistentException("form's announcer is null or is not existent");

            /*
             * check producer
             */
            if(form.getComUserByProducerId() == null)
                throw new NullPointerException("form's producer is null");
            else if(!checkUserIsExistent(form.getComUserByProducerId().getUserId()))
                throw new FormUpdProducerNotExistentException("form's producer is null or is not existent");
            /*
             * check form status
             */
            if(form.getFormStatus() < 0 || form.getFormStatus() > 3)
                throw new FormUpdFormStatusException("form's status is not in (0, 3]");

        }catch(FormUpdNotExistentException e) {
            e.printStackTrace();
            throw new FormCheckBeforeUpdException();
        }catch(FormUpdProducerNotExistentException e) {
            e.printStackTrace();
            throw new FormCheckBeforeUpdException();
        }catch(FormUpdProgramNotExistentException e) {
            e.printStackTrace();
            throw new FormCheckBeforeUpdException();
        }catch(FormUpdEditorChargeNotExistentException e) {
            e.printStackTrace();
            throw new FormCheckBeforeUpdException();
        }catch(FormUpdAnnouncerNotExistentException e) {
            e.printStackTrace();
            throw new FormCheckBeforeUpdException();
        }catch(FormUpdFormStatusException e) {
            e.printStackTrace();
            throw new FormCheckBeforeUpdException();
        }
    }

    public void addForm(ComForm form){

        try{
            checkBeforeAdd(form);

            form.setStatus(0);
            comFormDAO.save(form);
        }catch(FormCheckBeforeAddException e){
            e.printStackTrace();
        }

    }

    public void delForm(ComForm form){

        try{
            checkBeforeDel(form);

            form.setStatus(1);
            comFormDAO.attachDirty(form);
        }catch(FormCheckBeforeDelException e){
            e.printStackTrace();
        }
    }

    public void updForm(ComForm form){

        try{
            checkBeforeUpd(form);

            form.setStatus(0);
            comFormDAO.attachDirty(form);
        }catch(FormCheckBeforeUpdException e){
            e.printStackTrace();
        }

    }
}
