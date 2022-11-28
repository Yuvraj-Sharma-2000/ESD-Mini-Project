package com.dao;


import com.bean.alumniEducation;

import java.util.List;

public interface alumniEduDao {
    void createAlumniEdu(alumniEducation education);
    alumniEducation update(alumniEducation education);

    List<alumniEducation> details(int id);
}
