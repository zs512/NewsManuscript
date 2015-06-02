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
            System.out.println(e.toString());
            throw new ProgramBossCheckBeforeAddException();
        }catch(ProgramBossAddUserNotExistentException e){
            System.out.println(e.toString());
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

            /*
             * check program
             */
            if(!checkProgramNotNullAndExistent(programBoss.getComProgram()))
                throw new ProgramBossDelProgramNotExistentException("programBoss's program is not existent");

            /*
             * check user
             */
            if(!checkUserNotNullAndExistent(programBoss.getComUser()))
                throw new ProgramBossDelUserNotExistentException("programBoss's user is not existent");

        }catch(ProgramBossDelNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramBossCheckBeforeDelException();
        }catch(ProgramBossDelProgramNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramBossCheckBeforeDelException();
        }catch(ProgramBossDelUserNotExistentException e){
            System.out.println(e.toString());
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
            System.out.println(e.toString());
            throw new ProgramBossCheckBeforeUpdException();
        }catch(ProgramBossUpdProgramNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramBossCheckBeforeUpdException();
        }catch(ProgramBossUpdUserNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramBossCheckBeforeUpdException();
        }
    }

    public void addProgramBoss(ComProgramBoss programBoss){

        try{
            checkBeforeAdd(programBoss);

            programBoss.setStatus(0);
            comProgramBossDAO.save(programBoss);
        }catch(ProgramBossCheckBeforeAddException e){
            System.out.println(e.toString());
        }
    }

    public void delProgramBoss(ComProgramBoss programBoss){

        try{
            checkBeforeDel(programBoss);

            programBoss.setStatus(1);
            comProgramBossDAO.attachDirty(programBoss);
        }catch(ProgramBossCheckBeforeDelException e){
            System.out.println(e.toString());
        }

    }

    public void updProgramBoss(ComProgramBoss programBoss){

        try{
            checkBeforeUpd(programBoss);

            programBoss.setStatus(0);
            comProgramBossDAO.attachDirty(programBoss);
        }catch(ProgramBossCheckBeforeUpdException e){
            System.out.println(e.toString());
        }
    }
}
