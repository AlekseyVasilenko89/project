package project.servlet;

import project.model.User;

import javax.servlet.*;
import java.io.IOException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/admin/*"})
public class AdminFilterServlet implements Filter {

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
        User userSession = (User) session.getAttribute("user");

        if (userSession != null && userSession.getRole().equals("admin")) {
            chain.doFilter(request, response);
        } else if (userSession != null && userSession.getRole().equals("user")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/user");
            dispatcher.forward(request, response);
        } else {
            res.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {

    }
}
