import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public void useSortAlgo(){
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


    public static void main(String[] args) {

    }
}