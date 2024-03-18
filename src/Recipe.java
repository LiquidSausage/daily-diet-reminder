import java.util.List;

class Recipe {
    private String name;
    private int calories; 
    private List<String> ingredients;
    private List<String> makeToDish;

    public Recipe(String name, List<String> ingredients, int calories, List<String> makeToDish) {
        this.name = name;
        this.calories = calories;
        this.ingredients = ingredients;
        this.makeToDish = makeToDish;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public int getCalories() {
        return calories;
    }

    public List<String> getMakeToDish() {
        return makeToDish;
    }
}