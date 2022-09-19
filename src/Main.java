import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * Create a list of numbers to sort with a specified sorting algorithm.
     * Current algorithms are:
     *  BubbleSort,
     *  CountingSort,
     *  QuickSort
     */
    public static void useSortAlgo(){
        SortingAlgorithms algorithms = new SortingAlgorithms();

        System.out.println("""
                Choose a sorting algorithm to sort your list of whole numbers.
                Press 1 to use BubbleSort
                Press 2 to use CountingSort (does not work for negative numbers, yet)
                Press 3 to use Quicksort
                """);

        Scanner reader = new Scanner(System.in);
        String userAnswer = reader.nextLine();

        ArrayList<Integer> userList = algorithms.createUserInput();
        Integer[] newSortList = userList.toArray(new Integer[0]);

        switch (userAnswer) {
            case "1" -> System.out.println(algorithms.bubbleSort(userList));
            case "2" -> System.out.println(Arrays.toString(algorithms.countingSort(userList)));
            case "3" -> System.out.println(Arrays.toString(algorithms.quickSort(newSortList, 0, userList.size()-1)));
            default -> {
                System.out.println("Invalid input. Quitting program.");
                System.exit(0);
            }
        }
    }
    final int AGE = 32;
    public enum Color {
        // constructor parameters are defined as
        // the constants are enumerated
        RED("#FF0000"),
        GREEN("#00FF00"),
        BLUE("#0000FF");

        private String code;        // object reference variable

        private Color(String code) { // constructor
            this.code = code;
        }


        public String getCode() {
            return this.code;
        }
    }

    public static void main(String[] args) {
        System.out.println(Color.GREEN.getCode());
    }
}