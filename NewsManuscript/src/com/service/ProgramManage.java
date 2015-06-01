package com.service;

import com.dao.ComProgramDAO;
import com.domain.ComProgram;
import com.exceptions.programManage.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.util.List;

/**
 * Created by ruanqx on 2015/5/30.
 */
public class ProgramManage extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComProgramDAO comProgramDAO = (ComProgramDAO) applicationContext.getBean("ComProgramDAO");

    private boolean checkNameIsOnly(String programName){
        List<ComProgram> comProgramList = comProgramDAO.findByProgramName(programName);
        return (comProgramList == null || comProgramList.size() <= 0);
    }

    private boolean checkProgramIsExistent(String programId){
        ComProgram comProgram = comProgramDAO.findById(programId);
        return (comProgram != null && comProgram.getProgramId() != null);
    }

    private void checkBeforeAdd(ComProgram program) throws ProgramCheckBeforeAddException{

        try{
            /*
             * check the object program
             */
            if(program == null)
                throw new NullPointerException("program is null");

            /*
             * check program's name
             */
            if(program.getProgramName() == null)
                throw new NullPointerException("program's name is null");
            else if(!checkSizeIsLegal(program.getProgramName(), 1, 32))
                throw new ProgramAddNameSizeException("size of program's name is not in (0, 32]");
            else if(!checkNameIsOnly(program.getProgramName()))
                throw new ProgramAddNameNotOnlyException("program's name is existent");

            /*
             * check program's describe
             */
            if(program.getProgramDescribe() != null)
                if(!checkSizeIsLegal(program.getProgramDescribe(), 0, 500))
                    throw new ProgramAddDescribeSizeException("size of program's describe is not in [0, 500]");

        }catch(ProgramAddNameSizeException e){
            System.out.println(e.toString());
            throw new ProgramCheckBeforeAddException();
        }catch(ProgramAddNameNotOnlyException e){
            System.out.println(e.toString());
            throw new ProgramCheckBeforeAddException();
        }catch(ProgramAddDescribeSizeException e){
            System.out.println(e.toString());
            throw new ProgramCheckBeforeAddException();
        }

    }

    private void checkBeforeDel(ComProgram program) throws ProgramCheckBeforeDelException {

        try{
            /*
             * check object program
             */
            if(program == null || program.getProgramId() == null)
                throw new NullPointerException("program is null");

            /*
             * check program is existent or not
             */
            if(!checkProgramIsExistent(program.getProgramId()))
                throw new ProgramDelProgramNotExistentException("program is not existent");
        }catch(ProgramDelProgramNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramCheckBeforeDelException();
        }

    }

    private void checkBeforeUpd(ComProgram program) throws ProgramCheckBeforeUpdException{

        try{
            /*
             * check object program
             */
            if(program == null || program.getProgramId() == null)
                throw new NullPointerException("program is null");

            /*
             * check program is existent or not
             */
            if(!checkProgramIsExistent(program.getProgramId()))
                throw new ProgramUpdProgramNotExistentException("program is not existent");

            ComProgram comProgram = comProgramDAO.findById(program.getProgramId());

            /*
             * check program's name
             */
            if(program.getProgramName() == null)
                throw new NullPointerException("program's name is null");
            else if(!checkSizeIsLegal(program.getProgramName(), 1, 32))
                throw new ProgramUpdNameSizeException("size of program's name is not in (0, 32]");
            else if(!comProgram.getProgramName().equals(program.getProgramName())){
                if(!checkNameIsOnly(program.getProgramName()))
                    throw new ProgramUpdNameNotOnlyException("program's name is Existent");
            }

            /*
             * check program's describe
             */
            if(program.getProgramDescribe() != null)
                if(!checkSizeIsLegal(program.getProgramDescribe(), 0, 500))
                    throw new ProgramUpdDescribeSizeException("size of program's describe is not in [0, 500]");

        }catch(ProgramUpdProgramNotExistentException e){
            System.out.println(e.toString());
            throw new ProgramCheckBeforeUpdException();
        }catch(ProgramUpdNameSizeException e){
            System.out.println(e.toString());
            throw new ProgramCheckBeforeUpdException();
        }catch(ProgramUpdNameNotOnlyException e){
            System.out.println(e.toString());
            throw new ProgramCheckBeforeUpdException();
        }catch(ProgramUpdDescribeSizeException e){
            System.out.println(e.toString());
            throw new ProgramCheckBeforeUpdException();
        }
    }

    public void addProgram(ComProgram program){

        try{

            checkBeforeAdd(program);
            program.setStatus(0);
            comProgramDAO.save(program);

        }catch(ProgramCheckBeforeAddException e){
            System.out.println(e.toString());
        }

    }

    public void delProgram(ComProgram program){

        try{
            checkBeforeDel(program);

            program.setStatus(1);
            comProgramDAO.attachDirty(program);

        }catch(ProgramCheckBeforeDelException e){
            System.out.println(e.toString());
        }

    }

    public void updProgram(ComProgram program){

        try{
            checkBeforeUpd(program);

            program.setStatus(0);

            comProgramDAO.attachDirty(program);
        }catch(ProgramCheckBeforeUpdException e){
            System.out.println(e.toString());
        }
    }
}
