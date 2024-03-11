import java.util.ArrayList;

public class RecipesList{

    static ArrayList<DishRecipe> dishList = new ArrayList<DishRecipe>();
    
    
    // Print whole dish list
    public static void dishListPrint(){
        for(DishRecipe x : dishList){
            System.out.println(x);
        }
    }

}
