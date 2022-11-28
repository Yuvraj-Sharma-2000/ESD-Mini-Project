package com.service;

import com.bean.Organisation;
import com.dao.impl.organisationDaoImpl;
import org.jvnet.hk2.annotations.Service;

@Service
public class organisationService {
    organisationDaoImpl dao = new organisationDaoImpl();

    public Organisation findById(int id){
        return dao.findById(id);
    }
}
