public class Navigation {
    static boolean MenuVisibility = true;

    public static void ShowMenu(){


        //Method shows avilable options
        System.out.println("Select a number from the menu");
        System.out.println("1. Show my daily dishes");
        System.out.println("2. Show my shopping list");
        System.out.println("3. Add / Remove recipes");
        System.out.println("4. Import / Export recipes");
        System.out.println("5. Account settings");
        System.out.println("6. Close assistant");

        //A looping mechanism that allows the user to continue using the program
        //...


        while (MenuVisibility) {
            switch (Main.scanner.nextLine()) {
                // Early stage of creating dish recipe 
                case "1" -> {   //Shows whole dishList
                                RecipesList.dishListPrint();
                            }
                
                case "2" -> {   // Shows your today list
                                System.out.println("It's your shopping list (In-Progress)");
                            }

                case "3" -> {   //Creating new dish > Shows new dish variables > Adding dish to dishList > Print whole dishList
                                DishRecipe dish = new DishRecipe();            
                                RecipesList.dishList.add(dish);
                                RecipesList.dishListPrint();
                            }
                
                case "4" -> {   // I/O files methods
                                System.out.println("I/O Files (in-progress)");
                            }
                
                case "5" -> {   // Account settings
                                System.out.println("It's your account settings (In-Progress)");
                            }
                
               
                case "6" -> {   // Exit method
                                MenuVisibility = false;
                            }
                default -> System.out.println("Chosen number is invalid. Try to choose numbers from 1 to 6");
            }
        }
    }
}








