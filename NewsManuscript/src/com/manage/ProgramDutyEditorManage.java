package com.manage;

import com.dao.ComProgramDutyEditorDAO;
import com.domain.ComProgramDutyEditor;
import com.exceptions.programDutyEditorManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramDutyEditorManage extends ProgramRelevant{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComProgramDutyEditorDAO comProgramDutyEditorDAO = (ComProgramDutyEditorDAO)applicationContext.getBean("ComProgramDutyEditorDAO");

    private boolean checkProgramDutyEditorIsExistent(String programDutyEditorId){
        ComProgramDutyEditor comProgramDutyEditor = comProgramDutyEditorDAO.findById(programDutyEditorId);
        return (comProgramDutyEditor != null && comProgramDutyEditor.getProgramDutyEditorChargeId() != null);
    }

    private void checkBeforeAdd(ComProgramDutyEditor programDutyEditor) throws ProgramDutyEditorCheckBeforeAddException{

        try{
            /*
             * check object
             */
            if(programDutyEditor == null)
                throw new NullPointerException("programDutyEditor is null");

            /*
             * check program id
             */
            if(!checkProgramNotNullAndExistent(programDutyEditor.getComProgram()))
                throw new ProgramDutyEditorAddProgramNotExistentException("program is null or is not existent");

            /*
             * check user id
             */
            if(!checkUserNotNullAndExistent(programDutyEditor.getComUser()))
                throw new ProgramDutyEditorAddUserNotExistentException("user is null or is not existent");
        }catch(ProgramDutyEditorAddProgramNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramDutyEditorCheckBeforeAddException();
        }catch(ProgramDutyEditorAddUserNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramDutyEditorCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComProgramDutyEditor programDutyEditor) throws ProgramDutyEditorCheckBeforeDelException{

        try{
            /*
             * check object
             */
            if(programDutyEditor == null)
                throw new NullPointerException("programDutyEditor is null");

            /*
             * check is existent
             */
            if(programDutyEditor.getProgramDutyEditorChargeId() == null)
                throw new NullPointerException("programDutyEditor'id is null");
            if(!checkProgramDutyEditorIsExistent(programDutyEditor.getProgramDutyEditorChargeId()))
                throw new ProgramDutyEditorDelNotException("programDutyEditor is not existent");

        }catch(ProgramDutyEditorDelNotException e){
            System.out.println(e.toString());
            throw new ProgramDutyEditorCheckBeforeDelException();
        }
    }

    private void checkBeforeUpd(ComProgramDutyEditor programDutyEditor) throws ProgramDutyEditorCheckBeforeUpdException{

        try{

            /*
             * check object
             */
            if(programDutyEditor == null)
                throw new NullPointerException("programDutyEditor is null");

            /*
             * check programDutyEditor
             */
            if(!checkProgramDutyEditorIsExistent(programDutyEditor.getProgramDutyEditorChargeId()))
                throw new ProgramDutyEditorNotExistentException("programDutyEditor is not existent");

            /*
             * check program
             */
            if(!checkProgramNotNullAndExistent(programDutyEditor.getComProgram()))
                throw new ProgramDutyEditorUpdProgramNotExistentException("program is null or is not existent");

            /*
             * check user
             */
            if(!checkUserNotNullAndExistent(programDutyEditor.getComUser()))
                throw new ProgramDutyEditorUpdUserNotExistentException("user is null or is not existent");

        }catch(ProgramDutyEditorNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramDutyEditorCheckBeforeUpdException();
        }catch(ProgramDutyEditorUpdProgramNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramDutyEditorCheckBeforeUpdException();
        }catch(ProgramDutyEditorUpdUserNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramDutyEditorCheckBeforeUpdException();
        }
    }

    public void addProgramDutyEditorManage(ComProgramDutyEditor programDutyEditor){

        try{

            checkBeforeAdd(programDutyEditor);

            programDutyEditor.setStatus(0);

            comProgramDutyEditorDAO.save(programDutyEditor);
        }catch(ProgramDutyEditorCheckBeforeAddException e){
            System.out.println(e.toString());
        }
    }

    public void delProgramDutyEditorManage(ComProgramDutyEditor programDutyEditor){

        try{
            checkBeforeDel(programDutyEditor);

            programDutyEditor.setStatus(1);
            comProgramDutyEditorDAO.attachDirty(programDutyEditor);

        }catch(ProgramDutyEditorCheckBeforeDelException e){
            System.out.println(e.toString());
        }
    }

    public void updProgramDutyEditorManage(ComProgramDutyEditor programDutyEditor){

        try{
            checkBeforeUpd(programDutyEditor);

            programDutyEditor.setStatus(0);
            comProgramDutyEditorDAO.attachDirty(programDutyEditor);
        }catch(ProgramDutyEditorCheckBeforeUpdException e){
            System.out.println(e.toString());
        }
    }
}
