package ua.com.alevel.servlet.filter.login;


import ua.com.alevel.servlet.dao.UserDao;
import ua.com.alevel.servlet.helper.Security;

public class LoginService {

    private Security security = new Security();



    public boolean isUserValid(String userName, String password) {
        String salted = security.salt(password);
        String peppered = security.pepper(salted);
        String hashed = security.hasher(peppered);
        return UserDao.checkUserExisting(userName) &&
                UserDao.getUser(userName).getName().equals(userName) &&
                UserDao.getUser(userName).getPassword().equals(hashed);
    }

}
