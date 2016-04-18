package cz.unit.meatfactory.rest.controllers;

import cz.unit.meatfactory.persistence.HibernateUtil;
import cz.unit.meatfactory.persistence.model.Meat;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rex on 18.4.2016.
 */
public class MeatController {
    public static Meat get(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Meat meat = session.get(Meat.class, id);
        session.close();

        if(meat == null) {
            return new Meat();
        }
        return meat;
    }

    public static List<Meat> getAll() {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            List<Meat> users = session.createCriteria(Meat.class).list();
            tx.commit();

            return users;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }
        return new ArrayList<>();
    }
}
