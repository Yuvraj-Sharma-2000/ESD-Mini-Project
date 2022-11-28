package com.service;

import com.bean.alumniOrganisation;
import com.dao.impl.alumniOrgDaoImpl;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public class alumniOrgService {
    alumniOrgDaoImpl dao = new alumniOrgDaoImpl();

    public boolean delete(int id){
        return dao.delete(id);
    }
    public alumniOrganisation add(alumniOrganisation organisation){
        return dao.createAlumniOrg(organisation);
    }
    public alumniOrganisation update(alumniOrganisation organisation){
        return dao.update(organisation);
    }
    public List<alumniOrganisation> info(){
        return dao.info();
    }

    public List<alumniOrganisation> details(int id){
        return dao.details(id);
    }
}
