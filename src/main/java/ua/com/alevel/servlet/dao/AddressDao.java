package ua.com.alevel.servlet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.servlet.models.Address;

import ua.com.alevel.servlet.models.Book;
import ua.com.alevel.servlet.utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Set;

public class AddressDao {
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();


    public static List<Address> getAllAddresses() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Address> query = session.createNativeQuery(" SELECT * FROM  address ", Address.class);
            List<Address> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }


    public static void createAddress(String addressName, Address address) {
        if (!checkAddressExisting(addressName)) {
            addressCreation(address);
        }
    }

    public static List<Address> getAddressNameForCertainBook(String bookName, String bookAuthor){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Address> query = session.createNativeQuery(" SELECT * FROM Address a WHERE a.id IN (SELECT address_id From book_address ba" +
                    " WHERE book_id IN (SELECT id FROM Book b WHERE b.title = ? AND b.author = ?))", Address.class);
            query.setParameter(1, bookName);
            query.setParameter(2,bookAuthor);
            List<Address> resultList =  query.getResultList();
            session.getTransaction().commit();
            return  resultList;
        }
    }


    public static boolean checkAddressExisting(String name) {
        List<Address> addresses = getAllAddresses();
        for (Address address : addresses) {
            if (address.getAddressName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    public static void addressCreation(Address address) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
