package com.manage;

import com.dao.ComManuscriptDAO;
import com.dao.ComManuscriptFormDAO;
import com.domain.ComManuscript;
import com.domain.ComManuscriptForm;
import com.exceptions.manuscriptFormManage.ManuscriptFormAddManuscriptNotExistentException;
import com.exceptions.manuscriptFormManage.ManuscriptFormCheckBeforeAddException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ruan on 6/6/15.
 */
public class ManuscriptFormManage extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComManuscriptFormDAO comManuscriptFormDAO = (ComManuscriptFormDAO)applicationContext.getBean("ComManuscriptFormDAO");
    ComManuscriptDAO comManuscriptDAO = (ComManuscriptDAO)applicationContext.getBean("ComManuscriptDAO");

    private boolean checkManuscriptIsExistent(String manuscriptId){
        if(manuscriptId == null) return false;
        ComManuscript comManuscript = comManuscriptDAO.findById(manuscriptId);
        return (comManuscript != null && comManuscript.getManuscriptId() != null);
    }

    private void checkBeforeAdd(ComManuscriptForm manuscriptForm) throws ManuscriptFormCheckBeforeAddException {

        try{
            /*
             * check object
             */
            if(manuscriptForm == null)
                throw new NullPointerException("manuscriptForm is null");

            /*
             * check manuscript
             */
            if(manuscriptForm.getComManuscript() == null)
                throw new NullPointerException("manuscriptForm's manuscript is null");
            else if(checkManuscriptIsExistent(manuscriptForm.getComManuscript().getManuscriptId()))
                throw new ManuscriptFormAddManuscriptNotExistentException();



        }catch(ManuscriptFormAddManuscriptNotExistentException e) {
            e.printStackTrace();
        }
    }

    public void addManuscriptForm(ComManuscriptForm manuscriptForm){

    }
}
