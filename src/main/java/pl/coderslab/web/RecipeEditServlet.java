package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "RecipeEditServlet", value = "/app/recipe/edit")
public class RecipeEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int recipeId = Integer.parseInt(request.getParameter("id"));
        RecipeDao recipeDao = new RecipeDao();
        Recipe recipe = recipeDao.read(recipeId);
        request.setAttribute("recipe", recipe);
        getServletContext().getRequestDispatcher("/recipeedit.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Recipe recipe = new Recipe();
        recipe.setId(Integer.parseInt(request.getParameter("id")));
        recipe.setName(request.getParameter("name"));
        recipe.setDescription(request.getParameter("ingredients"));
        recipe.setIngredients(request.getParameter("description"));
        recipe.setCreated(request.getParameter("created"));
        recipe.setUpdated(String.valueOf(LocalDateTime.now()));
        recipe.setPreparationTime(Integer.parseInt(request.getParameter("preparation_time")));
        recipe.setPreparation(request.getParameter("preparation"));
        recipe.setAdminId(Integer.parseInt(request.getParameter("id")));

        RecipeDao recipeDao = new RecipeDao();
        recipeDao.update(recipe);

        response.sendRedirect("/app/recipe/list");
    }
}

