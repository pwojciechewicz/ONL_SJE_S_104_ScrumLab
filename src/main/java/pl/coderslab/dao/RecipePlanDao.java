package pl.coderslab.dao;

import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.MealPlan;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RecipePlanDao {
    // ZAPYTANIA SQL

    private static final String DELETE_PLAN_QUERY = "DELETE FROM recipe_plan where id = ?";
    private static final String CREATE_RECIPE_PLAN_QUERY = "INSERT INTO recipe_plan (recipe_id, meal_name, display_order, day_name_id, plan_id) VALUES (?, ?, ?, ?, ?)";

    /**
     * Get plan by id
     *
     * @param planId
     * @return
     */

    public void delete(Integer planId) {

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PLAN_QUERY)) {
            statement.setInt(1, planId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Plan not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    recipe_id, meal_name, display_order, day_name_id, plan_id
    public MealPlan create(MealPlan mealPlan) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_RECIPE_PLAN_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {

            insertStm.setInt(1, mealPlan.getRecipeId());
            insertStm.setString(2, mealPlan.getMealName());
            insertStm.setInt(3, mealPlan.getMealDisplayOrder());
            insertStm.setInt(4, mealPlan.getDayNameId());
            insertStm.setInt(5, mealPlan.getPlanId());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    mealPlan.setRecipePlanId(generatedKeys.getInt(1));
                    return mealPlan;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}