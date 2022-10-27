import java.util.Random;

public class MedianOfThree {
    //---------------------------------------------------------------------------//
    public static int median(int a, int b, int c) {
        //put integers into an unsorted list
        int[] nums = {a, b, c};

        //Bubblesort to sort int[] nums
        for(int compare = 0; compare < nums.length; compare++){
            for(int with = compare+1; with < nums.length; with++){
                if(nums[compare] >= nums[with]){
                    //swap values by using a temporary swap value
                    int swap = nums[compare];
                    nums[compare] = nums[with];
                    nums[with] = swap;
                }
            }
        }

        //since the median in a three size list is in the middle, return index 1 ([0] [1] [2])
        return nums[1];
    }

    //---------------------------------------------------------------------------//
    public static int median2(int a, int b, int c) {
        /*
        basic methodology:
        - exclude one number (the smallest)
        - return the smaller number from the two numbers left
         */

        if(a <= b && a <= c){
            /*
            if a is the smallest number,
            return either b or c (depending on which is smaller)
             */
            if(b <= c){
                return b;
            }else {
                return c;
            }
        } else if (b <= a && b <= c) {
            /*
            if b is the smallest number,
            return either a or c (depending on which is smaller)
             */
            if(a <= c){
                return a;
            }else {
                return c;
            }
        } else {
            /*
            if c is the smallest number,
            return either a or b (depending on which is smaller)
             */
            if(a <= b){
                return a;
            }else {
                return b;
            }
        }
    }

    //---------------------------------------------------------------------------//
    public static void main(String[] args) {
        Random generator = new Random();

        int MAX = 101; //max is not inclusive in .next()
        int MIN = -100;

        /*
        TEST CASES
        - consists of two for loops (each one tests a method)
        - 3 random integers, ranging from -100 to 100
         */

        //text block used to express a multiline string
        System.out.println("""
                           NOW THE FIRST MEDIAN METHOD WILL BE USED
                           """);

        for(int i = 0; i < 100; i++){
            int a = generator.nextInt(MAX-MIN)+MIN;
            int b = generator.nextInt(MAX-MIN)+MIN;
            int c = generator.nextInt(MAX-MIN)+MIN;
            System.out.println("First median method used." + "\n" + "Try: " + (i+1));
            System.out.println(a + " " + b + " " + c);
            System.out.println(median(a, b, c) + "\n");
        }

        //text block used to express a multiline string
        System.out.println("""
                           NOW THE SECOND MEDIAN METHOD WILL BE USED
                           """);

        for(int i = 0; i < 100; i++){
            int a = generator.nextInt(MAX-MIN)+MIN;
            int b = generator.nextInt(MAX-MIN)+MIN;
            int c = generator.nextInt(MAX-MIN)+MIN;
            System.out.println("Second median method used." + "\n" + "Try: " + (i+1));
            System.out.println(a + " " + b + " " + c);
            System.out.println(median2(a, b, c) + "\n");
        }

        System.out.println("""
                           END OF TESTING
                           """);
    }
}
