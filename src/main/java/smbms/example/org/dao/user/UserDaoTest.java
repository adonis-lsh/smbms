package smbms.example.org.dao.user;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import smbms.example.org.pojo.User;
import smbms.example.org.utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

//    @Test
//    public void getUserList() {
//
//        //1.获取SqlSession对象
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        //2.执行SQL
//        // 方式一：getMapper
//        UserTestDao userDao = sqlSession.getMapper(UserTestDao.class);
//        List<User> userList = userDao.getUserList();
//        for (User user : userList) {
//            System.out.println(user);
//        }
//
//        //关闭sqlSession
//        sqlSession.close();
//    }

    @Test
    public void getUserLike() {

        //1.获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2.执行SQL
        // 方式一：getMapper
        UserTestDao userDao = sqlSession.getMapper(UserTestDao.class);
        List<User> userList = userDao.getUserLike("%李%");
        for (User user : userList) {
            System.out.println(user);
        }

        //关闭sqlSession
        sqlSession.close();
    }

//    @Test
//    public void addUser(){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserTestDao userDao = sqlSession.getMapper(UserTestDao.class);
//        User user = new User();
//        user.setId(16);
//        user.setUserCode("lihuihui");
//        user.setUserName("李胜辉");
//        user.setUserPassword("1234567");
//        user.setGender(1);
//        user.setPhone("15901458056");
//        user.setAddress("北京市");
//        userDao.addUser(user);
//        sqlSession.commit();
//        sqlSession.close();
//    }


//            return "User{" +
//                    "id=" + id +
//            ", userCode='" + userCode + '\'' +
//            ", userName='" + userName + '\'' +
//            ", userPassword='" + userPassword + '\'' +
//            ", gender=" + gender +
//            ", birthday=" + birthday +
//            ", phone='" + phone + '\'' +
//            ", address='" + address + '\'' +
//            ", userRole=" + userRole +
//            ", createdBy=" + createdBy +
//            ", creationDate=" + creationDate +
//            ", modifyBy=" + modifyBy +
//            ", modifyDate=" + modifyDate +
//            '}';

    @Test
    public void addUserByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserTestDao userDao = sqlSession.getMapper(UserTestDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 17);
        map.put("usercode", "wangxiaofeng");
        map.put("userName", "王晓峰");
        map.put("userPassword", "666666666");
        map.put("phone", "0213123123");
        map.put("address", "河北省");

        userDao.addUserByMap(map);
        sqlSession.commit();
        sqlSession.close();
    }
}