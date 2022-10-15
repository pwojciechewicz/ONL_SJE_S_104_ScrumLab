package pl.coderslab.web;

import pl.coderslab.dao.DayNameDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.DayName;
import pl.coderslab.model.MealPlan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "schedulesDetailsServlet", value = "/app/plan/details")
public class SchedulesDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));

        PlanDao planDao = new PlanDao();


        List<MealPlan> planDetailsList = planDao.planDetails(id);
        request.setAttribute("planDetailsList", planDetailsList);

        DayNameDao dayNameDao = new DayNameDao();
        List<DayName> dayNameList = dayNameDao.findAll();
        request.setAttribute("dayNameList", dayNameList);


        String planName = planDetailsList.get(0).getPlanName();
        request.setAttribute("planName", planName);

        String planDescription = planDetailsList.get(0).getPlanDesription();
        request.setAttribute("planDescription", planDescription);

        request.getRequestDispatcher(request.getContextPath() + "/schedulesDetails.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
