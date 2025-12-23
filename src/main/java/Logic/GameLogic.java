package Logic;

import java.util.Arrays;
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
        String guess = "";
        // Last imputed word by the user
        char[] arrayGuess = new char[5];
        // Tells you the times a letter is repeated in the correct word
        int[] repetitions = {0,0,0,0,0};
        // Index to the first appearance of a letter
        int[] fa = {0,0,0,0,0};

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
                    repetitions = new int[]{0, 0, 0, 0, 0};

                    for(int i = 0; i < 5; i++) {
                        for(int j = 0; j < 5; j++) {
                            if(arrayGuess[i] == arrayWordle[j]) {
                                repetitions[i]++;
                            }
                        }
                    }

                    fa = new int[]{0, 1, 2, 3, 4};
                    for(int i = 1; i < 5; i++) {
                        for(int j = 1; i - j >= 0; j++) {
                            if (arrayGuess[i] == arrayGuess[i - j]) {
                                fa[i] = i - j;
                            }
                        }
                    }

                    // System.out.println(Arrays.toString(repetitions));
                    // System.out.println(Arrays.toString(fa));

                    for (int i = 0; i < 5; i++) {
                        if ((arrayGuess[i] == arrayWordle[i]) && (repetitions[fa[i]] > 0)) {
                            position[i] = true;
                            repetitions[fa[i]]--;
                            continue;
                        }

                        for (int j = 0; j < 5; j++) {
                            if (i != j) {
                                if ((arrayGuess[i] == arrayWordle[j]) && (repetitions[fa[i]] > 0)) {
                                    letter[i] = true;
                                    repetitions[fa[i]]--;
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

        if(wordle.toUpperCase().equals(guess)) {
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
