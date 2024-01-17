package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import mainFiles.Main;

public class RecipeCreator extends Main {

    public String[] userIngredients;

    public RecipeCreator(){
        System.out.println("Welcome to own ingredients recipe generator. Now you can give us your own ingredients that already you have and we can show you recipes that you can make. ");
        getUserIngredients();
        IngredientsSearch();
        
        
        
    }
        
   public void Loop(){

        getUserIngredients();
        IngredientsSearch();
        System.out.println("If you want to look another recipe press 1 and enter but if you want to return main menu press 2 and enter: ");
        try (Scanner sc = new Scanner(System.in)) {
            int newNewChoice = sc.nextInt();
            if(newNewChoice==1){

            
            }
            else if (newNewChoice == 2){
                mainMenuDisplay();
            }
        }
    
    
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


    public String IngreditentsShow(){
        
        String token = "Ingredients: ";
            for(int i=0;i<userIngredients.length;i++){
                token += userIngredients[i];
                if(i<userIngredients.length-1){

                    token += ", ";




                }
            
                
            }
        return token;

    }

    public void IngredientsSearch(){
    
        
        
        
        try {
            File file = new File("lunchPrep/src/datas/foodlist.txt");
            try (Scanner fileScanner = new Scanner(file)) {
                boolean foodFound = false;
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    if (line.contains(IngreditentsShow())) {
                        foodFound = true;
                        for (int i = 0; i < 5; i++) {
                            if (fileScanner.hasNextLine()) {
                                System.out.println(fileScanner.nextLine());
                            }
                        }
                        
                        break;
                    }
                }
                if (!foodFound) {
                    System.out.println("There isn't any food that you can make.");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }


    }

}



