import java.util.Scanner;

public class Hunt12 {
    public static void main(String[] args) {
        playGame();
    }

    /**
     * Main game method.
     */
    private static void playGame(){
        Scanner scanner = new Scanner(System.in);
        int MAX_SCORE = 100; //a constant showing what score the players have to reach for the game to end
        int[] scores = {0, 0, 0};  //p1, p2 and p3 respectively

        while(scores[0] < MAX_SCORE && scores[1] < MAX_SCORE && scores[2] < MAX_SCORE){
            int[] pScores = {0, 0, 0}; //temporary scores for each player

            //each player has to throw their dices
            for(int i = 0; i < scores.length; i++)
                pScores[i] = playGame_("This is Player " + (i+1) + "'s turn. ", scanner, i+1);

            int[] winners = decideWinner(pScores); //decides winner(s) in a "filled" 0-array
                                                   //if p1 and p2 won, then {1,1,0} (also explained at decideWinner method)

            System.out.print("\n"); //a clean console is a good console

            for(int i = 0; i < winners.length; i++){
                if(winners[i] == 1){ //if that player has won
                    System.out.println("Player " + (i+1) + " is a winner.");
                    scores[i] += pScores[i];
                }else { //if you didn't win... then, well, you lost. obviously.
                    if(scores[i]-pScores[i] < 0){ //I don't want negative scores. They sucked in testing.
                        scores[i] = 0;
                    }else {
                        scores[i] -= pScores[i];
                    }
                }
            }

            //print scores of all players, and then "draw a line" on the console (it's just much more visually appealing)
            System.out.println("\n"+"Player 1's score is: " + scores[0] + " | Player 2's score is: " + scores[1] + " | Player 3's score is: " + scores[2] + "\n" +
                               "----------------------------------------------------------------------------------------");
        }
    }

    /**
     * Helper method for playGame.
     *
     * @param playerMessage message showing whose turn it is
     * @param scanner       for input
     * @param currentPlayer numerical value for the current player (int)
     * @return
     */
    private static int playGame_(String playerMessage, Scanner scanner, int currentPlayer){
        System.out.print(playerMessage);
        int temporaryScore = 0;

        //throw 3 dices and add their scores
        for(int i = 0; i < 3; i++){
            temporaryScore += randomNumberRange(7, 1);
        }
        //if a player has a score less than 8, ask them if they want to throw another dice
        if(temporaryScore < 8){
            System.out.println("\n"+"Player " + currentPlayer + ", your score is " + temporaryScore + ", which is less than 8. Type 'yes' if you want to throw another dice and no if you don't.");

            //this while-loop validates the input
            //only allows "yes" and "no", everything else is considered a wrong input
            while (true){
                String pInput = scanner.nextLine();
                if(pInput.equals("yes")){
                    System.out.println("You threw another dice.");
                    temporaryScore += randomNumberRange(7, 1);
                    break;
                } else if (pInput.equals("no")) {
                    System.out.println("You decided not to throw another dice.");
                    break;
                }

                System.out.println("Wrong input.");
            }
        }

        //print what score the player has reached
        System.out.println("Player " + currentPlayer + " scored: " + temporaryScore);
        return temporaryScore;
    }

    /**
     * Decides the winner(s) based on their achieved scores.
     *
     * @param playerScores  achieved scores of all players as an int[]
     * @return              returns a 0-array with all winners
     *                      <p>{1,0,1} would mean that p1 and p3 won.</p>
     */
    private static int[] decideWinner(int[] playerScores){
        int[] differences = new int[playerScores.length];

        for(int i = 0; i < 3; i++){
            differences[i] = Math.abs(playerScores[i]-12); //get distance to 12
        }

        //numbers with the smallest distance to 12 are winning numbers
        //12 is overpowered.
        return getIndicesOf(differences, smallest(differences));
    }

    /**
     * Generate a random number in a range.
     *
     * @param max   maximum int, non-inclusive
     * @param min   minimum int, inclusive
     * @return      random int in specified range
     */
    public static int randomNumberRange(int max, int min){
        return (int)(Math.random()*(max-min)+min);
    }

    /**
     * Gets the smallest number in an int[].
     *
     * @param arr   int[] to be searched
     * @return      the smallest int in the given array
     */
    private static int smallest(int[] arr)
    {
        //"current" smallest number
        int minValue = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue){
                //if any numbers are smaller than the current smallest number, simply reassign minValue
                minValue = arr[i];
            }
        }

        return minValue;
    }

    /**
     * <pre>
     * Gets all the indices of an int in a given int[].
     *
     * Example:
     * If elem=3 and arr={3,2,3}, then this method returns {1,0,1}.
     * </pre>
     *
     * @param arr       int[] to be searched through
     * @param elem      int whose indices to get
     * @return          an int[] with all indices of elem.
     */
    public static int[] getIndicesOf(int[] arr, int elem){
        //this array stores all indices of elem inside arr (it's an int[] filled with zeros)
        int[] indices = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            if(elem == arr[i]){
                //if elem is found inside arr, then make a 1 out of the 0
                indices[i] = 1;
            }
        }

        return indices;
    }
}
