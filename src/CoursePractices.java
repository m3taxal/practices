import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CoursePractices {
    public static void main(String[] args) {
        System.out.println(decimal_toBinary(23222));
    }

    private static void printFin(){
        System.out.println("Hallo Fin");
    }

    private static void assignIntAndPrint(){
        int n = 0;
        System.out.println(n);
    }

    private static float returnSquare(float num){
        return num*num;
    }

    private static float fahrenheitToCelsius(float fahrenheit){
        return 0.5556f * (fahrenheit-32);
    }

    private static void milliSecondsInTime(int milliseconds){
        int HOUR_TO_MILLISECONDS = 3600000;
        int MINUTE_TO_MILLISECONDS = 60000;
        int SECOND_TO_MILLISECONDS = 1000;

        float hours = milliseconds/HOUR_TO_MILLISECONDS;
        float minutes = (milliseconds%HOUR_TO_MILLISECONDS)/MINUTE_TO_MILLISECONDS;
        float seconds = (milliseconds%MINUTE_TO_MILLISECONDS)/SECOND_TO_MILLISECONDS;

        System.out.println(hours + " hour(s), " + minutes + " minute(s), " + seconds + " second(s)");
    }

    private static boolean isEven(float num){
        return num%2==0;
    }

    private static boolean between100And500(float num){
        return num>=100&&num<=500;
    }

    private static boolean divisibleByTwoOrThree(float num){
        return num%2==0&&num%3==0;
    }

    private static void gradeMark(int mark){
        switch (mark){
            case 1:
                System.out.println("Sehr gut");
                break;
            case 2:
                System.out.println("Gut");
                break;
            case 3:
                System.out.println("Befriedigend");
                break;
            case 4:
                System.out.println("Ausreichend");
                break;
            case 5:
                System.out.println("Mangelhaft");
                break;
            case 6:
                System.out.println("Ungenügend");
                break;
            default:
                System.out.println("Das ist keine Note");
        }
    }

    private static ArrayList sortThreeNumbers(ArrayList smallList){
        smallList = SortingAlgorithms.bubbleSort(smallList);
        Collections.reverse(smallList);
        return smallList;
    }

    private static String decimal_toBinary(int num){
        int[] bitSystem = new int[64];
        if(num != 0){
            for (int i = 0; i < bitSystem.length; i++){
                if(num/2==0){
                    bitSystem[i] = 1;
                    break;
                }

                //NO REMAINDER
                if(num%2==0){
                    bitSystem[i] = 0;
                }
                //WITH REMAINDER
                else {
                    bitSystem[i] = 1;
                }
                num = num/2;
            }
        }else {return "0";}

        for(int i = bitSystem.length-1; i > -1; i--){
            if(bitSystem[i]==1){
                int[] tmp = Arrays.copyOfRange(bitSystem, 0, i+1);
                String binaryNumber = "";
                for(int j = tmp.length-1; j > -1; j--){
                    binaryNumber += String.valueOf(tmp[j]);
                }
                return binaryNumber;
            }
        }
        return "something went wrong, lol";
    }
}
