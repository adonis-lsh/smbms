package smbms.example.org.service.user;

import smbms.example.org.dao.BaseDao;
import smbms.example.org.dao.user.UserDao;
import smbms.example.org.dao.user.UserDaoImpl;
import smbms.example.org.pojo.User;

public class UserServiceImpl implements UserService{
    @Override
    public User login(String userCode, String password) {
        User loginUser = null;
        try {
            UserDao userDao = new UserDaoImpl();
            loginUser = userDao.getLoginUser(BaseDao.getConnection(), userCode);
            if (!loginUser.getUserPassword().equals(password)) {
                loginUser = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loginUser;
    }
}
