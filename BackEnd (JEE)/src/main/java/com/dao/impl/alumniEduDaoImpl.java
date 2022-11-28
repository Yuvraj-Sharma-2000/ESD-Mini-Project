package com.dao.impl;

import com.bean.alumniEducation;
import com.dao.alumniEduDao;
import com.service.alumniService;
import com.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class alumniEduDaoImpl implements alumniEduDao {
    @Override
    public void createAlumniEdu(alumniEducation education) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(education);
            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }

    @Override
    public alumniEducation update(alumniEducation education) {
        try (Session session = HibernateSessionUtil.getSession()) {
            alumniService alumniService = new alumniService();
            Transaction transaction = session.beginTransaction();

            education.setAlumni(alumniService.getAlumniById(education.getId()));

            session.update(education);
            transaction.commit();
            session.close();

            return education;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<alumniEducation> details(int id) {
        try (Session session = HibernateSessionUtil.getSession()){
            List<alumniEducation> list = new ArrayList<>(
                    session.createQuery("from alumniEducation where alumni.id= :id")
                            .setParameter("id",id).list()
            );
            return list;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
