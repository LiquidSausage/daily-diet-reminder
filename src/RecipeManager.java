import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class RecipeManager {
    private ArrayList<Recipe> recipes;

    public RecipeManager() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public ArrayList<Recipe> getAllDishesSortedByType(MealType dishType, ArrayList<Recipe> list){
        return list.stream()
                .filter(Recipe -> Recipe.getDishType() == dishType)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Recipe getRandomDishByType(MealType dishType, ArrayList<Recipe> list) {
        List<Recipe> filteredRecipes = list.stream()
                .filter(recipe -> recipe.getDishType() == dishType)
                .collect(Collectors.toList());
    
        if (filteredRecipes.isEmpty()) {
            return null; 
        }
    
        Random random = new Random();
        int randomIndex = random.nextInt(filteredRecipes.size());
        return filteredRecipes.get(randomIndex);
    }

    public ArrayList<Recipe> getSelectedDishes(){
       ArrayList<Recipe> todayDiet = new ArrayList<>();
        todayDiet.add(getRandomDishByType(MealType.LUNCH, recipes));
        todayDiet.add(getRandomDishByType(MealType.BREAKFAST, recipes));
        todayDiet.add(getRandomDishByType(MealType.SECONDBREAKFAST, recipes));
        todayDiet.add(getRandomDishByType(MealType.DINNER, recipes));
        return todayDiet;
    }

    public void exportRecipes(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"))) {
            for (Recipe recipe : recipes) {
                writer.write(recipe.getName() + "\n");
                writer.write(recipe.getDishType() + "\n");
                writer.write(String.join(",", recipe.getIngredients()) + "\n");
                writer.write(Integer.toString(recipe.getCalories()) + "\n");
                writer.write(String.join(",", recipe.getHowToMakeADish()) + "\n");
            }
           System.out.println("Recipes exported successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importRecipes(String filename) {
        recipes.clear();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name = line;
                MealType dishType = MealType.valueOf(reader.readLine());
                String ingredientsLine = reader.readLine();
                String[] ingredientsArray = ingredientsLine.split(",");
                List<String> ingredients = List.of(ingredientsArray);
                int calories = Integer.parseInt(reader.readLine());
                String makeToDishLine = reader.readLine();
                String[] makeToDishArray = makeToDishLine.split(",");
                List<String> makeToDish = List.of(makeToDishArray);
                Recipe recipe = new Recipe(name, dishType, ingredients, calories, makeToDish);
                recipes.add(recipe);
            }
            System.out.println("Recipes imported successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}