package ua.com.alevel.servlet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.servlet.models.User;
import ua.com.alevel.servlet.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDao {
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public static void createUser(String userName, User user) {
        if (!checkUserExisting(userName)) {
            userCreation(user);
        }
    }

    public static void userCreation(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUserExisting(String userName) {
        List<User> users = getAllUsers();
        for (User user : users) {
            if(user.getName().equals(userName)){
                return true;
            }
        }
        return false;
    }


    public static List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<User> query = session.createNativeQuery(" SELECT * FROM  users ", User.class);
            List<User> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }

    public static User getUser(String userName) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createNativeQuery(" SELECT * FROM users  WHERE name = ? ", User.class);
            query.setParameter(1, userName);
            List<User> resultList = query.getResultList();
            return resultList.get(0);
        }
    }
}
