package pl.coderslab.web;

import pl.coderslab.dao.AdminDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RecipeAddServlet", value = "/app/recipe/add")
public class RecipeAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/recipeadd.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Recipe recipe = new Recipe();
        recipe.setName(request.getParameter("name"));
        recipe.setDescription(request.getParameter("ingredients"));
        recipe.setIngredients(request.getParameter("description"));
//        recipe.setCreated(request.getParameter("created"));
//        recipe.setUpdated(request.getParameter("updated"));
        recipe.setPreparationTime(Integer.parseInt(request.getParameter("preparation_time")));
        recipe.setPreparation(request.getParameter("preparation"));
        session.getAttribute("loggedAdmin");

        RecipeDao recipeDao = new RecipeDao();
        recipeDao.create(recipe);

        response.sendRedirect("/app/recipe/list");
    }
}
