package mainFiles;


import classes.*;
import java.util.Scanner;



public class Main{
    public static void main(String[] args){
        starter();
    
        
    }


    public static void starter(){
        System.out.print("\033[H\033[2J");
        mainMenuDisplay();
        menuSurf();
    }


    public static void mainMenuDisplay(){

        System.out.println("------------Main Menu------------");
        System.out.println("1. Own Ingredients to Recipe");
        System.out.println("2. Nutrutional Values of Foods");
        System.out.println("3. Random Menu");
        System.out.println("4. Menu for Every Budget");
        System.out.println("5. Exit the Programme");
        System.out.print("\nEnter your choice: ");
     
            

    }

    public static void menuSurf(){
        
        try (Scanner sc = new Scanner(System.in)) {
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                RecipeCreator rc = new RecipeCreator();
                menuSurf();
               
            
   }
        }

            
}
}
            
        


    


