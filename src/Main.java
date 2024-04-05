import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        RecipeManager recipeManager = new RecipeManager();
        boolean NavigationVisibility = true;
        Scanner scanner = new Scanner(System.in);

        while (NavigationVisibility == true) {
            System.out.println("---------- Choose option by typing number ----------" + "\n");
            System.out.println("1. Add new recipe");
            System.out.println("2. View all recipes or find exact recipe");
            System.out.println("3. Create a diet for tomorrow");
            System.out.println("4. Export Recipes to file");
            System.out.println("5. Import Recipes from file");
            System.out.println("6. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    // Step 1 - Setting name
                    System.out.print("Enter recipe name: ");
                    String name = scanner.nextLine();
                    
                    // Step 2 - Set dish type
                    MealType dishType = null;
                    while (dishType == null) {
                     try {
                            System.out.print("Enter dish type (Breakfast, SecondBreakfast, Lunch, Dinner): ");
                            String dishTypeInput = scanner.nextLine().toUpperCase();
                            dishType = MealType.valueOf(dishTypeInput);
                    } catch (IllegalArgumentException e) {
                            System.out.println("Invalid argument. Select one of the above options");
                    }
                    }

                    // Step 3 - Adding ingredients separated by comma
                    System.out.print("Enter ingredients (comma-separated): ");
                    String[] ingredientsArray = scanner.nextLine().split(",");
                    List<String> ingredients = List.of(ingredientsArray);
                    
                    // Step 4 - Step-by-step guide on how to cook dish. Every step in new line! "end" moves to next step.
                    System.out.println("Enter instructions on how to make the dish (type 'end' to finish):");
                    List<String> makeToDish = new ArrayList<>();
                    while (true) {
                        String temp = scanner.nextLine();
                        if (temp.equalsIgnoreCase("end")) {
                            break;
                        } else {
                            makeToDish.add(temp);
                        }
                    }
                    // Step 5 - Set calories
                    System.out.print("Enter calories: ");
                    int calories = Integer.parseInt(scanner.nextLine());

                    //Step 6 - recipe added
                    Recipe recipe = new Recipe(name, dishType, ingredients, calories, makeToDish);
                    recipeManager.addRecipe(recipe);
                    System.out.println("Recipe added successfully.");
                    break;
                }
                case "2" -> {
                    ArrayList<Recipe> recipes = recipeManager.getRecipes();
                    System.out.println("1. Show all recipes");
                    System.out.println("2. Find my recipe");
                    switch(scanner.nextLine()){
                        case "1" -> {
                            if(recipes.isEmpty()){
                                System.out.println("There is no recipes to show");
                            }
                            else{
                            for (Recipe r : recipes) {
                                System.out.println("Recipe: " + r.getName());
                                System.out.println(r.getDishType());
                                System.out.println("Ingredients: " + String.join(", ", r.getIngredients()));
                                System.out.println("It has "+ r.getCalories() + " calories");
                                System.out.println("Steps: " + String.join(", ", r.getHowToMakeADish()));
                            }
                        }
                        }
                        case "2" -> {
                            System.out.println("Enter dish name that you are looking for");
                            String recipeName = scanner.nextLine();
                            Optional<Recipe> foundRecipe = recipes.stream()
                            .filter(recipe -> recipe.getName().equalsIgnoreCase(recipeName))
                            .findFirst();

                            if (foundRecipe.isPresent()) {
                                Recipe recipe = foundRecipe.get();
                                System.out.println("Recipe found: " + recipe.getName());
                                System.out.println("Ingredients: " + String.join(", ", recipe.getIngredients()));
                                System.out.println("It has "+ recipe.getCalories() + " calories");
                                System.out.println("Steps: " + String.join(", ", recipe.getHowToMakeADish()));
                            } else {
                                System.out.println("No recipe found with the name: " + recipeName);
                            }
                    }
                    }
                }
                case "3" -> {
                    ArrayList<Recipe> todayDiet = recipeManager.getSelectedDishes();
                    for (Recipe x : todayDiet){
                        System.out.println(x.getName());
                    }
                    
                }
                case "4" -> {
                            System.out.print("Enter filename to export: ");
                            String exportFilename = scanner.nextLine();
                            recipeManager.exportRecipes(exportFilename);
                        }
                    
                case "5" -> {
                            System.out.print("Enter filename to import: ");
                            String importFilename = scanner.nextLine();
                            recipeManager.importRecipes(importFilename);
                        }
                    
                case "6" -> {
                            System.out.println("Exiting the application. Goodbye!");
                            NavigationVisibility = false;
                        }
                    
                   
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
