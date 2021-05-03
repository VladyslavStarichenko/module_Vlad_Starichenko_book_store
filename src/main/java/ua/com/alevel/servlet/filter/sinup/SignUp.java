package ua.com.alevel.servlet.filter.sinup;


import ua.com.alevel.servlet.dao.UserDao;
import ua.com.alevel.servlet.helper.Security;
import ua.com.alevel.servlet.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/sign-up.do")
public class SignUp extends HttpServlet {

    private Security security = new Security();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/sign-up.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean isNameNoTFreeToUse = UserDao.checkUserExisting(name);

        if (!isNameNoTFreeToUse && !name.equals("") && !password.equals("")) {


            String salted = security.salt(password);
            String peppered = security.pepper(salted);
            String hashed = security.hasher(peppered);

            User user = new User(name, hashed);
            UserDao.createUser(name, user);
            response.sendRedirect("/login.do");
        } else if (isNameNoTFreeToUse) {
            request.setAttribute("errorMessage", "User with same name is already exists, try another one!");
            request.getRequestDispatcher("/WEB-INF/views/sign-up.jsp").forward(
                    request, response);
        } else {
            request.setAttribute("errorMessage", "Fields can't be empty");
            request.getRequestDispatcher("/WEB-INF/views/sign-up.jsp").forward(
                    request, response);
        }
    }
}

