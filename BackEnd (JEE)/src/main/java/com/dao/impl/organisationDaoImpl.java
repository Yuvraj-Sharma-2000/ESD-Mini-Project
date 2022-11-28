package com.dao.impl;

import com.bean.Organisation;
import com.dao.organisationDAO;
import com.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class organisationDaoImpl implements organisationDAO {
    @Override
    public void createOrganisation(Organisation organisation) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(organisation);
            transaction.commit();
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
    }

    @Override
    public Organisation findById(int id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            List<Organisation> organisations = new ArrayList<>(
                    session.createQuery("from Organisation  where id= :id").setParameter("id",id).list()
            );
            return organisations.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

}
