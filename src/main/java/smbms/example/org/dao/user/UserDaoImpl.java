package smbms.example.org.dao.user;

import smbms.example.org.dao.BaseDao;
import smbms.example.org.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User getLoginUser(Connection connection, String userCode) throws Exception {
        final User[] user = {null};
        if (null != connection) {
            String sqlString = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};
            BaseDao.execute(connection, sqlString, params, rs -> {
                if (null != rs) {
                    try {
                        if (rs.next()) {
                            user[0] = new User();
                            user[0].setId(rs.getInt("id"));
                            user[0].setUserCode(rs.getString("userCode"));
                            user[0].setUserName(rs.getString("userName"));
                            user[0].setPassword(rs.getString("userPassword"));
                            user[0].setGender(rs.getInt("gender"));
                            user[0].setBirthday(rs.getDate("birthday"));
                            user[0].setPhone(rs.getString("phone"));
                            user[0].setAddress(rs.getString("address"));
                            user[0].setUserRole(rs.getInt("userRole"));
                            user[0].setCreatedBy(rs.getInt("createdBy"));
                            user[0].setCreationDate(rs.getTimestamp("creationDate"));
                            user[0].setModifyBy(rs.getInt("modifyBy"));
                            user[0].setModifyDate(rs.getTimestamp("modifyDate"));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        return user[0];
    }
}
