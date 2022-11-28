package com.dao;

import com.bean.Organisation;

public interface organisationDAO {
    void createOrganisation(Organisation organisation);
    Organisation findById(int id);
}
