package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RecipeEditServlet", value = "/app/recipe/edit")
public class RecipeEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/recipeedit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("loggedAdmin");
        int id = admin.getId();
        Recipe recipe = new Recipe();
        recipe.setId(Integer.parseInt(request.getParameter("id")));
        recipe.setName(request.getParameter("name"));
        recipe.setDescription(request.getParameter("ingredients"));
        recipe.setIngredients(request.getParameter("description"));
        recipe.setCreated(request.getParameter("created"));
        recipe.setUpdated(request.getParameter("updated"));
        recipe.setPreparationTime(Integer.parseInt(request.getParameter("preparation_time")));
        recipe.setPreparation(request.getParameter("preparation"));
        recipe.setAdminId(id);

        RecipeDao recipeDao = new RecipeDao();
        recipeDao.update(recipe);

        response.sendRedirect("/app/recipe/list");
    }
}

