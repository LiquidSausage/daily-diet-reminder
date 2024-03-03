import java.util.*;
public class Navigation {
    static boolean MenuVisibility = true;

    public static void ShowMenu() {


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
                case "1" -> System.out.println("It's your dishes list (In-Progress)");
                case "2" -> System.out.println("It's your shopping list (In-Progress)");
                case "3" -> System.out.println("It's add / remove option (In-Progress)");
                case "4" -> System.out.println("It's your import / export files (In-Progress)");
                case "5" -> System.out.println("It's your account settings (In-Progress)");
                case "6" -> MenuVisibility = false;
                default -> System.out.println("Chosen number is invalid. Try to choose numbers from 1 to 6");
            }
        }
    }
}








