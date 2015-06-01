package com.service;

import com.dao.ComProgramDAO;
import com.domain.ComProgram;
import com.exceptions.programManage.ProgramAddDescribeSizeException;
import com.exceptions.programManage.ProgramAddNameNotOnlyException;
import com.exceptions.programManage.ProgramAddNameSizeException;
import com.exceptions.programManage.ProgramCheckBeforeAddException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
                throw new ProgramAddNameNotOnlyException("program's is existent");

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

    public void addProgram(ComProgram program){

        try{

            checkBeforeAdd(program);
            program.setStatus(0);
            comProgramDAO.save(program);

        }catch(ProgramCheckBeforeAddException e){
            System.out.println(e.toString());
        }

    }
}
