package ua.com.alevel.servlet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.servlet.models.Address;


import ua.com.alevel.servlet.utils.HibernateSessionFactoryUtil;

import java.util.List;


public class AddressDao {
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();


    public  List<Address> getAllAddresses() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Address> query = session.createNativeQuery(" SELECT * FROM  address ", Address.class);
            List<Address> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }


    public  void createAddress(String addressName, Address address) {
        if (!checkAddressExisting(addressName)) {
            addressCreation(address);
        }
    }

    public  void deleteAddress(String addressName){
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Address WHERE addressName =: addressName");
            query.setParameter("addressName", addressName);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public void updateAddress(Address address) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(address);
            session.getTransaction().commit();
        }
    }

    public  boolean checkAddressExisting(String addressName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("SELECT count(*) FROM Address where addressName=: addressName ", Long.class);
            query.setParameter("addressName", addressName);
            return query.getSingleResult() > 0;
        }
    }


    public  void addressCreation(Address address) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  Address getAddressByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Address where addressName = :addressName", Address.class);
            query.setParameter("addressName", name);
            return (Address) query.getSingleResult();
        }
    }


}
