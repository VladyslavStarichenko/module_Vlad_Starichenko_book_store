package ua.com.alevel.servlet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.servlet.models.Book;
import ua.com.alevel.servlet.utils.HibernateSessionFactoryUtil;

import java.util.List;

/*Fixed: Using just non static methods*/
public class BookDao {

    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();


    public void createBook(String bookName, String author, String publisher, Book book) {
        if (!checkBookExisting(bookName, author, publisher)) {
            bookCreation(book);
        }
    }


    public List<Book> getAllBooks() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Book> query = session.createNativeQuery(" SELECT * FROM  book ", Book.class);
            List<Book> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }

    /*Simplifying of the checking of existing*/
    public boolean checkBookExisting(String title, String author, String publisher) {
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("SELECT count(*) FROM Book where title = :title AND author=:author AND publisher =: publisher ", Long.class);
            query.setParameter("title", title);
            query.setParameter("author", author);
            query.setParameter("publisher", publisher);
            return query.getSingleResult() > 0;
        }
    }


    public void deleteBook(String title, String author) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Book WHERE title =: title AND  author =: author");
            query.setParameter("author", author);
            query.setParameter("title", title);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public Book getBooK(String title, String author) {
        try (Session session = sessionFactory.openSession()) {
            Query<Book> query = session.createNativeQuery(" SELECT * FROM book  WHERE title = ? AND author = ? ", Book.class);
            query.setParameter(1, title);
            query.setParameter(2, author);
            Book result = query.getSingleResult();
            return result;
        }
    }


    public void bookCreation(Book book) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            System.out.println(book);
            session.save(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Fixed: update is working in appropriate way now */
    public void updateBook(Book book) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(book);
            session.getTransaction().commit();
        }
    }


}
