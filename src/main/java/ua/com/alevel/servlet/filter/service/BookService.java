package ua.com.alevel.servlet.filter.service;

import ua.com.alevel.servlet.dao.AddressDao;
import ua.com.alevel.servlet.dao.BookDao;
import ua.com.alevel.servlet.models.Address;
import ua.com.alevel.servlet.models.Book;

import java.util.List;

public class BookService {

    public List<Book> retrieveBooks() {
        return BookDao.getAllBooks();
    }

    public void addBook(Book book) {
        BookDao.createBook(book.getTitle(),book.getAuthor(),book.getPublisher(),book);
    }

    public void deleteBook(String title, String author) {

       BookDao.deleteBook(title,author);
    }


    public List<Address> retrieveAddresses(String bookName, String bookAuthor){
        return AddressDao.getAddressNameForCertainBook(bookName,bookAuthor);
    }

}
