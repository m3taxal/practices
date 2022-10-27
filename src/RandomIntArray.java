import java.sql.Array;
import java.util.Arrays;

public class RandomIntArray {
    public static int[] createRandom(int n){
        //fail case if given a negative length
        if(n < 0){
            return null;
        }

        //new array of length n
        int[] randomArray = new int[n];

        //fill randomArray with random numbers
        for(int num = 0; num < randomArray.length; num++){
            /*
            Why "95*" and "+5"?
            - z = (int)(max*Math.random()); creates a number from 0 <= z < max
            - I want to create a number from 5 to 99 (both inclusive)
            - I don't want 0, 1, 2, 3 or 4, so I add 5 (min) to the generated number
            - however, if I add 5, I might go over the boundary (>100)
            - that is why I need to reduce 99 by 5, but also add 1 because Math.random() is exclusive, e.g. 99-5+1 = 95
             */
            randomArray[num] = (int)(95*Math.random())+5;
        }

        return randomArray;
    }

    public static String toString(int[] a){
        //fail case if given array doesn't have any elements
        if(a.length == 0 || a == null){
            return null;
        }

        /*
        Literally just a copy of Array.toString().
        Not much to say here.
         */

        String strinfOfArray = "";
        strinfOfArray += "[" + a[0];

        for(int i = 1; i < a.length; i++){
            strinfOfArray += ", " + a[i];
        }

        strinfOfArray += "]";
        return strinfOfArray;
    }

    public static int posMin(int[] a){
        //fail case if given array doesn't have any elements
        if(a.length == 0 || a == null){
            return -1;
        }

        int min = 0; //position of our current "minimum"

        for(int i = 1; i < a.length; i++){
            if(a[i] < a[min]){
                min = i; //if smaller than incoming number, reassign
            }
        }

        //now we have the smallest number
        return min;
    }

    public static void swap(int[] a){
        //fail case if given array doesn't have any elements
        if(a.length == 0 || a == null){
            return;
        }

        //swap by using a temporary variable, and then reassigning
        int swap = a[0];
        a[0] = a[a.length-1];
        a[a.length-1] = swap;
    }

    public static void main(String[] args) {
        /*
        //testing createRandom()
        for(int i = 0; i < 100; i++){
            int[] tmp = createRandom(12);
            System.out.println(Arrays.toString(tmp));
        }*/

        /*
        //testing my own toString() method
        int[] tmp = {1, 2, 3, 4};
        System.out.println(toString(tmp));
        System.out.println(Arrays.toString(tmp));
        */

        /*
        //testing posMin()
        for(int i = 0; i < 100; i++){
            int[] tmp = createRandom(5);

            System.out.println(Arrays.toString(tmp));
            System.out.println(posMin(tmp));
            System.out.println("\n");
        }
        */

        /*
        //testing swap()
        for(int i = 0; i < 100; i++){
            int[] tmp = createRandom(5);

            System.out.println(Arrays.toString(tmp));
            swap(tmp);
            System.out.println(Arrays.toString(tmp));
            System.out.println("\n");
        }
        */
    }
}
