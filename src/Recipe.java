import java.util.List;



class Recipe {
    
    private String name;
    private MealType dishType; 
    private int calories; 
    private List<String> ingredients;
    private List<String> howToMakeADish;

    public Recipe(String name, MealType dishType, List<String> ingredients, int calories, List<String> howToMakeADish) {
        this.name = name;
        this.dishType = dishType;
        this.dishType = dishType;
        this.calories = calories;
        this.ingredients = ingredients;
        this.howToMakeADish = howToMakeADish;
    }

    public String getName() {
        return name;
    }
    
    public MealType getDishType() {
        return dishType;
    }
    public List<String> getIngredients() {
        return ingredients;
    }

    public int getCalories() {
        return calories;
    }

    public List<String> getHowToMakeADish() {
        return howToMakeADish;
    }
}