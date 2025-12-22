package Logic;

import java.util.Scanner;

public class GameLogic {

    public static void playGame(String wordle) {
        int tries = 5;
        // Correct word to compare
        char[] arrayWordle = wordle.toCharArray();
        // Correct letter, wrong position, printed low
        boolean[] letter = new boolean[] {false, false, false, false, false};
        // Correct letter and position, printed cap
        boolean[] position = new boolean[] {false, false, false, false, false};

        Scanner sc = new Scanner(System.in);
        String guess;
        char[] arrayGuess = new char[5];

        System.out.println("In order to play remember:");
        System.out.println("Lower case letter: correct letter, wrong position.");
        System.out.println("Higher case letter: correct letter, correct position.");
        System.out.println("_ : incorrect letter\n");

        while (tries > 0) {
            System.out.println("You have " + tries + " tries left. Enter a valid 5 letter word to guess.");
            for(int i = 0; i < 5; i++) {
                if(position[i]) {
                    System.out.print(arrayWordle[i]);
                } else if(letter[i]) {
                    System.out.print(Character.toLowerCase(arrayGuess[i]));
                } else {
                    System.out.print("_");
                }
                System.out.print(" ");
            }

            guess = sc.nextLine().toUpperCase();

            arrayGuess = guess.toCharArray();

            if(guess.length() == 5){

                if(wordle.contains(guess)){
                    System.out.println("It contains");
                    for(int i = 0; i < 5; i++){
                        if(arrayWordle[i] == arrayGuess[i]) {
                            position[i] = true;
                        }
                    }
                }
                tries--;
            } else {
                System.out.println("Invalid word, it must be a 5 letter word. Try again.");
            }
        }
    }
}
