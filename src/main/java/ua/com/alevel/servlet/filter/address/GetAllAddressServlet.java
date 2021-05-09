package ua.com.alevel.servlet.filter.address;

import ua.com.alevel.servlet.filter.service.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/list-address.do")
public class GetAllAddressServlet extends HttpServlet {
private AddressService addressService = new AddressService();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("addresses", addressService.retrieveAddresses());
        request.getRequestDispatcher("/WEB-INF/views/address/list-addresses.jsp").forward(
                request, response);
    }
}
