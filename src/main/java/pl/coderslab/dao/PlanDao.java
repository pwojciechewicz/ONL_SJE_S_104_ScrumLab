package pl.coderslab.dao;

import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Admin;
import pl.coderslab.model.MealPlan;
import pl.coderslab.model.Plan;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanDao {
    // ZAPYTANIA SQL
    private static final String READ_PLAN_QUERY = "SELECT * from plan where id = ?;";
    private static final String FIND_ALL_PLANS_QUERY = "SELECT * FROM plan;";
    private static final String FIND_PLANS_BY_ADMIN_ID_QUERY = "SELECT COUNT(*) AS value FROM plan WHERE admin_id = ?";
    private static final String CREATE_PLAN_QUERY = "INSERT INTO plan(name, description, created, admin_id) VALUES (?,?,?,?);";
    private static final String DELETE_PLAN_QUERY = "DELETE FROM plan where id = ?;";
    private static final String UPDATE_PLAN_QUERY = "UPDATE	plan SET name = ? , description = ?, created = ?, admin_id = ? WHERE	id = ?;";
    private static final String READ_LAST_PLAN_QUERY = """
                    SELECT plan.name as plan_name, day_name.name as day_name, meal_name,  recipe.name as recipe_name
                    FROM `recipe_plan`
                             JOIN day_name on day_name.id=day_name_id
                             JOIN recipe on recipe.id=recipe_id
                             JOIN plan on recipe_plan.plan_id = plan.id
                            WHERE recipe_plan.plan_id =  (SELECT MAX(id) from plan WHERE admin_id = ?)
                    ORDER by day_name.display_order, recipe_plan.display_order;
            """;
    private static final String READ_PLAN_DETAILS_QUERRY = """
                    SELECT plan.name as plan_name, plan.description as plan_description, day_name.name as day_name, meal_name,  recipe.name as recipe_name
                    FROM `recipe_plan`
                             JOIN day_name on day_name.id=day_name_id
                             JOIN recipe on recipe.id=recipe_id
                             JOIN plan on recipe_plan.plan_id = plan.id
                    WHERE plan.id = ?
                    ORDER by day_name.display_order, recipe_plan.display_order;
            """;


    /**
     * Get plan by id
     *
     * @param planId
     * @return
     */
    public Plan read(Integer planId) {
        Plan plan = new Plan();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_PLAN_QUERY)
        ) {
            statement.setInt(1, planId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    plan.setId(resultSet.getInt("id"));
                    plan.setName(resultSet.getString("name"));
                    plan.setDescription(resultSet.getString("description"));
                    plan.setCreated(resultSet.getString("created"));
                    plan.setAdminId((resultSet.getInt("admin_id")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plan;

    }

    /**
     * Return all plans
     *
     * @return
     */
    public List<Plan> findAll() {
        List<Plan> planList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_PLANS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Plan planToAdd = new Plan();
                planToAdd.setId(resultSet.getInt("id"));
                planToAdd.setName(resultSet.getString("name"));
                planToAdd.setDescription(resultSet.getString("description"));
                planToAdd.setCreated(resultSet.getString("created"));
                planToAdd.setAdminId(resultSet.getInt("admin_id"));
                planList.add(planToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planList;

    }

    /**
     * Create plan
     *
     * @param plan
     * @return
     */
    public Plan create(Plan plan) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_PLAN_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, plan.getName());
            insertStm.setString(2, plan.getDescription());
            insertStm.setString(3, plan.getCreated());
            insertStm.setInt(4, plan.getAdminId());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    plan.setId(generatedKeys.getInt(1));
                    return plan;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Remove plan by id
     *
     * @param planId
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

    /**
     * Update plan
     *
     * @param planId
     */
    public void update(int planId, String name, String description, String created, int adminId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PLAN_QUERY)) {
            statement.setInt(5, planId);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setString(3, created);
            statement.setInt(4, adminId);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int countAdminPlans(Admin admin) {
        int count = 0;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_PLANS_BY_ADMIN_ID_QUERY);
        ) {
            statement.setInt(1, admin.getId());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            count = resultSet.getInt("value");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    public List<MealPlan> readLastPlan(Admin admin) {
        List<MealPlan> mealPlanList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_LAST_PLAN_QUERY);
        ) {
            statement.setInt(1, admin.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                MealPlan mealPlan = new MealPlan();
                mealPlan.setPlanName(resultSet.getString("plan_name"));
                mealPlan.setDayName(resultSet.getString("day_name"));
                mealPlan.setMealName(resultSet.getString("meal_name"));
                mealPlan.setRecipeName(resultSet.getString("recipe_name"));
                mealPlanList.add(mealPlan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mealPlanList;
    }
    public List<MealPlan> planDetails(int planId) {
        List<MealPlan> mealPlanList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_PLAN_DETAILS_QUERRY);
        ) {
            statement.setInt(1, planId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                MealPlan mealPlan = new MealPlan();
                mealPlan.setPlanName(resultSet.getString("plan_name"));
                mealPlan.setPlanDesription(resultSet.getString("plan_description"));
                mealPlan.setDayName(resultSet.getString("day_name"));
                mealPlan.setMealName(resultSet.getString("meal_name"));
                mealPlan.setRecipeName(resultSet.getString("recipe_name"));
                mealPlanList.add(mealPlan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mealPlanList;
    }
}