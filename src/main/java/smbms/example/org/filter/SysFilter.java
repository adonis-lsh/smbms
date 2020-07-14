package smbms.example.org.filter;

import com.sun.deploy.net.HttpRequest;
import smbms.example.org.pojo.User;
import smbms.example.org.utils.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        User user = (User) httpRequest.getSession().getAttribute(Constants.USER_SESSION);
        if (user == null) {
            httpServletResponse.sendRedirect("/smbms/error.jsp");
        } else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
