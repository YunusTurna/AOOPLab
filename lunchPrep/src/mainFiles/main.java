package mainFiles;


import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import classes.*;




public class Main{
    public static void main(String[] args) throws FileNotFoundException{
        RecipeCreator rc = new RecipeCreator();
        ValuesOfFoods vof = new ValuesOfFoods();
        

        String disp = "--------";

        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("\033[H\033[2J");
            disp("Main Menu");
            System.out.println("1. Own Ingredients to Recipe");
            System.out.println("2. Nutritional Values of Dishes");
            System.out.println("3. Random Menu");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            
            

            switch (choice) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    disp("Own Ingredients to Recipe");
                    rc.getUserIngredients();
                    rc.IngredientsSearch();
                    
                    rc.ask();
                    
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    disp("Nutritional Values of Dishes");
                    vof.searchFood();
                    
                    vof.ask();
                    
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    RandomMenu rm = new RandomMenu("lunchPrep/src/datas/foodlist.txt", "lunchPrep/src/datas/souplist.txt");
                    rm.getMenu();
                    rm.ask();
                    break;

                case 4:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            
        } while (choice != 4);
    }
    public static void disp (String menu){
        String disp = "--------";
        System.out.println(disp+menu+disp);
        
    }
}

    
  

            

    
        


    


