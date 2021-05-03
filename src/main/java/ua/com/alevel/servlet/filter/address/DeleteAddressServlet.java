package ua.com.alevel.servlet.filter.address;


import ua.com.alevel.servlet.filter.service.AddressService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete-address.do")
public class DeleteAddressServlet extends HttpServlet {
    private AddressService addressService = new AddressService();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String addressName = request.getParameter("addressName");
        addressService.deleteAddress(addressName);
        response.sendRedirect("/list-address.do");
    }

}
