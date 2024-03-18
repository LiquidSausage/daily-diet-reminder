import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecipeManager recipeManager = new RecipeManager();
        boolean NavigationVisibility = true;
        Scanner scanner = new Scanner(System.in);

        while (NavigationVisibility == true) {
            System.out.println("1. Add Recipe");
            System.out.println("2. View Recipes");
            System.out.println("3. Export Recipes");
            System.out.println("4. Import Recipes");
            System.out.println("5. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                            System.out.print("Enter recipe name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter ingredients (comma-separated): ");
                            String[] ingredientsArray = scanner.nextLine().split(",");
                            List<String> ingredients = List.of(ingredientsArray);
                            Recipe recipe = new Recipe(name, ingredients);
                            recipeManager.addRecipe(recipe);
                            System.out.println("Recipe added successfully.");
                            break;
                        }
                case "2" -> {
                            List<Recipe> recipes = recipeManager.getRecipes();
                            for (Recipe r : recipes) {
                                System.out.println("Recipe: " + r.getName());
                                System.out.println("Ingredients: " + String.join(", ", r.getIngredients()));
                                System.out.println();
                                }
                        }
                    
                case "3" -> {
                            System.out.print("Enter filename to export: ");
                            String exportFilename = scanner.nextLine();
                            recipeManager.exportRecipes(exportFilename);
                        }
                    
                case "4" -> {
                            System.out.print("Enter filename to import: ");
                            String importFilename = scanner.nextLine();
                            recipeManager.importRecipes(importFilename);
                        }
                    
                case "5" -> {
                            System.out.println("Exiting the application. Goodbye!");
                            NavigationVisibility = false;
                        }
                    
                   
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
