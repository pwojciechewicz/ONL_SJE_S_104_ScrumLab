package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditSchedulesServlet", value = "/app/plan/edit")
public class EditSchedulesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int planId = Integer.parseInt(request.getParameter("id"));
        PlanDao planDao = new PlanDao();
        Plan plan = planDao.read(planId);
        request.setAttribute("plan", plan);
        request.getRequestDispatcher(request.getContextPath() + "/schedules/appEditSchedules.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String planName = request.getParameter("planName");
        String planDescription = request.getParameter("planDescription");
        int planId = Integer.parseInt(request.getParameter("planId"));

        PlanDao planDao = new PlanDao();
        planDao.update(planId, planName, planDescription);

        response.sendRedirect("/app/plan/list");
    }
}
