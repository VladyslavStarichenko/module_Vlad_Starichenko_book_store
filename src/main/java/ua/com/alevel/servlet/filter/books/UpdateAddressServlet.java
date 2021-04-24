package ua.com.alevel.servlet.filter.books;



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
public class UpdateAddressServlet extends HttpServlet {

    private Integer oldBookId;
    String oldAuthor;
    String oldTitle;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String address = request.getParameter("address");

         oldAuthor = (String)(request.getSession().getAttribute("oldAuthor"));
         oldTitle = (String)(request.getSession().getAttribute("oldTitle"));

        request.getSession().setAttribute("author", author);
        request.getSession().setAttribute("title", title);
        request.getSession().setAttribute("address", address);
        request.getRequestDispatcher("/WEB-INF/views/update-book.jsp").forward(
                request, response);


    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {



        oldBookId = BookDao.getBooKId(oldTitle,oldAuthor);

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
        LocalDate date = LocalDate.now();
        Date dateToSet = Date.valueOf(date);
        String addressOfBook = request.getParameter("address");
        Address address = new Address();
        address.setAddressName(addressOfBook);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        Book book = new Book(bookName,author,price, dateToSet,publisher,reseller,pages,verticalSize,
                horizontalSize,weight,language,isTranslated);
        book.setAddressList(addresses);

        BookDao bookDao = new BookDao();
        bookDao.update(book,oldBookId);


        response.sendRedirect("/list-books.do");
    }

}
