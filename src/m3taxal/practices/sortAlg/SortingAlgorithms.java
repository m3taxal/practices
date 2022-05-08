package com.practices.sortAlg;

import java.util.*;

public class SortingAlgorithms {
    public static void main(String[] args) {
        System.out.println("""
                Choose a sorting algorithm to sort your list of whole numbers.
                Press 1 to use BubbleSort
                Press 2 to use CountingSort (does not work for negative numbers, yet)
                """);

        Scanner reader = new Scanner(System.in);
        String userAnswer = reader.nextLine();

        if(userAnswer.equals("1")){
            System.out.println(bubbleSort(createUserInput()));
        } else if (userAnswer.equals("2")) {
            System.out.println(Arrays.toString(countingSort(createUserInput())));
        }else {
            System.out.println("Invalid input. Quitting program.");
            System.exit(0);
        }
    }

    /**
     * Sort a list using BubbleSort.
     * @param sortList  list that is to be sorted
     * @return          the sorted list
     */
    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> sortList){
        ArrayList<Integer> newSortedList = new ArrayList<>();
        int constSize = sortList.size(); //size of sortList changes during sorting

        for(int repeat = 0; repeat < constSize; repeat++){
            for(int i = 0; i < sortList.size(); i++){
                int currentElement = sortList.get(i);

                try{
                    int nextElement = sortList.get(i+1);
                    if(currentElement > nextElement){

                        //change position of current number and next number
                        sortList.set(i+1, currentElement);
                        sortList.set(i, nextElement);
                    }
                }
                catch (IndexOutOfBoundsException exception){

                    //when end of sortList is reached, add current element to newSortedList
                    newSortedList.add(sortList.get(i));

                    //remove last element (the biggest element) of sortList to continue sorting (changing size of sortList)
                    sortList.remove(i);
                }
            }
        }

        Collections.reverse(newSortedList);
        return newSortedList;
    }

    /**
     * Sort a list using CountingSort.
     * @param sortList list that is to be sorted
     * @return         sorted list (as Array)
     */
    public static int[] countingSort(ArrayList<Integer> sortList){
        int[] countArray = new int[Collections.max(sortList)];

        //create countArray, size equals the biggest element (that is why countingSort is not suitable for lists with large numbers)
        for (Integer integer : sortList) {
            countArray[integer - 1] += 1;
        }

        //count instances of integers in sortList, add to countArray
        for(int i = 1; i < countArray.length; i++){
            countArray[i] += countArray[i-1];
        }

        //create sorted Array that will be returned
        int[] resultArray = new int[sortList.size()];

        //elements of sortList equal indices in countArray -> ultimately sorted into resultArray
        for(int i = sortList.size()-1; !(i < 0); i--){
            resultArray[countArray[sortList.get(i)-1]-1] = sortList.get(i);
            countArray[sortList.get(i)-1] -= 1;
        }

        return resultArray;
    }

    /**
     * Create a user-filled list with whole numbers.
     *
     * @return  the list filled with numbers
     */
    public static ArrayList<Integer> createUserInput(){
        ArrayList<Integer> userList = new ArrayList<>();
        Scanner reader = new Scanner(System.in);

        System.out.println("""
                Please type whole numbers, you can continue typing numbers to fill your list.\s
                If you type anything else other than a whole number, your input will end
                """);

        while (true){
            try{
                int userNumber = reader.nextInt();
                userList.add(userNumber);
            }
            catch(InputMismatchException exception) {
                break;
            }
        }

        return userList;
    }
}