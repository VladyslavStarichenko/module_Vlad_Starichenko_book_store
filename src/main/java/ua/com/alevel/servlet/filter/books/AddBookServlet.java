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
import java.time.LocalDate;
import java.sql.Date;

@WebServlet(urlPatterns = "/add-book.do")
public class AddBookServlet extends HttpServlet {

	private BookService bookService = new BookService();

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-book.jsp").forward(
				request, response);
	}

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
		LocalDate date = LocalDate.now();
		Date dateToSet = Date.valueOf(date);
		String addressOfBook = request.getParameter("address");
		Address address = new Address();
        address.setAddressName(addressOfBook);
		Book book = new Book(bookName,author,price,dateToSet,publisher,
				reseller,pages,verticalSize,horizontalSize,weight,language,isTranslated);
        book.addAddress(address);
        book.setAddressList(book.getAddressList());



		if(!BookDao.checkBookExisting(bookName,author,publisher)){
			bookService.addBook(book);
			response.sendRedirect("/list-books.do");
		}else {
			request.setAttribute("errorMessage", "This task is already exists");
			request.getRequestDispatcher("/WEB-INF/views/add-todo.jsp").forward(
					request, response);
		}


	}
}
