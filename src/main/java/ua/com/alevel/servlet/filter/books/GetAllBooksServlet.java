package ua.com.alevel.servlet.filter.books;



import ua.com.alevel.servlet.filter.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*Fixed: It's able to get all addresses for each book */
@WebServlet(urlPatterns = "/list-books.do")
public class GetAllBooksServlet extends HttpServlet {

	private BookService bookService = new BookService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("name");
		request.setAttribute("books", bookService.retrieveBooks());

		request.getRequestDispatcher("/WEB-INF/views/book/list-books.jsp").forward(
				request, response);
	}
}
