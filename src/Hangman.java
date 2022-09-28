import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        hangman("WATA");
    }

    /**
     * Main method to run the game.
     *
     * @param word      String to be guessed
     */
    private static void hangman(String word){
        //print out word length (according to assignment)
        System.out.println("The word to guess has " + word.length() + " letters.");

        //for player input
        Scanner scanner = new Scanner(System.in);

        //everything here is handles as uppercase (easier to code)
        word = word.toUpperCase();

        //create a string with an amount of underscores equal to the length of the word that has to be guessed
        //i.e, if word is "WAT" then guessedWord is "___"
        String guessedWord = "";
        for(int i = 0; i < word.length(); i++){
            guessedWord += "_";
        }

        //player can only guess 7 times
        //if he guesses the same thing or inputs something wrong, value doesn't decrease (according to assignment)
        int guessesLeft = 7;

        //create an int[] with 26 0s and an uppercase alphabet
        //used to determine the whether the same input has already happened
        //IMPORTANT: int[] and alphabet have the same length (26)
        int[] guessed = new int[26];
        String uppercaseAlphabet = "";
        for(char c = 'A'; c < 'Z'; c++){
            uppercaseAlphabet += Character.toString(c);
        }

        while(guessesLeft > 0){
            String guess = scanner.nextLine();

            //player input is a single letter of type char
            char guessedLetter = ' ';

            if(validateInput(guess)){
                //since .nextline() returns a String, I have to convert it to an uppercase char with .charAt(0)
                guessedLetter = Character.toUpperCase(guess.charAt(0));
            }else {
                System.out.println("Wrong input.");
                continue;
            }

            //from here on, it is assumed that the input is correct: an uppercase, single letter

            //get the index of the guessed letter in the alphabet
            int posInAlphabet = getIndexOfCharacter(uppercaseAlphabet.toCharArray(), guessedLetter);

            if(guessed[posInAlphabet] == 1){
                System.out.println("You've already guessed the same thing.");
                continue;
            }else {
                //if it is 0, set it to 1 so the guessed letter is remembered for next time
                //meaning if there is a 1 and not a 0 at that position, that same letter had already been inputted by the player
                //the int[] guessed "remembers" which letters have already been guessed
                guessed[posInAlphabet] = 1;
            }

            //if it is a valid and new input, check in the actual word to see if it contains that letter
            for(int letter = 0; letter < word.length(); letter++){
                if(word.charAt(letter) == guessedLetter){ //the actual word contains the guessed letter at specific indices
                    char[] chars = guessedWord.toCharArray();

                    //replace "_" at index with the actual letter
                    chars[letter] = word.charAt(letter);

                    //converting to a string again and reassigning
                    guessedWord = String.valueOf(chars);
                }
            }

            //reduce amount of times player can guess
            guessesLeft -= 1;

            System.out.println(guessedWord);

            //winning case
            if(guessedWord.equals(word)){
                System.out.println("You guessed the word.");
                break;
            }

            //losing case
            if(guessesLeft == 0){
                System.out.println("You failed to guess the word after 7 tries.");
            }
        }
    }

    /**
     * Validates input of the player.
     *
     * @param input     player guess given as String
     * @return          true if the input is only 1 character long AND if it is alphabetic (single letters),
     *                  false otherwise
     */
    private static boolean validateInput(String input){
        if(input.length()==1){
            if(Character.isAlphabetic(input.charAt(0))){
                return true;
            }
        }

        return false;
    }

    /**
     * <pre>
     * Gets the index of a char inside a char[].
     * There's a generic <T> variant for this, but I don't know the syntax for that, nor do I know how to work with generics.
     * You could also do .contain() with ArrayLists, but I don't want to use ArrayLists
     * </pre>
     *
     * @param arr   char[] to be searched
     * @param elem  char you want to search inside char[]
     * @return      first index of elem inside char[], -1 if it doesn't exist
     */
    private static int getIndexOfCharacter(char[] arr, char elem){
        for(int i = 0; i < arr.length; i++){
            if(elem == arr[i]){
                return i;
            }
        }

        return -1;
    }
}
