package ua.com.alevel.servlet.filter.books;


import ua.com.alevel.servlet.dao.BookDao;
import ua.com.alevel.servlet.filter.service.BookService;
import ua.com.alevel.servlet.models.Address;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete-book.do")
public class DeleteBookServlet extends HttpServlet {

	private BookService bookService = new BookService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String address = request.getParameter("addressList");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
//		Address address1 = new Address();
//		address1.setAddressName(address);
//		Integer id = BookDao.getBooKId(address,title,author);
		bookService.deleteBook(title,author);
		response.sendRedirect("/list-books.do");
	}
}
