package smbms.example.org.service.user;

import smbms.example.org.pojo.User;

public interface UserService {
    //用户登录
    User login(String userCode, String password);
}
