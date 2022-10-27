import java.util.Scanner;

public class ConnectFour {
    static char[][] board = new char[7][6]; //7 rows, 6 columns
    static char EMPTY_SYMBOL = '.'; //for fields that are empty

    public static void main(String[] args) {
        playGame();
    }

    /**
     * Main game method.
     */
    private static void playGame(){
        Scanner scanner = new Scanner(System.in);

        initBoard();
        printBoard();

        char[] PLAYER_SYMBOLS = {'x', 'o'};
        boolean gameOver = false; //is set to true once a winner as been found

        while(!gameOver){
            for(int currentPlayer = 0; currentPlayer < PLAYER_SYMBOLS.length; currentPlayer++){
                System.out.println("Player " + (currentPlayer+1) + ", please choose a column.");
                int chosenColumn;
                while (true){
                    String input = scanner.nextLine(); //the only inputs allowed are single numbers, ranging from 1 to 6
                    if(!validateInput(input)){
                        System.out.println("Wrong input.");
                        continue;
                    }

                    chosenColumn = Integer.parseInt(input)-1;
                    if(board[0][chosenColumn] != EMPTY_SYMBOL){ //in connect4, you can't make a move when the top row is filled
                        System.out.println("Invalid move.");
                        continue;
                    }
                    break;
                }
                //execute player input method (gameInput()) and get position of input at the same time
                int[] cellPos = gameInput(chosenColumn, PLAYER_SYMBOLS[currentPlayer]);
                printBoard();
                if(checkWinner(cellPos, PLAYER_SYMBOLS[currentPlayer])){ //if last input was a winning move
                    System.out.println("Game has ended. Player " + (currentPlayer+1) + " has won.");
                    gameOver = true; //end case
                    break;
                }
            }
        }
    }

    /**
     * Initialize an empty game board.
     */
    private static void initBoard(){
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[row].length; column++){
                board[row][column] = EMPTY_SYMBOL; //a single dot looks the nicest
            }
        }
    }

    /**
     * Prints the current game board.
     */
    private static void printBoard(){
        System.out.println("  1 2 3 4 5 6 "); //gives the user an easier time when they have to choose a columns for their input

        //simply print the entire board with square brackets
        for (char[] chars : board) {
            System.out.print("[ ");
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println("]");
        }
    }

    /**
     * Decides if the last input was a winning move or not.
     *
     * @param pos       position of last player input
     * @param pSymbol   symbol of the current player's turn
     * @return          true if there has been a winner, false if not
     */
    private static boolean checkWinner(int[] pos, char pSymbol){
        return checkHorizontal(pos, pSymbol) >= 4 || checkVertical(pos, pSymbol) >= 4 || checkDiagonal(pos, pSymbol) >= 4;
    }

    /*
    all three checkDirectional methods work the same:
    - they look into the right direction of the player input
      and stop immediately once they see a different player symbol or receive an error (OutOfBounds)
    - then they look into the left direction of the last player input, and the same happens
    - each time the field contains the correct player symbol, the counter is increased
    - counter is returned as int (4 has to be reached... because the game is called connect"4")

    ...is there a more elegant way of doing this?
     */
    private static int checkHorizontal(int[] pos, char pSymbol){
        int counter = 1;
        for(int i = 1; i < 4; i++){
            try{
                if(board[pos[0]][pos[1]+i] == pSymbol){
                    counter += 1;
                }else {
                    break;
                }
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }

        for(int i = 1; i < 4; i++){
            try{
                if(board[pos[0]][pos[1]-i] == pSymbol){
                    counter += 1;
                }else {
                    break;
                }
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }
        return counter;
    }

    private static int checkVertical(int[] pos, char pSymbol){
        int counter = 1;
        for(int i = 1; i < 4; i++){
            try{
                if(board[pos[0]+i][pos[1]] == pSymbol){
                    counter += 1;
                }else {
                    break;
                }
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }

        for(int i = 1; i < 4; i++){
            try{
                if(board[pos[0]-i][pos[1]] == pSymbol){
                    counter += 1;
                }else {
                    break;
                }
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }
        return counter;
    }

    private static int checkDiagonal(int[] pos, char pSymbol){
        int counter = 1;
        for(int i = 1; i < 4; i++){
            try{
                if(board[pos[0]+i][pos[1]+i] == pSymbol){
                    counter += 1;
                }else {
                    break;
                }
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }

        for(int i = 1; i < 4; i++){
            try{
                if(board[pos[0]+i][pos[1]-i] == pSymbol){
                    counter += 1;
                }else {
                    break;
                }
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }
        return counter;
    }

    /**
     * Handles the player input.
     *
     * @param chosenColumn  column player has chosen (1-6)
     * @param symbol        symbol of the player who is currently making their move
     * @return              position of the final player input as int[]
     */
    private static int[] gameInput(int chosenColumn, char symbol){ //basic input method for connect4
        for(int row = board.length-1; row >= 0; row--){
            //if this loop is at the last row and the chosen column is empty
            if(row == board.length-1){
                if(board[row][chosenColumn] == EMPTY_SYMBOL){
                    board[row][chosenColumn] = symbol;
                    return new int[]{row, chosenColumn};
                }
            }
            /*
            2 conditions have to be fulfilled for the player input to be valid (if it is not at the last row):
            - there has to be an input the row below the chosen column
            - the chosen position ([row][column]) has to be empty
             */
            else {
                if(board[row+1][chosenColumn] != EMPTY_SYMBOL && board[row][chosenColumn]==EMPTY_SYMBOL){
                    board[row][chosenColumn] = symbol;
                    return new int[]{row, chosenColumn};
                }
            }
        }

        //hopefully it'll never come to this...
        return null;
    }

    /**
     * Checks if a given input is valid or not
     *
     * @param input     input to be checked
     * @return          true if it is valid, false if it isn't.
     */
    private static boolean validateInput(String input){
        String[] allowedInputs = new String[board[0].length]; //there are only 6 columns, so the player can only choose from 1 to 6
        for (int i = 0; i < allowedInputs.length; i++) //generate a string[] with numbers 1 to 6
            allowedInputs[i] = String.valueOf(i+1);

        return contains(allowedInputs, input);
    }

    /**
     * Checks if a string is in a string array.
     *
     * @param arr   array to be searched through
     * @param elem  element that may or may not be contained in arr
     * @return      true if arr contains elem, false if not.
     */
    private static boolean contains(String[] arr, String elem){
        for (String s : arr) {
            if (s.equals(elem)) {
                return true;
            }
        }
        return false;
    }
}
