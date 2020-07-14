package smbms.example.org.servlet.user;
import smbms.example.org.pojo.User;
import smbms.example.org.service.user.UserService;
import smbms.example.org.service.user.UserServiceImpl;
import smbms.example.org.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(userCode, userPassword);
        if (null == loginUser) {
            req.setAttribute("error", "用户名或密码不争取");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute(Constants.USER_SESSION, loginUser);
            resp.sendRedirect("jsp/frame.jsp");
        }
    }
}
