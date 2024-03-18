import java.io.*;
import java.util.*;

class RecipeManager {
    private List<Recipe> recipes;

    public RecipeManager() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void exportRecipes(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"))) {
            for (Recipe recipe : recipes) {
                writer.write(recipe.getName() + "\n");
                writer.write(String.join(",", recipe.getIngredients()) + "\n");
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
                String ingredientsLine = reader.readLine();
                String[] ingredientsArray = ingredientsLine.split(",");
                List<String> ingredients = List.of(ingredientsArray);
                Recipe recipe = new Recipe(name, ingredients);
                recipes.add(recipe);
            }
            System.out.println("Recipes imported successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


