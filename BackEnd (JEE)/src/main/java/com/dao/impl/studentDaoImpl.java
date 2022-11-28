package com.dao.impl;

import com.bean.Student;
import com.dao.studentDAO;
import com.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class studentDaoImpl implements studentDAO {
    @Override
    public void createStudent(Student student) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }
}
