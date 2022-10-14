package pl.coderslab.web;

import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RecipeDetailsServlet", value = "/app/recipe/details")
public class RecipeDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Recipe recipe = new Recipe();
        int id = Integer.parseInt(request.getParameter("id"));

        RecipeDao recipeDao = new RecipeDao();
        request.setAttribute("recipeName", recipeDao.read(id));

        getServletContext().getRequestDispatcher("/recipedetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
