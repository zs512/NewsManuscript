package com.manage;

import com.dao.ComProgramDAO;
import com.dao.ComProgramEditorChargeDAO;
import com.dao.ComUserDAO;
import com.domain.ComProgramEditorCharge;
import com.exceptions.programEditorChargeManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruanqx on 2015/6/1.
 */
public class ProgramEditorChargeManage extends ProgramRelevant{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComProgramEditorChargeDAO comProgramEditorChargeDAO = (ComProgramEditorChargeDAO)applicationContext.getBean("ComProgramEditorChargeDAO");
    ComProgramDAO comProgramDAO = (ComProgramDAO)applicationContext.getBean("ComProgramDAO");
    ComUserDAO comUserDAO = (ComUserDAO)applicationContext.getBean("ComUserDAO");

    private boolean checkProgramEditorChargeIsExistent(String programEditorChargeId){
        ComProgramEditorCharge comProgramEditorCharge = comProgramEditorChargeDAO.findById(programEditorChargeId);
        return (comProgramEditorCharge != null && comProgramEditorCharge.getProgramEditorChargeId() != null);
    }

    private void checkBeforeAdd(ComProgramEditorCharge programEditorCharge) throws ProgramEditorChargeCheckBeforeAddException{

        try{
            /*
             * check object
             */
            if(programEditorCharge == null)
                throw new NullPointerException("programEditorCharge is null");

            /*
             * check program id
             */
            if(!checkProgramNotNullAndExistent(programEditorCharge.getComProgram()))
                throw new ProgramEditorChargeAddProgramNotExistentException("program is null or is not existent");

            /*
             * check user id
             */
            if(!checkUserNotNullAndExistent(programEditorCharge.getComUser()))
                throw new ProgramEditorChargeAddUserNotExistentException("user is null or is not existent");
        }catch(ProgramEditorChargeAddProgramNotExistentException e){
            e.printStackTrace();
            throw new ProgramEditorChargeCheckBeforeAddException();
        }catch(ProgramEditorChargeAddUserNotExistentException e){
            e.printStackTrace();
            throw new ProgramEditorChargeCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComProgramEditorCharge programEditorCharge) throws ProgramEditorChargeCheckBeforeDelException{

        try{
            /*
             * check object
             */
            if(programEditorCharge == null)
                throw new NullPointerException("programEditorCharge is null");

            /*
             * check programEditorCharge
             */
            if(programEditorCharge.getProgramEditorChargeId() == null)
                throw new NullPointerException("programEditorCharge's id is null");
            else if(!checkProgramEditorChargeIsExistent(programEditorCharge.getProgramEditorChargeId()))
                throw new ProgramEditorChargeDelNotExistent("programEditorCharge is not existent");
        }catch(ProgramEditorChargeDelNotExistent e){
            e.printStackTrace();
            throw new ProgramEditorChargeCheckBeforeDelException();
        }
    }

    private void checkBeforeUpd(ComProgramEditorCharge programEditorCharge) throws ProgramEditorChargeCheckBeforeUpdException{

        try {
            /*
             * check object
             */
            if (programEditorCharge == null || programEditorCharge.getProgramEditorChargeId() == null)
                throw new NullPointerException("programEditorCharge is null");

            /*
             * check programEditorCharge is existent or not
             */
            if (!checkProgramEditorChargeIsExistent(programEditorCharge.getProgramEditorChargeId()))
                throw new ProgramEditorChargeUpdNotExistentException("programEditorCharge is not existent");

            /*
             * check program id
             */
            if (!checkProgramNotNullAndExistent(programEditorCharge.getComProgram()))
                throw new ProgramEditorChargeAddProgramNotExistentException("program is null or is not existent");

            /*
             * check user id
             */
            if (!checkUserNotNullAndExistent(programEditorCharge.getComUser()))
                throw new ProgramEditorChargeUpdUserNotExistentException("user is null or is not existent");

        }catch(ProgramEditorChargeUpdNotExistentException e){
            e.printStackTrace();
            throw new ProgramEditorChargeCheckBeforeUpdException();
        }catch(ProgramEditorChargeAddProgramNotExistentException e){
            e.printStackTrace();
            throw new ProgramEditorChargeCheckBeforeUpdException();
        }catch(ProgramEditorChargeUpdUserNotExistentException e){
            e.printStackTrace();
            throw new ProgramEditorChargeCheckBeforeUpdException();
        }
    }

    public void addProgramEditorCharge(ComProgramEditorCharge programEditorCharge){

        try{
            checkBeforeAdd(programEditorCharge);

            programEditorCharge.setStatus(0);
            comProgramEditorChargeDAO.save(programEditorCharge);
        }catch(ProgramEditorChargeCheckBeforeAddException e){
            e.printStackTrace();
        }

    }

    public void delProgramEditorCharge(ComProgramEditorCharge programEditorCharge){

        try{
            checkBeforeDel(programEditorCharge);

            programEditorCharge.setStatus(1);
            comProgramEditorChargeDAO.attachDirty(programEditorCharge);

        }catch(ProgramEditorChargeCheckBeforeDelException e){
            e.printStackTrace();
        }
    }

    public void updProgramEditorCharge(ComProgramEditorCharge programEditorCharge){

        try{
            checkBeforeUpd(programEditorCharge);

            programEditorCharge.setStatus(0);
            comProgramEditorChargeDAO.attachDirty(programEditorCharge);

        }catch(ProgramEditorChargeCheckBeforeUpdException e){
            e.printStackTrace();
        }
    }
}
