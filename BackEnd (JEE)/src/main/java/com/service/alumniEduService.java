package com.service;

import com.bean.alumniEducation;
import com.dao.impl.alumniEduDaoImpl;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public class alumniEduService {
    alumniEduDaoImpl eduDao = new alumniEduDaoImpl();

    public alumniEducation update(alumniEducation education){
        return eduDao.update(education);
    }

    public List<alumniEducation> details(int id) {
        return eduDao.details(id);
    }
}
