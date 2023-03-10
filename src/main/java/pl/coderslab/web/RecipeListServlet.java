package pl.coderslab.web;

import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RecipeShowServlet", value = "/app/recipe/list")
public class RecipeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecipeDao recipeDao = new RecipeDao();
        request.setAttribute("recipes", recipeDao.findAll());
        getServletContext().getRequestDispatcher("/recipelist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
