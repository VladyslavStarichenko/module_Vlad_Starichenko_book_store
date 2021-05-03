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

@WebServlet(urlPatterns = "/update-address.do")
public class UpdateAddressServlet extends HttpServlet {

    AddressDao addressDao = new AddressDao();
    AddressService addressService = new AddressService();


    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String addressName = request.getParameter("oldAddress");
        Address oldAddress = addressDao.getAddressByName(addressName);
        request.getSession().setAttribute("oldAddress", oldAddress);
        request.getRequestDispatcher("/WEB-INF/views/address/update-address.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Address address = getNewAddress(request);
        addressService.updateAddress(address);;
        response.sendRedirect("/list-address.do");
    }

    private Address getNewAddress(HttpServletRequest request) {
        Address oldAddress = (Address) request.getSession().getAttribute("oldAddress");
        String addressName = request.getParameter("newAddressName");
        Address newAddress = new Address(addressName);
        newAddress.setId(oldAddress.getId());
        return newAddress;
    }
}
