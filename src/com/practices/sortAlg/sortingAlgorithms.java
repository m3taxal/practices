package com.practices.sortAlg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class sortingAlgorithms {
    public static void main(String[] args) {
        System.out.println(bubbleSort(createUserInput()));
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

        return newSortedList;
    }

    /**
     * Create a user-filled list with whole numbers.
     *
     * @return  the list filled with numbers
     */
    public static ArrayList<Integer> createUserInput(){
        ArrayList<Integer> userList = new ArrayList<>();
        Scanner reader = new Scanner(System.in);

        System.out.println("Please type whole numbers, you can continue typing numbers to fill your list. " + "\n" +
                           "If you type anything else other than a whole number, your input will end");

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
