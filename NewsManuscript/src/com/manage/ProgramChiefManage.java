package com.manage;

import com.dao.ComProgramChiefDAO;
import com.domain.ComProgramChief;
import com.exceptions.programChiefManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramChiefManage extends ProgramRelevant{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComProgramChiefDAO comProgramChiefDAO = (ComProgramChiefDAO)applicationContext.getBean("ComProgramChiefDAO");

    private boolean checkProgramChiefIsExistent(String programChiefId){
        ComProgramChief comProgramChief = comProgramChiefDAO.findById(programChiefId);
        return (comProgramChief != null && comProgramChief.getProgramChiefId() != null);
    }

    private void checkBeforeAdd(ComProgramChief programChief) throws ProgramChiefCheckBeforeAddException{

        try{
            /*
             * check object
             */
            if(programChief == null)
                throw new NullPointerException("programChief is null");

            /*
             * check program
             */
            if(!checkProgramNotNullAndExistent(programChief.getComProgram()))
                throw new ProgramChiefAddProgramNotExistentException("programChief's program is null or is not existent");

            /*
             * check user
             */
            if(!checkUserNotNullAndExistent(programChief.getComUser()))
                throw new ProgramChiefAddUserNotExistentException("programChief's user is null or is not existent");

        }catch(ProgramChiefAddProgramNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramChiefCheckBeforeAddException();
        }catch(ProgramChiefAddUserNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramChiefCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComProgramChief programChief) throws ProgramChiefCheckBeforeDelException{

        try{
            /*
             * check object
             */
            if(programChief == null || programChief.getProgramChiefId() == null)
                throw new NullPointerException("programChief is null");

            /*
             * check programChief is existent or not
             */
            if(!checkProgramChiefIsExistent(programChief.getProgramChiefId()))
                throw new ProgramChiefDelNotExistentException("programChief is not existent");

        }catch(ProgramChiefDelNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramChiefCheckBeforeDelException();
        }
    }

    private void checkBeforeUpd(ComProgramChief programChief) throws ProgramChiefCheckBeforeUpdException{

        try{
            /*
             * check object
             */
            if(programChief == null || programChief.getProgramChiefId() == null)
                throw new NullPointerException("programChief is null");

            /*
             * check programChief is existent or not
             */
            if(!checkProgramChiefIsExistent(programChief.getProgramChiefId()))
                throw new ProgramChiefUpdNotExistentException("programChief is not existent");


            /*
             * check program
             */
            if(!checkProgramNotNullAndExistent(programChief.getComProgram()))
                throw new ProgramChiefUpdProgramNotExistentException("progarmChief's program is not existent");

            /*
             * check user
             */
            if(!checkUserNotNullAndExistent(programChief.getComUser()))
                throw new ProgramChiefUpdUserNotExistentException("programChief's user is not existent");

        }catch(ProgramChiefUpdNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramChiefCheckBeforeUpdException();
        }catch(ProgramChiefUpdProgramNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramChiefCheckBeforeUpdException();
        }catch(ProgramChiefUpdUserNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramChiefCheckBeforeUpdException();
        }
    }

    public void addProgramChief(ComProgramChief programChief){

        try{
            checkBeforeAdd(programChief);

            programChief.setStatus(0);
            comProgramChiefDAO.save(programChief);
        }catch(ProgramChiefCheckBeforeAddException e){
            System.out.println(e.toString());
        }
    }


    public void delProgramChief(ComProgramChief programChief){

        try{
            checkBeforeDel(programChief);

            programChief.setStatus(1);
            comProgramChiefDAO.attachDirty(programChief);
        }catch(ProgramChiefCheckBeforeDelException e){
            System.out.println(e.toString());
        }

    }

    public void updProgramChief(ComProgramChief programChief){

        try{
            checkBeforeUpd(programChief);

            programChief.setStatus(0);
            comProgramChiefDAO.attachDirty(programChief);
        }catch(ProgramChiefCheckBeforeUpdException e){
            System.out.println(e.toString());
        }
    }
}

