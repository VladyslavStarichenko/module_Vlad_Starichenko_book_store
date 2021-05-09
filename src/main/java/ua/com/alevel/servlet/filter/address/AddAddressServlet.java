package ua.com.alevel.servlet.filter.address;


import ua.com.alevel.servlet.dao.AddressDao;
import ua.com.alevel.servlet.filter.service.AddressService;
import ua.com.alevel.servlet.models.Address;
import ua.com.alevel.servlet.models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(urlPatterns = "/add-address.do")
public class AddAddressServlet extends HttpServlet {
    private AddressService addressService = new AddressService();
    private AddressDao addressDao = new AddressDao();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/address/add-address.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String addressName = request.getParameter("addressName");
        Address address = new Address(addressName);

        if (!addressDao.checkAddressExisting(addressName)) {
            addressService.addAddress(address);
            response.sendRedirect("/list-address.do");
        } else {
            request.setAttribute("errorMessage", "This address is already exists");
            request.getRequestDispatcher("/WEB-INF/views/book/add-todo.jsp").forward(
                    request, response);
        }


    }
}
