package ua.com.alevel.servlet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.servlet.models.Address;
import ua.com.alevel.servlet.models.Book;
import ua.com.alevel.servlet.utils.HibernateSessionFactoryUtil;

import java.sql.Date;
import java.util.List;

public class BookDao {

    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();




    public static void createBook(String bookName, String author, String publisher, Book book) {
        if (!checkBookExisting(bookName, author, publisher)) {
            bookCreation(book);
        }
    }


    public static List<Book> getAllBooks() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Book> query = session.createNativeQuery(" SELECT * FROM  book ", Book.class);
            List<Book> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }

    public static Book getBook(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Book> query = session.createNativeQuery(" SELECT * FROM book  WHERE id = ? ", Book.class);
            query.setParameter(1, id);
            Book book = query.getSingleResult();
            return book;
        }
    }

    public static boolean checkBookExisting(String bookName, String author, String publisher) {
        List<Book> books = getAllBooks();
        for (Book book : books) {
            if (book.getTitle().equals(bookName) &&
                    book.getAuthor().equals(author) &&
                    book.getPublisher().equals(publisher)
            ) {
                return true;
            }
        }
        return false;
    }

    private static boolean chekAddressInList(Address addressToCheck) {
        List<Book> books = getAllBooks();
        for (Book book : books) {
            for(Address address : book.getAddressList()){
                if(address.getAddressName().equals(addressToCheck.getAddressName())){
                    return true;
                }
            }
        }
         return false;
    }


    public static void deleteBook(String title, String author){
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Book WHERE title =: title AND  author =: author");
            query.setParameter("author", author);
            query.setParameter("title", title);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    //GET Book's id with specific address
    public static Integer getBooKId(String title, String author) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Integer> query = session.createNativeQuery("SELECT book_id FROM book_address ba" +
                    " WHERE book_id IN (SELECT id FROM Book b WHERE b.title = ? AND b.author =?)");

            query.setParameter(1,title);
            query.setParameter(2,author);
            Integer singleResult = query.getResultList().get(0);
            session.getTransaction().commit();
            return singleResult;
        }
    }



    public static void bookCreation(Book book) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  void update(Book book, Integer id) {
        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Query query = session.createNativeQuery("UPDATE book SET title = ?, author = ?, price= ?" +
                    " , publishdate=?, publisher = ?, reseller=?, pagecount=?," +
                    "verticalsize =?, horizontalsize=?,weight=?,language=?, istranslated=? WHERE id= ?",Book.class);
            query.setParameter(1, book.getTitle());
            query.setParameter(2, book.getAuthor());
            query.setParameter(3, book.getPrice());
            query.setParameter(4, book.getPublishDate());
            query.setParameter(5, book.getPublisher());
            query.setParameter(6, book.getReseller());
            query.setParameter(7, book.getPageCount());
            query.setParameter(8, book.getVerticalSize());
            query.setParameter(9, book.getHorizontalSize());
            query.setParameter(10, book.getWeight());
            query.setParameter(11, book.getLanguage());
            query.setParameter(12, book.isTranslated());
            query.setParameter(13, id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }


}
