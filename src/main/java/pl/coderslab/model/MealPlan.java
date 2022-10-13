package pl.coderslab.model;

public class MealPlan {
    private String dayName;
    private String mealName;
    private String recipeName;
    private String planName;
    private String planDesription;

    public MealPlan(String dayName, String mealName, String recipeName, String planName, String planDesription) {
        this.dayName = dayName;
        this.mealName = mealName;
        this.recipeName = recipeName;
        this.planName = planName;
        this.planName = planDesription;
    }
    public MealPlan() {
    }

    public String getDayName() {
        return dayName;
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
}
