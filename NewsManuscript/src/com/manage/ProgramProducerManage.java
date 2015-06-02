package com.manage;

import com.dao.ComProgramProducerDAO;
import com.domain.ComProgramProducer;
import com.exceptions.programProducerManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramProducerManage extends ProgramRelevant{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComProgramProducerDAO comProgramProducerDAO = (ComProgramProducerDAO)applicationContext.getBean("ComProgramProducerDAO");

    private boolean checkProgramProducerIsExistent(String programProducerId){
        ComProgramProducer comProgramProducer = comProgramProducerDAO.findById(programProducerId);
        return (comProgramProducer != null && comProgramProducer.getProgramProducerId() != null);
    }

    private void checkBeforeAdd(ComProgramProducer programProducer) throws ProgramProducerCheckBeforeAddException{

        try{

            /*
             * check object
             */
            if(programProducer == null)
                throw new NullPointerException("programProducer is null");

            /*
             * check program
             */
            if(!checkProgramNotNullAndExistent(programProducer.getComProgram()))
                throw new ProgramProducerAddProgramNotExsitentException("programProducer's program is null or is not existent");

            /*
             * check user
             */
            if(!checkUserNotNullAndExistent(programProducer.getComUser()))
                throw new ProgramProducerAddUserNotExistentException("programProducer's user is null or is not exception");
        }catch(ProgramProducerAddProgramNotExsitentException e){
            System.out.println(e.toString());
            throw new ProgramProducerCheckBeforeAddException();
        }catch(ProgramProducerAddUserNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramProducerCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComProgramProducer programProducer) throws ProgramProducerCheckBeforeDelException{

        try{
            /*
             * check object
             */
            if(programProducer == null || programProducer.getProgramProducerId() == null)
                throw new NullPointerException("programProducer is null");

            /*
             * check programProducer is existent or not
             */
            if(!checkProgramProducerIsExistent(programProducer.getProgramProducerId()))
                throw new ProgramProducerDelNotExistentException("programProducer is not existent");

        }catch(ProgramProducerDelNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramProducerCheckBeforeDelException();
        }
    }

    private void checkBeforeUpd(ComProgramProducer programProducer) throws ProgramProducerCheckBeforeUpdException{

        try {
            /*
             * check object
             */
            if (programProducer == null)
                throw new NullPointerException("programProducer is null");

            /*
             * check programProducer is existent or not
             */
            if (!checkProgramProducerIsExistent(programProducer.getProgramProducerId()))
                throw new ProgramProducerUpdNotExistentException("programProducer is not existent");

            /*
             * check program
             */
            if (!checkProgramNotNullAndExistent(programProducer.getComProgram()))
                throw new ProgramProducerUpdProgramNotExistentException("programProducer's program is null or is not existent");

            /*
             * check user
             */
            if (!checkUserNotNullAndExistent(programProducer.getComUser()))
                throw new ProgramProducerUpdUserNotExistentException("programProducer's user is null or is not existent");

        }catch(ProgramProducerUpdNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramProducerCheckBeforeUpdException();
        }catch(ProgramProducerUpdProgramNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramProducerCheckBeforeUpdException();
        }catch(ProgramProducerUpdUserNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramProducerCheckBeforeUpdException();
        }
    }

    public void addProgramProducer(ComProgramProducer programProducer){

        try{
            checkBeforeAdd(programProducer);

            programProducer.setStatus(0);
            comProgramProducerDAO.save(programProducer);
        }catch(ProgramProducerCheckBeforeAddException e){
            System.out.println(e.toString());
        }
    }

    public void delProgramProducer(ComProgramProducer programProducer){

        try{
            checkBeforeDel(programProducer);

            programProducer.setStatus(1);
            comProgramProducerDAO.attachDirty(programProducer);
        }catch(ProgramProducerCheckBeforeDelException e){
            System.out.println(e.toString());
        }
    }

    public void updProgramProducer(ComProgramProducer programProducer){

        try{
            checkBeforeUpd(programProducer);

            programProducer.setStatus(0);
            comProgramProducerDAO.attachDirty(programProducer);
        }catch(ProgramProducerCheckBeforeUpdException e){
            System.out.println(e.toString());
        }
    }
}
