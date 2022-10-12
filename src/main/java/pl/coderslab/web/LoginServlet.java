package pl.coderslab.web;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;
import pl.coderslab.service.AdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AdminService adminService = new AdminService();
        AdminDao adminDao = new AdminDao();

        if (
                adminService.verifyLoginEmail(email) &&
                adminService.verifyLoginPassword(password, adminDao.findByEmail(email))) {
            request.getRequestDispatcher(request.getContextPath() + "/home.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

    }
}
