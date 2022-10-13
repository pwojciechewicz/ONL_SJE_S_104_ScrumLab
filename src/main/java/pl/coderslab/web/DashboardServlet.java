package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.MealPlan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        RecipeDao recipeDao = new RecipeDao();
        int recipesQuantity = recipeDao.countAdminRecipe(admin);
        request.setAttribute("recipeQuantity", recipesQuantity);
        PlanDao planDao = new PlanDao();
        int plansQuantity = planDao.countAdminPlans(admin);
        request.setAttribute("plansQuantity", plansQuantity);

        List<MealPlan> mealPlanList = planDao.readLastPlan(admin);
        request.setAttribute("mealPlanList", mealPlanList);

        String planName = mealPlanList.get(0).getPlanName();
        request.setAttribute("planName", planName);

        request.getRequestDispatcher(request.getContextPath() + "/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
