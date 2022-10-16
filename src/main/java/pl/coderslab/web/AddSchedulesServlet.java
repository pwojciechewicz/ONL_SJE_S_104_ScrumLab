package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "AddSchedulesServlet", value = "/app/plan/add")
public class AddSchedulesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath() + "/addSchedules.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        int id = admin.getId();

        Plan plan = new Plan();

        plan.setName(request.getParameter("planName"));
        plan.setDescription(request.getParameter("planDescription"));
        plan.setCreated(String.valueOf(LocalDateTime.now()));
        plan.setAdminId(id);

        PlanDao planDao = new PlanDao();
        planDao.create(plan);
        response.sendRedirect("/app/plan/list");
    }
}
