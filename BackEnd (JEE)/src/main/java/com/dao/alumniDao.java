package com.dao;


import com.bean.Student;
import com.bean.alumni;

import java.util.List;

public interface alumniDao {
    void createAlumni(alumni alumni);
    alumni login(alumni alumni);
    List<alumni> info();
    alumni update(alumni alumni);
    alumni getAlumniById(int id);
}
