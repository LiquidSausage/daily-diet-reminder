public class DishRecipe{
    private String name;
    private int calories;
    private String recipeDescription;  
    
    
    // Costructor
    public DishRecipe(){
      dishRecipeNew();
    }

    // Constructing method
    public void dishRecipeNew(){
        // naming dishes
        System.out.println("What is the name of the dish you want to save?");
        this.name = Main.scanner.nextLine();

        // setting calories
        System.out.println("How many calories does the entire meal have?");
        this.calories = Integer.parseInt(Main.scanner.nextLine());

        // Step-by-step how to make dish
        System.out.println("Write there your way to make a dish step-by-step. Please mark steps with numbers. Type 'end' when you finish");
        StringBuilder dishStringBuilder = new StringBuilder();
        String input;
        while(!(input = Main.scanner.nextLine()).equalsIgnoreCase("end")){
            dishStringBuilder.append("\n" + input);
        }
        this.recipeDescription = dishStringBuilder.toString();
    }
    
    // Dish recipe print method
    @Override
    public String toString() {
        return "DishRecipe [name=" + name + ", + calories=" + calories + ", recipeDescription=" + recipeDescription + "]";
    }


}