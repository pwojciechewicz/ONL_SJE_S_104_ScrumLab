package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddSchedulesServlet", value = "/app/plan/add")
public class AddSchedulesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath() + "/addSchedules.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Plan plan = new Plan();
        plan.setName(request.getParameter("planName"));
        plan.setDescription(request.getParameter("planDescription"));

       // plan.setAdminId();

        //session id
        //data

        PlanDao planDao = new PlanDao();
        planDao.create(plan);
        response.sendRedirect(request.getContextPath()+ "/app/plan/list");
    }
}
