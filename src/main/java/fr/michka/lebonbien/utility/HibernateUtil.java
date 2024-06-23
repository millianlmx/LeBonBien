package fr.michka.lebonbien.utility;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static EntityManager getEntityManager() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sf = configuration.buildSessionFactory();

        try {
            return sf.openSession();
        } catch (HibernateException e) {
            Logger.getLogger(HibernateUtil.class.getName()).severe(e.getMessage());
        } finally {
            sf.close();
        }

        return null;
    }
}

