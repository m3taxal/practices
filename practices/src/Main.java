import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SortingAlgorithms algorithms = new SortingAlgorithms();

        System.out.println("""
                Choose a sorting algorithm to sort your list of whole numbers.
                Press 1 to use BubbleSort
                Press 2 to use CountingSort (does not work for negative numbers, yet)
                """);

        Scanner reader = new Scanner(System.in);
        String userAnswer = reader.nextLine();

        if(userAnswer.equals("1")){
            System.out.println(algorithms.bubbleSort(algorithms.createUserInput()));
        } else if (userAnswer.equals("2")) {
            System.out.println(Arrays.toString(algorithms.countingSort(algorithms.createUserInput())));
        }else {
            System.out.println("Invalid input. Quitting program.");
            System.exit(0);
        }
    }
}