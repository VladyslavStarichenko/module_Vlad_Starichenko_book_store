package ua.com.alevel.servlet.filter.login;


import ua.com.alevel.servlet.dao.UserDao;
import ua.com.alevel.servlet.helper.Security;

public class LoginService {

    public boolean isUserValid(String userName, String password) {
        return UserDao.checkUserExisting(userName) &&
                UserDao.getUser(userName).getName().equals(userName) &&
                UserDao.getUser(userName).getPassword().equals(Security.hasher(password));
    }

}
