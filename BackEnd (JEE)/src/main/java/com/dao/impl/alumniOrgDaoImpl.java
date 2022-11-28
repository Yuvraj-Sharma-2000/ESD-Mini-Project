package com.dao.impl;

import com.bean.alumniOrganisation;
import com.dao.alumniOrgDao;
import com.service.alumniService;
import com.service.organisationService;
import com.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class alumniOrgDaoImpl implements alumniOrgDao {

    alumniService alumniService = new alumniService();
    organisationService organisationService = new organisationService();
    @Override
    public alumniOrganisation createAlumniOrg(alumniOrganisation organisation) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            organisation.setAlumni(alumniService.getAlumniById(organisation.getAlumni().getId()));
            organisation.setOrganisation(organisationService.findById(organisation.getOrganisation().getId()));

            session.save(organisation);
            transaction.commit();

            return organisation;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return organisation;
    }

    @Override
    public alumniOrganisation update(alumniOrganisation organisation) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            List<alumniOrganisation> list = new ArrayList<>(
                    session.createQuery("from alumniOrganisation where id= :id")
                            .setParameter("id",organisation.getId())
                            .list()
            );

            list.get(0).setPosition(organisation.getPosition());
            list.get(0).setJoiningDate(organisation.getJoiningDate());
            list.get(0).setLeavingDate(organisation.getLeavingDate());

            session.update(list.get(0));
            transaction.commit();
            session.close();

            return list.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(findById(id));
            transaction.commit();

            return true;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;
    }

    @Override
    public alumniOrganisation findById(int id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            List<alumniOrganisation> organisations = new ArrayList<>(
                    session.createQuery("FROM alumniOrganisation where id= :id")
                            .setParameter("id",id).list()
            );
            if (organisations.size()==0)
                return null;
            return organisations.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<alumniOrganisation> info() {
        try (Session session = HibernateSessionUtil.getSession()) {
            List<alumniOrganisation> organisations = new ArrayList<>(
                    session.createQuery("FROM alumniOrganisation")
                            .list()
            );
            if (organisations.size()==0)
                return null;
            return organisations;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<alumniOrganisation> details(int id) {
        try (Session session = HibernateSessionUtil.getSession()){
            List<alumniOrganisation> organisations = new ArrayList<>(
                    session.createQuery("from alumniOrganisation  where alumni.id= :id")
                            .setParameter("id",id).list()
            );
            return organisations;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
