package com.manage;

import com.dao.ComProgramBossDAO;
import com.domain.ComProgramBoss;
import com.exceptions.programBossManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramBossManage extends ProgramRelevant{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComProgramBossDAO comProgramBossDAO = (ComProgramBossDAO)applicationContext.getBean("ComProgramBossDAO");

    private boolean checkProgramBossIsExistent(String programBossId){
        ComProgramBoss comProgramBoss = comProgramBossDAO.findById(programBossId);
        return (comProgramBoss != null && comProgramBoss.getProgramBossId() != null);
    }

    private void checkBeforeAdd(ComProgramBoss programBoss) throws ProgramBossCheckBeforeAddException{

        try{

            /*
             * check object
             */
            if(programBoss == null)
                throw new NullPointerException("programBoss is null");

            /*
             * check program
             */
            if(!checkProgramNotNullAndExistent(programBoss.getComProgram()))
                throw new ProgramBossAddProgramNotExistentException("programBoss is null or is not existent");
            /*
             * check user
             */
            if(!checkUserNotNullAndExistent(programBoss.getComUser()))
                throw new ProgramBossAddUserNotExistentException("programBoss is null or is not existent");

        }catch(ProgramBossAddProgramNotExistentException e){
            e.printStackTrace();
            throw new ProgramBossCheckBeforeAddException();
        }catch(ProgramBossAddUserNotExistentException e){
            e.printStackTrace();
            throw new ProgramBossCheckBeforeAddException();
        }


    }

    private void checkBeforeDel(ComProgramBoss programBoss) throws ProgramBossCheckBeforeDelException{

        try{
            /*
             * check object
             */
            if(programBoss == null || programBoss.getProgramBossId() == null)
                throw new NullPointerException("programBoss is null");

            /*
             * check programBoss is existent or not
             */
            if(!checkProgramBossIsExistent(programBoss.getProgramBossId()))
                throw new ProgramBossDelNotExistentException("programBoss is not existent");

        }catch(ProgramBossDelNotExistentException e){
            e.printStackTrace();
            throw new ProgramBossCheckBeforeDelException();
        }

    }

    private void checkBeforeUpd(ComProgramBoss programBoss) throws ProgramBossCheckBeforeUpdException{

        try{
            /*
             * check object
             */
            if(programBoss == null || programBoss.getProgramBossId() == null)
                throw new NullPointerException("programBoss is null");

            /*
             * check programBoss is existent or not
             */
            if(!checkProgramBossIsExistent(programBoss.getProgramBossId()))
                throw new ProgramBossUpdNotExistentException("programBoss is not existent");

            /*
             * check program
             */
            if(!checkProgramNotNullAndExistent(programBoss.getComProgram()))
                throw new ProgramBossUpdProgramNotExistentException("programBoss's program is null or is not existent");

            /*
             * check user
             */
            if(!checkUserNotNullAndExistent(programBoss.getComUser()))
                throw new ProgramBossUpdUserNotExistentException("program's user is null or is not existent");

        }catch(ProgramBossUpdNotExistentException e){
            e.printStackTrace();
            throw new ProgramBossCheckBeforeUpdException();
        }catch(ProgramBossUpdProgramNotExistentException e){
            e.printStackTrace();
            throw new ProgramBossCheckBeforeUpdException();
        }catch(ProgramBossUpdUserNotExistentException e){
            e.printStackTrace();
            throw new ProgramBossCheckBeforeUpdException();
        }
    }

    public void addProgramBoss(ComProgramBoss programBoss){

        try{
            checkBeforeAdd(programBoss);

            programBoss.setStatus(0);
            comProgramBossDAO.save(programBoss);
        }catch(ProgramBossCheckBeforeAddException e){
            e.printStackTrace();
        }
    }

    public void delProgramBoss(ComProgramBoss programBoss){

        try{
            checkBeforeDel(programBoss);

            programBoss.setStatus(1);
            comProgramBossDAO.attachDirty(programBoss);
        }catch(ProgramBossCheckBeforeDelException e){
            e.printStackTrace();
        }

    }

    public void updProgramBoss(ComProgramBoss programBoss){

        try{
            checkBeforeUpd(programBoss);

            programBoss.setStatus(0);
            comProgramBossDAO.attachDirty(programBoss);
        }catch(ProgramBossCheckBeforeUpdException e){
            e.printStackTrace();
        }
    }
}
