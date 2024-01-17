package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecipeCreator {

    private String[] userIngredients;

    public RecipeCreator() {
        System.out.println("Welcome to your own ingredients recipe generator. Enter your ingredients, separated by commas:");
        getUserIngredients();
        IngredientsSearch();
        loop();
    }

    private void loop() {
        System.out.println("Press 1 to search for another recipe, or 2 to return to the main menu: ");
        try (Scanner sc = new Scanner(System.in)) {
            int choice = sc.nextInt();
            if (choice == 1) {
                loop();
            } else if (choice == 2) {
                Main.menuSurf();
            }
        }
    }

    private void getUserIngredients() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Please give us your ingredients (split them with commas): ");
            userIngredients = sc.nextLine().split(",");
            for (int i = 0; i < userIngredients.length; i++) {
                userIngredients[i] = userIngredients[i].trim();
            }
        }
    }

    private String ingredientsShow() {
        StringBuilder token = new StringBuilder("Ingredients: ");
        for (int i = 0; i < userIngredients.length; i++) {
            token.append(userIngredients[i]);
            if (i < userIngredients.length - 1) {
                token.append(", ");
            }
        }
        return token.toString();
    }

    private void IngredientsSearch() {
        try {
            File file = new File("lunchPrep/src/datas/foodlist.txt");
            try (Scanner fileScanner = new Scanner(file)) {
                boolean foodFound = false;
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    if (line.contains(ingredientsShow())) {
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

