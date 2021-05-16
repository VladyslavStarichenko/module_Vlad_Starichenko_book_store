package ua.com.alevel.servlet.filter.books;


import ua.com.alevel.servlet.dao.AddressDao;
import ua.com.alevel.servlet.dao.BookDao;
import ua.com.alevel.servlet.filter.service.BookService;
import ua.com.alevel.servlet.helper.DateConvertor;
import ua.com.alevel.servlet.models.Address;
import ua.com.alevel.servlet.models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/add-book.do")
public class AddBookServlet extends HttpServlet {

    private BookService bookService = new BookService();
    private  BookDao bookDao = new BookDao();
    private AddressDao addressDao = new AddressDao();
    private DateConvertor dateConvertor = new DateConvertor();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getSession().getAttribute("title");
        request.setAttribute("addresses", addressDao.getAllAddresses());
        request.getRequestDispatcher("/WEB-INF/views/book/add-book.jsp").forward(
                request, response);
    }
/*Fixed: Address is adding properly now*/
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("title");
        String author = request.getParameter("author");
        Integer price = Integer.valueOf(request.getParameter("price"));
        String publisher = request.getParameter("publisher");
        String reseller = request.getParameter("reseller");
        Integer pages = Integer.valueOf(request.getParameter("pagecount"));
        Integer verticalSize = Integer.valueOf(request.getParameter("verticalsize"));
        Integer horizontalSize = Integer.valueOf(request.getParameter("horizontalSize"));
        Integer weight = Integer.valueOf(request.getParameter("weight"));
        String language = request.getParameter("language");
        Boolean isTranslated = Boolean.valueOf(request.getParameter("istranslated"));
        String stringDate = request.getParameter("date");
        String[] formatted = dateConvertor.dateFormat(stringDate);
        String resultDate = dateConvertor.dateConverting(formatted);
        Date date = Date.valueOf(resultDate);
        String addresses = request.getParameter("address");
        List<Address> addressList = new ArrayList<>();
        getListOfAddresses(addresses, addressList);
        Book book = new Book(bookName, author, price, date, publisher,
                reseller, pages, verticalSize, horizontalSize, weight, language, isTranslated, addressList);


        if (!bookDao.checkBookExisting(bookName, author, publisher)) {
            bookService.addBook(book);
            response.sendRedirect("/list-books.do");
        } else {
            request.setAttribute("errorMessage", "This task is already exists");
            request.getRequestDispatcher("/WEB-INF/views/book/add-todo.jsp").forward(
                    request, response);
        }


    }

    private void getListOfAddresses(String addresses, List<Address> addressList) {
        String[] address = addresses.split(";");

        for (String item : address) {

            addressList.add(addressDao.getAddressByName((item)));

        }
    }
}
