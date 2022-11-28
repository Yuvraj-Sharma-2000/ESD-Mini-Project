package com.service;

import com.bean.Student;
import com.bean.alumni;
import com.bean.alumniEducation;
import com.bean.alumniOrganisation;
import com.dao.impl.alumniDaoImpl;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public class alumniService {
    alumniDaoImpl alumniDao = new alumniDaoImpl();

    public alumni login(alumni alumni){
        alumni alumni1 = alumniDao.login(alumni);
        if (alumni1==null)
            return null;
        return alumni1;
    }
    public List<alumni> info(){
        List<alumni> alumniList = alumniDao.info();
        if (alumniList==null)
            return null;
        return alumniList;
    }
    public alumni update(alumni alumni){
        return alumniDao.update(alumni);
    }

    public alumni getAlumniById(int id){
        return alumniDao.getAlumniById(id);
    }
}
