package ua.com.alevel.servlet.filter.service;


import ua.com.alevel.servlet.dao.BookDao;
import ua.com.alevel.servlet.models.Book;

import java.util.List;

public class BookService {
    BookDao bookDao = new BookDao();

    public List<Book> retrieveBooks() {
        return bookDao.getAllBooks();
    }

    public void addBook(Book book) {
        bookDao.createBook(book.getTitle(),book.getAuthor(),book.getPublisher(),book);
    }

    public void deleteBook(String title, String author) {

        bookDao.deleteBook(title,author);
    }

    public void updateBook(Book book){
        bookDao.updateBook(book);
    }

}
