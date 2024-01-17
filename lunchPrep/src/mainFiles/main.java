package mainFiles;

import classes.RecipeCreator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        starter();
    }

    public static void starter() {
        System.out.print("\033[H\033[2J");
        mainMenuDisplay();
        menuSurf();
    }

    public static void mainMenuDisplay() {
        System.out.println("------------Main Menu------------");
        System.out.println("1. Own Ingredients to Recipe");
        System.out.println("2. Nutritional Values of Foods");
        System.out.println("3. Random Menu");
        System.out.println("4. Menu for Every Budget");
        System.out.println("5. Exit the Programme");
        System.out.print("\nEnter your choice: ");
    }

    public static void menuSurf() {
        try (Scanner sc = new Scanner(System.in)) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    new RecipeCreator();
                    break;
                // Add cases for other menu options as needed
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

    


