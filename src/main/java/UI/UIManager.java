package UI;

import Data.DataManager;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class UIManager {
    private DataManager dataManager;
    private Scanner sc;

    public UIManager(DataManager dataManager) {
        this.dataManager = dataManager;
        sc = new Scanner(System.in);
    }

    public void runInterface() {
        int option = 0;
        System.out.println("WORDLE command game initialized!");
        while (true) {
            System.out.println("Select an option from the menu to proceed:");
            System.out.println("\n1. Play with a random word.");
            System.out.println("2. Play with selected word (for challenging your friends).");
            System.out.println("\n3. Close the game.");

            option = readInt();

            if (option > 0 && option < 4) {
                if (!handleMenuInput(option)) {
                    return;
                }
            } else {
                System.out.println("Please choose a valid action to perform.\n");
            }

        }
    }

    boolean handleMenuInput(int option) {
        int code;
        switch (option) {
            case (1):
                System.out.println("To select a word for playing please, introduce it's code.");
                System.out.println("NOTE: with current data it should be between 1 and " + (dataManager.getLines() - 1) + ".");
                System.out.println("Introducing a 0 will return you to the main menu.");
                code = readInt();
                while (code < 0 || (code > (dataManager.getLines() - 1))) {
                    System.out.println("Please select a valid option.");
                    System.out.println("NOTE: with current data it should be between 1 and " + (dataManager.getLines() - 1) + ".");
                    System.out.println("Introducing a 0 will return you to the main menu.");
                    code = readInt();
                }

                if(code != 0){
                    // PLAY game with code - 1
                }
                break;

            case 2:
                System.out.println("Playing with a random word:");
                // PLAY game
                break;

            case 3:
                System.out.println("Thanks for playing.");
                System.out.println("Exiting the system . . .");
                return false;

            default:
                System.out.println("Invalid option!");
                break;
        }

        return true;
    }

    int readInt() {
        boolean done = false;
        int option = 0;

        do {
            try {
                option = sc.nextInt();
                done = true;
            } catch (InputMismatchException e) {
                System.out.println("To choose an option you must enter an integer.");
                sc.nextLine();
            }
        } while (!done);

        sc.nextLine();

        return option;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public Scanner getScanner() {
        return sc;
    }

    public void setScanner(Scanner sc) {
        this.sc = sc;
    }
}
