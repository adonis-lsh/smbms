package smbms.example.org.dao.user;

import smbms.example.org.pojo.User;

import java.sql.Connection;

public interface UserDao {
     User getLoginUser(Connection connection, String userCode) throws Exception;
}
