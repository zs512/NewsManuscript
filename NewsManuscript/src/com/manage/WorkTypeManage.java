package com.manage;

import com.dao.ComWorkTypeDAO;
import com.domain.ComWorkType;
import com.exceptions.workTypeManage.*;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ruanqx on 2015/6/4.
 */
public class WorkTypeManage extends Manage{

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    ComWorkTypeDAO comWorkTypeDAO = (ComWorkTypeDAO)applicationContext.getBean("ComWorkTypeDAO");

    private boolean checkNameIsExistent(String workTypeName){
        List<ComWorkType> comWorkTypeList = comWorkTypeDAO.findByWorkTypeName(workTypeName);
        return (comWorkTypeList != null && comWorkTypeList.size() > 0);
    }

    private boolean checkWorkTypeIsExistent(String WorkTypeId){
        ComWorkType comWorkType = comWorkTypeDAO.findById(WorkTypeId);
        return (comWorkType != null && comWorkType.getWorkTypeId() != null);
    }

    private void checkBeforeAdd(ComWorkType workType) throws WorkTypeCheckBeforeAddException{

        try{
            /*
             * check object
             */
            if(workType == null)
                throw new NullPointerException("workType is null");

            /*
             * check name
             */
            if(workType.getWorkTypeName() == null)
                throw new NullPointerException("workType's name is null");
            else if(!checkSizeIsLegal(workType.getWorkTypeName(), 1, 32))
                throw new WorkTypeAddNameSizeException("size of workType's name is not in (0, 32]");

        }catch(WorkTypeAddNameSizeException e){
            System.out.println(e.toString());
            throw new WorkTypeCheckBeforeAddException();
        }
    }

    private void checkBeforeDel(ComWorkType workType) throws WorkTypeCheckBeforeDelException {

        try{
            /*
             * check object
             */
            if(workType == null || workType.getWorkTypeId() == null)
                throw new NullPointerException("workType is null");

            /*
             * check workType is existent or not
             */
            if(!checkWorkTypeIsExistent(workType.getWorkTypeId()))
                throw new WorkTypeDelNotExistentException("WorkType is not existent");
        }catch(WorkTypeDelNotExistentException e){
            System.out.println(e.toString());
            throw new WorkTypeCheckBeforeDelException();
        }
    }

    private void checkBeforeUpd(ComWorkType workType) throws WorkTypeCheckBeforeUpdException {

        try{
            /*
             * check object
             */
            if(workType == null || workType.getWorkTypeId() == null)
                throw new NullPointerException("workType is null");

            /*
             * check workType is existent or not
             */
            if(!checkWorkTypeIsExistent(workType.getWorkTypeId()))
                throw new WorkTypeUpdNotExistentException("workType is not existent");

            /*
             * check name
             */
            ComWorkType comWorkType = comWorkTypeDAO.findById(workType.getWorkTypeId());
            if(!comWorkType.getWorkTypeName().equals(workType.getWorkTypeName()))
                if(checkNameIsExistent(workType.getWorkTypeName()))
                    throw new WorkTypeUpdNameRepeatException("workType's name is repeat");
        }catch(WorkTypeUpdNotExistentException e){
            System.out.println(e.toString());
            throw new WorkTypeCheckBeforeUpdException();
        }catch(WorkTypeUpdNameRepeatException e){
            System.out.println(e.toString());
            throw new WorkTypeCheckBeforeUpdException();
        }
    }

    public void addWorkType(ComWorkType workType){

        try{
            checkBeforeAdd(workType);

            workType.setStatus(0);
            comWorkTypeDAO.save(workType);
        }catch(WorkTypeCheckBeforeAddException e){
            System.out.println(e.toString());
        }

    }

    public void delWorkType(ComWorkType workType){

        try{
            checkBeforeDel(workType);

            workType.setStatus(1);
            comWorkTypeDAO.attachDirty(workType);
        }catch(WorkTypeCheckBeforeDelException e){
            System.out.println(e.toString());
        }
    }

    public void UpdWorkType(ComWorkType workType){

        try{
            checkBeforeUpd(workType);

            workType.setStatus(0);
            comWorkTypeDAO.attachDirty(workType);
        }catch(WorkTypeCheckBeforeUpdException e){
            System.out.println(e.toString());
        }
    }
}
