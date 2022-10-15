package pl.coderslab.web;

import pl.coderslab.dao.RecipePlanDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteRecipeFromPlanServlet", value = "/delete/recipe/from/plan")
public class DeleteRecipeFromPlanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int recipePlanId = Integer.parseInt(request.getParameter("id1"));
        int planId = Integer.parseInt(request.getParameter("id2"));



        RecipePlanDao recipePlanDao = new RecipePlanDao();
        recipePlanDao.delete(recipePlanId);

        response.sendRedirect("/app/plan/details?id=" + planId);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
