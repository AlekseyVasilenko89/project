package project.filter;

import project.model.User;
import project.service.UserService;
import project.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/login")
public class LoginFilter implements Filter {
    private UserService service = UserServiceImpl.getUserService();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletResponse res = (HttpServletResponse) response;
        final String name = request.getParameter("name");
        final String password = request.getParameter("password");
        User user = service.getByNameAndPassword(name, password);

        if (user != null) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {

    }
}
