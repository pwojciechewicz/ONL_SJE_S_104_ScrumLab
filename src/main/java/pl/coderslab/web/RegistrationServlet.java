package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Registration", value = "/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(request.getContextPath() + "/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        Admin admin = new Admin(name, surname, email, password, 0, 1);
        AdminDao adminDao = new AdminDao();
        adminDao.create(admin);

        request.getRequestDispatcher(request.getContextPath() + "/login").forward(request, response);
    }
}
