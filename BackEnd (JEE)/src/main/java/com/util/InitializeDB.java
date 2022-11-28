package com.util;

import com.bean.*;
import com.dao.alumniOrgDao;
import com.dao.impl.*;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/*
    Script that initializes the database with dummy entries for all tables
*/
public class InitializeDB {
    public static void main(String[] args) {

//       --------------------------- STUDENT DETAILS -----------------------------
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(101,"Yuvraj","Sharma","yuvraj@gmail.com","asdas", 9.8f,20,2024,"CSE","AIML",66));
        studentList.add(new Student(103,"Anoop","Kumar","anoop@gmail.com","poksadjd",7.8f,16,2024,"CSE","CY",67));
        studentList.add(new Student(104,"Adarsh","Gupta","adarsh@gmail.com","psuebaa",8.0f,18,2025,"ECE","VLSI",60));
        studentList.add(new Student(107,"Divyanshi","Rai","rai@gmail.com","mdaasm",6.9f,22,2020,"Mech","Thermo",80));
        studentList.add(new Student(102,"Ekta","Sharma","ekta@gmail.com","hrsmdaasm",9.7f,20,2016,"CMA","Audit",71));

//        ----------------------- ORGANISATION DETAILS ----------------------------
        List<Organisation> organisationList = new ArrayList<>();
        organisationList.add(new Organisation(1,"Google","75/C hosur road, Bangalore"));
        organisationList.add(new Organisation(2,"IBM","7C road north street, Mumbai"));
        organisationList.add(new Organisation(3,"Deloitte","12 Sector bhilai, Durg"));
        organisationList.add(new Organisation(4,"Apple","Commons way, sea baye, Bnagalore"));

//        ----------------------- POPULATE ALUMNI TABLE ---------------------------
        List<alumni> alumniList = new ArrayList<>();
        alumniList.add(new alumni("sami@gmail.com","password1", 846349007,studentList.get(0)));
        alumniList.add(new alumni("yuvraj@yahoo.com","password2",734902334,studentList.get(1)));
        alumniList.add(new alumni("hellow@gmailc.om","password3",123456789,studentList.get(4)));

//        ---------------------- POPULATE ALUMNI_ORGANISATION TABLE -------------------
        List<alumniOrganisation> alumniOrganisations = new ArrayList<>();
        alumniOrganisations.add(new alumniOrganisation(alumniList.get(0),organisationList.get(2),"SDE", Date.valueOf("2018-03-13"),Date.valueOf("2020-01-01")));
        alumniOrganisations.add(new alumniOrganisation(alumniList.get(0),organisationList.get(1),"CEO",Date.valueOf("2020-01-03"),Date.valueOf("2024-05-09")));
        alumniOrganisations.add(new alumniOrganisation(alumniList.get(1),organisationList.get(3),"HR", Date.valueOf("2015-03-13"),Date.valueOf("2021-01-01")));
        alumniOrganisations.add(new alumniOrganisation(alumniList.get(2),organisationList.get(0),"Manager",Date.valueOf("2009-03-13"),Date.valueOf("2013-01-01")));

//        ------------------ POPULATE ALUMNI_EDUCATION TABLE --------------------------
        List<alumniEducation> educations = new ArrayList<>();
        educations.add(new alumniEducation(alumniList.get(0),"MTech",2020,2018,"IIITB","Bangalore"));
        educations.add(new alumniEducation(alumniList.get(1),"BTech",2022,2018,"DTU","Delhi"));
        educations.add(new alumniEducation(alumniList.get(2),"Phd",2010,2005,"IISC","Bangalore"));

//        ---------------- ADD TO DATABASE ------------------
        organisationDaoImpl organisationDao = new organisationDaoImpl();
        for (Organisation o: organisationList)
            organisationDao.createOrganisation(o);

        studentDaoImpl studentDao = new studentDaoImpl();
        for (Student s: studentList)
            studentDao.createStudent(s);

        alumniDaoImpl alumniDao = new alumniDaoImpl();
        for (alumni a: alumniList)
            alumniDao.createAlumni(a);

        alumniEduDaoImpl alumniEduDao = new alumniEduDaoImpl();
        for (alumniEducation e: educations)
            alumniEduDao.createAlumniEdu(e);

        alumniOrgDaoImpl alumniOrgDao = new alumniOrgDaoImpl();
        for (alumniOrganisation o: alumniOrganisations)
            alumniOrgDao.createAlumniOrg(o);
    }
}