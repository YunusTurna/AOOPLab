package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ValuesOfFoods extends RecipeCreator{
    
    
    private static final String FILE_PATH = "lunchPrep/src/datas/foodlist.txt"; 


    public ValuesOfFoods(){
    
        
        
    }

    public void searchFood() {
        System.out.println("Please enter the name of the dish you want to check the nutritional values for: ");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        try {
            File file = new File(FILE_PATH);
            try (Scanner fileScanner = new Scanner(file)) {
                boolean foodFound = false;
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    if (line.contains(name)) {
                        foodFound = true;
                        for (int i = 0; i < 2; i++) {
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
                fileScanner.close();
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
            disp("Nutritional Values of Dishes");
            this.searchFood();
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
