package com.manage;

import com.dao.ComProgramAppraiserDAO;
import com.domain.ComProgramAppraiser;
import com.exceptions.programAppraiserManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruanqx on 2015/6/3.
 */
public class ProgramAppraiser extends ProgramRelevant{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComProgramAppraiserDAO comProgramAppraiserDAO = (ComProgramAppraiserDAO)applicationContext.getBean("ComProgramAppraiserDAO");

    private boolean checkProgramAppraiserIsExistent(String programAppraiserId){
        ComProgramAppraiser comProgramAppraiser = (ComProgramAppraiser)applicationContext.getBean("ComProgramAppraiser");
        return (comProgramAppraiser != null && comProgramAppraiser.getProgramAppraiserId() != null);
    }

    private void checkBeforeAdd(ComProgramAppraiser programAppraiser) throws ProgramAppraiserCheckBeforeAddException{

        try{
            /*
             * check object
             */
            if(programAppraiser == null)
                throw new NullPointerException("programAppraiser is null");

            /*
             * check program
             */
            if(!checkProgramNotNullAndExistent(programAppraiser.getComProgram()))
                throw new ProgramAppraiserAddProgramNotExistentException("programAppraiser's program is null or is not existent");

            /*
             * check user
             */
            if(!checkUserNotNullAndExistent(programAppraiser.getComUser()))
                throw new ProgramAppraiserAddUserNotExistentException("programAppraiser's user is null or is not existent");
        }catch(ProgramAppraiserAddProgramNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramAppraiserCheckBeforeAddException();
        }catch(ProgramAppraiserAddUserNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramAppraiserCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComProgramAppraiser programAppraiser) throws ProgramAppraiserCheckBeforeDelException{

        try{
            /*
             * check object
             */
            if(programAppraiser == null || programAppraiser.getProgramAppraiserId() == null)
                throw new NullPointerException("programAppraiser is null");

            /*
             * check programAppraiser is existent or not
             */
            if(!checkProgramAppraiserIsExistent(programAppraiser.getProgramAppraiserId()))
                throw new ProgramAppraiserDelNotExistentException("programAppraiser is not existent");
        }catch(ProgramAppraiserDelNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramAppraiserCheckBeforeDelException();
        }
    }

    private void checkBeforeUpd(ComProgramAppraiser programAppraiser) throws ProgramAppraiserCheckBeforeUpdException{

        try{
            /*
             * check object
             */
            if(programAppraiser == null || programAppraiser.getProgramAppraiserId() == null)
                throw new NullPointerException("programAppraiser is null");

            /*
             * check programAppraiser is existent or not
             */
            if(!checkProgramAppraiserIsExistent(programAppraiser.getProgramAppraiserId()))
                throw new ProgramAppraiserUpdNotExistentException("programAppraiser is not existent");

            /*
             * check program
             */
            if(!checkProgramNotNullAndExistent(programAppraiser.getComProgram()))
                throw new ProgramAppraiserUpdProgramNotExistentException("programAppraiser's program is null or is not existent");

            /*
             * check user
             */
            if(!checkUserNotNullAndExistent(programAppraiser.getComUser()))
                throw new ProgramAppraiserUpdUserNotExistentException("programAppraiser's user is null or is not existent");

        }catch(ProgramAppraiserUpdNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramAppraiserCheckBeforeUpdException();
        }catch(ProgramAppraiserUpdProgramNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramAppraiserCheckBeforeUpdException();
        }catch(ProgramAppraiserUpdUserNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramAppraiserCheckBeforeUpdException();
        }

    }

    public void addProgramAppraiser(ComProgramAppraiser programAppraiser){

        try{
            checkBeforeAdd(programAppraiser);

            programAppraiser.setStatus(0);
            comProgramAppraiserDAO.save(programAppraiser);
        }catch(ProgramAppraiserCheckBeforeAddException e){
            System.out.println(e.toString());
        }
    }

    public void delProgramAppraiser(ComProgramAppraiser programAppraiser){

        try{
            checkBeforeDel(programAppraiser);

            programAppraiser.setStatus(1);
            comProgramAppraiserDAO.attachDirty(programAppraiser);
        }catch(ProgramAppraiserCheckBeforeDelException e){
            System.out.println(e.toString());
        }
    }

    public void updProgramAppraiser(ComProgramAppraiser programAppraiser){

        try{
            checkBeforeUpd(programAppraiser);

            programAppraiser.setStatus(0);
            comProgramAppraiserDAO.attachDirty(programAppraiser);
        }catch(ProgramAppraiserCheckBeforeUpdException e){
            System.out.println(e.toString());
        }
    }
}
