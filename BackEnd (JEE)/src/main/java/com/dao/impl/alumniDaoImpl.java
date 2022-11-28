package com.dao.impl;


import com.bean.alumni;
import com.dao.alumniDao;
import com.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class alumniDaoImpl implements alumniDao {
    @Override
    public void createAlumni(alumni alumni) {
        try (Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(alumni);
            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }

    @Override
    public alumni login(alumni alumni) {
        try (Session session = HibernateSessionUtil.getSession()){
            String studentEmail = alumni.getEmail();
            String studentPassword = alumni.getPassword();

            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                                    "FROM alumni WHERE email = :Email and password = :Password"
                            )
                            .setParameter("Email", studentEmail)
                            .setParameter("Password", studentPassword)
                            .list()
            );

            if (result.size() == 0)
                return null;
            else
                return (alumni) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<alumni> info() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<alumni> result = new ArrayList<>(
                    session.createQuery(
                                    "FROM alumni "
                            )
                            .list()
            );
            // If no valid Student found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return result;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public alumni update(alumni alumni) {
        try (Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();

            List<alumni> result = new ArrayList<>(
                session.createQuery(
                                "FROM alumni where id= :id"
                        )
                        .setParameter("id",alumni.getId())
                        .list()
            );

            result.get(0).setContactNumber(alumni.getContactNumber());
            session.merge(result.get(0));
            transaction.commit();
            session.close();

            if (result.get(0) == null)
                return null;
            else
                return result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public alumni getAlumniById(int id) {
        try (Session session = HibernateSessionUtil.getSession()){
            List<alumni> result = new ArrayList<>(
                    session.createQuery("from alumni where id= :id")
                            .setParameter("id",id)
                            .list()
            );
            return result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
