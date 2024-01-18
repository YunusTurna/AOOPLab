package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import mainFiles.Main;

public class RecipeCreator  extends Main{
    private static final String FILE_PATH = "lunchPrep/src/datas/foodlist.txt"; 
    

    public RecipeCreator(){}

    public String[] userIngredients;
    

    public void getUserIngredients() {
        System.out.println("Please give us your ingredients (split them with comma (','): ");
        Scanner sc = new Scanner(System.in) ;
            userIngredients = sc.nextLine().split(",");
            for (int i = 0; i < userIngredients.length; i++) {
                userIngredients[i] = userIngredients[i].trim();
            
            
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
            File file = new File(FILE_PATH);
            Scanner fileScanner = new Scanner(file);
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
                
            
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }


    }

    public void ask(){
    
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.printf("If you want to look another recipe press 1 and if you want to go back to main menu press 2: ");
        String option = sc.nextLine();
        
        switch (Integer.parseInt(option)){
            case 1:
            System.out.print("\033[H\033[2J");
            disp("Own Ingredients to Recip");
            this.getUserIngredients();
            this.IngredientsSearch();
            this.ask();
            break;
            case 2:
            break;
            
            default:
            System.out.println("Invalid Option");
            this.ask();
            }

    }

    




}



