package ua.com.alevel.servlet.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    private HibernateSessionFactoryUtil(){
        throw new UnsupportedOperationException();
    }

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }

}
