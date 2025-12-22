package Logic;

import java.util.Scanner;

public class GameLogic {

    // Correct letter, wrong position, printed low
    static boolean[] letter;
    // Correct letter and position, printed cap
    static boolean[] position;

    public static void playGame(String wordle) {
        int tries = 5;
        // Correct word to compare
        char[] arrayWordle = wordle.toCharArray();

        Scanner sc = new Scanner(System.in);
        String guess;
        // Last imputed word by the user
        char[] arrayGuess = new char[5];

        System.out.println("In order to play remember:");
        System.out.println("Lower case letter: correct letter, wrong position.");
        System.out.println("Higher case letter: correct letter, correct position.");
        System.out.println("_ : incorrect letter\n");

        setArraysFalse();

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

            System.out.println();

            setArraysFalse();
            guess = sc.nextLine().toUpperCase();

            arrayGuess = guess.toCharArray();

            if(guess.length() == 5) {
                tries--;
                if(wordle.toUpperCase().equals(guess)) {
                    break;
                } else {
                    for (int i = 0; i < 5; i++) {
                        if (arrayGuess[i] == arrayWordle[i]) {
                            position[i] = true;
                            continue;
                        }

                        for (int j = 0; j < 5; j++) {
                            if (i != j) {
                                if (arrayGuess[i] == arrayWordle[j]) {
                                    letter[i] = true;
                                    break;
                                }
                            }
                        }
                    }
                }

            } else {
                System.out.println("Invalid word, it must be a 5 letter word. Try again.");
            }
        }

        if(arrayWordle == arrayGuess) {
            System.out.println("WIN: Correct word, you guessed it in " + (5 - tries) + " tries.");
        } else {
            System.out.println("LOOSE: You ran out of tries, correct word was: " + wordle);

        }
    }

    private static void setArraysFalse() {
        letter = new boolean[]{false, false, false, false, false};
        position = new boolean[]{false, false, false, false, false};
    }

}
