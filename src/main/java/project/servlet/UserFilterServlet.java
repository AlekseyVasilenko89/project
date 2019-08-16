package project.servlet;

import project.model.User;
import project.service.UserService;
import project.service.UserServiceImpl;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/users", "/add", "/update", "/delete"})
public class UserFilterServlet implements Filter {
    private String encoding;
    private UserService service = UserServiceImpl.getUserService();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        final String name = req.getParameter("name");
        final String password = req.getParameter("password");
        User user = service.getByNameAndPassword(name, password);
        String getAtrRole = (String) session.getAttribute("role");

        if (user != null && user.getRole().equals("admin")) {
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            session.setAttribute("role", "admin");
            chain.doFilter(request, response);
        } else if (user != null && user.getRole().equals("user")) {
            res.sendRedirect("froUsers.jsp");
        } else if (getAtrRole != null && getAtrRole.equals("admin")) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect("index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
