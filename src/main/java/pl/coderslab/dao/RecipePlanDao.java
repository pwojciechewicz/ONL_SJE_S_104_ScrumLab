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
    private static final String CREATE_RECIPE_PLAN_QUERY = "INSERT INTO recipe_plan (meal_name, display_order) VALUES (?,?)";

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

    public MealPlan create(MealPlan mealPlan) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_RECIPE_PLAN_QUERY, PreparedStatement.RETURN_GENERATED_KEYS)) {

            insertStm.setString(1, mealPlan.getMealName());
            insertStm.setInt(2, mealPlan.getMealDisplayOrder());
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