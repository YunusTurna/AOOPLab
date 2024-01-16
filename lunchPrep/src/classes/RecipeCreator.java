package classes;

import java.util.Scanner;

public class RecipeCreator {

    public String[] userIngredients;

    public RecipeCreator(){

        getUserIngredients();
        IngreditentsShow();
        
    
    }

    public void getUserIngredients() {
        System.out.print("Please give us your ingredients (please split them with comma (','): ");
        try (Scanner sc = new Scanner(System.in)) {
            userIngredients = sc.nextLine().split(",");
            for (int i = 0; i < userIngredients.length; i++) {
                userIngredients[i] = userIngredients[i].trim();
            }
        }
    }


    public void IngreditentsShow(){
        System.out.print("Your ingredients are ");
            for(int i=0;i<userIngredients.length;i++){
                System.out.print(userIngredients[i]);
                if(i<userIngredients.length-1){

                    System.out.print(", ");




                }
            
                
            }
        System.out.println("");
    }

}



