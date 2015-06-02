package com.manage;

import com.dao.ComProgramDAO;
import com.dao.ComUserDAO;
import com.domain.ComProgram;
import com.domain.ComUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruanqx on 2015/6/2.
 */
public class ProgramRelevant extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComProgramDAO comProgramDAO = (ComProgramDAO)applicationContext.getBean("ComProgramDAO");
    ComUserDAO comUserDAO = (ComUserDAO)applicationContext.getBean("ComUserDAO");

    protected boolean checkProgramNotNullAndExistent(ComProgram program){
        if(program == null || program.getProgramId() == null) return false;

        program = comProgramDAO.findById(program.getProgramId());
        return (program != null && program.getProgramId() != null);
    }

    protected boolean checkUserNotNullAndExistent(ComUser user){
        if(user == null || user.getUserId() == null) return false;

        user = comUserDAO.findById(user.getUserId());
        return (user != null && user.getUserId() != null);
    }
}
