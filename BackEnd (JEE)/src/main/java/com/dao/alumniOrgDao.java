package com.dao;


import com.bean.alumniOrganisation;

import java.util.List;

public interface alumniOrgDao {
    alumniOrganisation createAlumniOrg(alumniOrganisation organisation);
    alumniOrganisation update(alumniOrganisation organisation);
    boolean delete(int id);

    alumniOrganisation findById(int id);
    List<alumniOrganisation> info();

    List<alumniOrganisation> details(int id);
}
