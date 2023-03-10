package pl.coderslab.model;

public class MealPlan {
    private String dayName;
    private String mealName;
    private String recipeName;
    private String planName;
    private String planDesription;
    private int recipePlanId;
    private int planId;
    private int mealDisplayOrder;
    private int recipeId;
    private int dayNameId;


    public MealPlan(String dayName, String mealName, String recipeName, String planName, String planDesription, int recipePlanId, int planId) {
        this.dayName = dayName;
        this.mealName = mealName;
        this.recipeName = recipeName;
        this.planName = planName;
        this.planDesription = planDesription;
        this.recipePlanId = recipePlanId;
        this.planId = planId;

    }

    public MealPlan(int recipeId, String mealName, int mealDisplayOrder,  int dayNameId , int planId) {
        this.mealName = mealName;
        this.planId = planId;
        this.mealDisplayOrder = mealDisplayOrder;
        this.recipeId = recipeId;
        this.dayNameId = dayNameId;
    }

    public MealPlan() {
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getRecipePlanId() {
        return recipePlanId;
    }

    public void setRecipePlanId(int recipePlanId) {
        this.recipePlanId = recipePlanId;
    }

    public String getDayName() {
        return dayName;
    }

    public int getMealDisplayOrder() {
        return mealDisplayOrder;
    }

    public void setMealDisplayOrder(int mealDisplayOrder) {
        this.mealDisplayOrder = mealDisplayOrder;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanDesription() {
        return planDesription;
    }

    public void setPlanDesription(String planDesription) {
        this.planDesription = planDesription;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getDayNameId() {
        return recipeId;
    }

    public void setDayNameId(int dayNameId) {
        this.dayNameId = dayNameId;
    }

}
