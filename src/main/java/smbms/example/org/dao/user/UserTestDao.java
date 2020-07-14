package smbms.example.org.dao.user;

import smbms.example.org.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserTestDao {
    List<User> getUserList();

    void addUser(User user);

    void addUserByMap(Map<String, Object> map);

    List<User> getUserLike(String value);
}
