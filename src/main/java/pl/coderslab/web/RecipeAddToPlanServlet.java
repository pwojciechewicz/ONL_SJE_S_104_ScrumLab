package pl.coderslab.web;

import pl.coderslab.dao.DayNameDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.DayName;
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

        PlanDao planDao = new PlanDao();
        request.setAttribute("planNames", planDao.findAll());

        RecipeDao recipeDao = new RecipeDao();
        request.setAttribute("recipeNames", recipeDao.findAll());

        DayNameDao dayNameDao = new DayNameDao();
        request.setAttribute("dayNames", dayNameDao.findAll());

        getServletContext().getRequestDispatcher("/recipetoplan.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int recipeId = Integer.parseInt(request.getParameter("recipeId"));
        String mealName = request.getParameter("mealName");
        int mealDisplayOrder = Integer.parseInt(request.getParameter("mealDisplayOrder"));
        int dayNameId = Integer.parseInt(request.getParameter("dayId"));
        int planId = Integer.parseInt(request.getParameter("planId"));

        MealPlan mealPlan = new MealPlan(recipeId, mealName, mealDisplayOrder, dayNameId, planId);

        RecipePlanDao recipePlanDao = new RecipePlanDao();

        recipePlanDao.create(mealPlan);

        response.sendRedirect("/app/plan/list");


//        Recipe recipe = new Recipe();
//        int recipeId = Integer.parseInt(request.getParameter("recipeName"));
//
//        Plan plan = new Plan();
//        int planId = Integer.parseInt(request.getParameter("planName"));
//
//        DayName dayName = new DayName();
//        int dayNameId = Integer.parseInt(request.getParameter("dayName"));
//
//        MealPlan mealPlan = new MealPlan();
//        mealPlan.setRecipeId(recipeId);
//        mealPlan.setMealName(request.getParameter("mealName"));
//        mealPlan.setMealDisplayOrder(Integer.parseInt(request.getParameter("mealDisplayOrder")));
//        mealPlan.setDayNameId(dayNameId);
//        mealPlan.setPlanId(planId);
//
//        RecipePlanDao recipePlanDao = new RecipePlanDao();
//        recipePlanDao.create(mealPlan);
//        response.sendRedirect("/app/plan/list");
//        getServletContext().getRequestDispatcher("/recipetoplan.jsp").forward(request, response);


    }
}
