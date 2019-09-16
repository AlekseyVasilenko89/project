package project.servlet;

import project.model.User;
import project.service.UserService;
import project.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService service = UserServiceImpl.getUserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        final String name = request.getParameter("name");
        final String password = request.getParameter("password");
        User user = service.getByNameAndPassword(name, password);
        session.setAttribute("user", user);
        response.sendRedirect("admin/users");
    }
}
