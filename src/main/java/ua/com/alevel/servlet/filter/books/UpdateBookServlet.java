package ua.com.alevel.servlet.filter.books;


import ua.com.alevel.servlet.dao.AddressDao;
import ua.com.alevel.servlet.dao.BookDao;
import ua.com.alevel.servlet.filter.service.BookService;
import ua.com.alevel.servlet.models.Address;
import ua.com.alevel.servlet.models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/update-book.do")
public class UpdateBookServlet extends HttpServlet {


    BookService bookService = new BookService();
    BookDao bookDao = new BookDao();
    private AddressDao addressDao = new AddressDao();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("addresses", addressDao.getAllAddresses());
        String author = request.getParameter("oldAuthor");
        String title = request.getParameter("oldTitle");
        Book oldBook = bookDao.getBooK(title,author);
        request.getSession().setAttribute("oldBook", oldBook);
        request.getRequestDispatcher("/WEB-INF/views/book/update-book.jsp").forward(
                request, response);


    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Book newBook = getNewBook(request);
        bookService.updateBook(newBook);;
        response.sendRedirect("/list-books.do");
    }

    private Book getNewBook(HttpServletRequest request) {
        Book oldBook = (Book) request.getSession().getAttribute("oldBook");
        String bookName = request.getParameter("title");
        String author = request.getParameter("author");
        Integer price = Integer.valueOf(request.getParameter("price"));
        String publisher = request.getParameter("publisher");
        String reseller = request.getParameter("reseller");
        Integer pages = Integer.valueOf(request.getParameter("pagecount"));
        Integer verticalSize = Integer.valueOf(request.getParameter("verticalsize"));
        Integer horizontalSize = Integer.valueOf(request.getParameter("horizontalsize"));
        Integer weight = Integer.valueOf(request.getParameter("weight"));
        String language = request.getParameter("language");
        Boolean isTranslated = Boolean.valueOf(request.getParameter("istranslated"));
        Date date = Date.valueOf(request.getParameter("date"));
        String addresses = request.getParameter("address");
        List<Address> addressList = new ArrayList<>();
        String[] address = addresses.split(";");

        for (String item : address) {
            addressList.add(addressDao.getAddressByName((item)));
        }
        Book newBook = new Book(bookName, author, price, date, publisher, reseller, pages, verticalSize,
                horizontalSize, weight, language, isTranslated);
        newBook.setAddressList(addressList);
        newBook.setId(oldBook.getId());
        return newBook;
    }



}
