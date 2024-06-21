package fr.michka.lebonbien.dao;

import fr.michka.lebonbien.model.AnnonceEntity;
import fr.michka.lebonbien.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

public class AnnonceDAO implements DAOInterface<AnnonceEntity>{
    @Override
    public int create(AnnonceEntity data) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        try (SessionFactory sf = configuration.buildSessionFactory()) {
            Session session = sf.openSession();
            System.out.println("Session: " + session);
            assert session != null;
            Transaction transaction = session.beginTransaction();
            System.out.println("Transaction created: " + transaction);
            session.persist(data);
            System.out.println("Data persisted: " + data);
            transaction.commit();
            System.out.println("Transaction committed: " + transaction);
        } catch (HibernateException e) {
            Logger.getLogger(AnnonceDAO.class.getName()).severe(e.getMessage());
            return -1;
        }
        return 0;
    }

    @Override
    public int update(AnnonceEntity data) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        try (Session session = HibernateUtil.getSession()) {
            assert session != null;
            Transaction transaction = session.beginTransaction();
            session.merge(data);
            transaction.commit();
        } catch (HibernateException e) {
            Logger.getLogger(AnnonceDAO.class.getName()).severe(e.getMessage());
            return -1;
        }
        return 0;
    }

    @Override
    public int delete(AnnonceEntity data) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        try (Session session = HibernateUtil.getSession()) {
            assert session != null;
            Transaction transaction = session.beginTransaction();
            session.remove(data);
            transaction.commit();
        } catch (HibernateException e) {
            Logger.getLogger(AnnonceDAO.class.getName()).severe(e.getMessage());
            return -1;
        }
        return 0;
    }

    @Override
    public AnnonceEntity findById(int id) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        try (Session session = HibernateUtil.getSession()) {
            assert session != null;
            return session.get(AnnonceEntity.class, id);
        } catch (HibernateException e) {
            Logger.getLogger(AnnonceDAO.class.getName()).severe(e.getMessage());
        }
        return null;
    }

    @Override
    public AnnonceEntity[] findAll() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        try (Session session = HibernateUtil.getSession()) {
            assert session != null;
            return session.createQuery("from AnnonceEntity", AnnonceEntity.class).list().toArray(new AnnonceEntity[0]);
        } catch (HibernateException e) {
            Logger.getLogger(AnnonceDAO.class.getName()).severe(e.getMessage());
        }
        return null;
    }
}
