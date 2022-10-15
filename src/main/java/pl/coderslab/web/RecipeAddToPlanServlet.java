package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.MealPlan;
import pl.coderslab.model.Plan;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RecipeToPlanServlet", value = "/app/recipe/plan/add")
public class RecipeAddToPlanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/recipetoplan.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MealPlan mealPlan = new MealPlan();
        mealPlan.setMealName(request.getParameter("mealName"));
        mealPlan.setMealDisplayOrder(Integer.parseInt(request.getParameter("mealDisplayOrder")));

        PlanDao planDao = new PlanDao();
        request.setAttribute("planNames", planDao.findAll());
//        Recipe recipe = new Recipe();
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        Plan plan = new Plan();
//        int id = Integer.parseInt(request.getParameter("id"));

        getServletContext().getRequestDispatcher("/recipetoplan.jsp").forward(request, response);


    }
}
