
public class HappyNumbers {

    private static int calcSquaredCS(int n){ //CS = CheckSum (Quersumme)
        if(n == 0){
            return 0;
        }
        /*
        This method is best explained through an example:

        calcSquared(n) = f(x) //for convenience

        f(53) = (53%10)^2 + f(53/10) //53%10 = 3, 3^2 = 9 (9 is the square of the first digit of 53, which is 3)
                            V        //53/10 = 5
                            V
                            f(5) = (5%10)^2 + f(5/10) //5%10 = 5, 5^2 = 25 (25 is the square of the second/last digit of 53, which is 5)
                                              V       //5/10 = 0
                                              V
                                              f(0) = 0 //because of the if-condition

                9         +        25       +        0 = 34
         */
        return (n%10)*(n%10) + calcSquaredCS(n/10);
    }

    public static boolean isHappy(int n){
        int newSum = calcSquaredCS(n); //get sum, calculated by the squares of each digit

        if(newSum == 1){ //if sum equals 1, it's a happy number
            return true;
        } else if (newSum == 4 | newSum == 0) { //if sum equals 4, it will enter an infinite cycle (see Wikipedia)
                                                //similarly, if sum equals 0 it'll stay a 0
            return false;
        }

        //continue with calculated sum
        return isHappy(newSum);
    }

    public static int nextHappyNumber(int n){
        //check if adjacent number is happy or not
        if(isHappy(n)){
            return n;
        }

        //go to next adjacent number
        return nextHappyNumber(n+1);
    }

    public static void main(String[] args) {
        /*
        For reference, here are some happy numbers: (pulled from https://oeis.org/A007770/list)
            [1,7,10,13,19,23,28,31,32,44,49,68,70,79,82,86,91,
            94,97,100,103,109,129,130,133,139,167,176,188,190,
            192,193,203,208,219,226,230,236,239,262,263,280,
            291,293,301,302,310,313,319,320,326,329,331,338]
        */

        int[] testCases = {-1, 2, 149, 32, 98, 0, 2, 43, 332, 21, 4, 10, 193, 291, 338, 331};

        //testing isHappy()
        for(int i = 0; i < testCases.length; i++){
            if(testCases[i] < 0){
                System.out.println("Negative numbers are not valid.");
                continue;
            }

            if(isHappy(testCases[i])){
                System.out.println(testCases[i] + " is a happy number.");
            }else {
                System.out.println(testCases[i] + " is not a happy number.");
            }
        }

        System.out.print("\n");

        //testing nextHappyNumber()
        for(int i = 0; i < testCases.length; i++){
            if(testCases[i] < 0){
                System.out.println("Negative numbers are not valid.");
                continue;
            }

            System.out.println("The nearest happy number equal than or greater to " + testCases[i] + " is " + nextHappyNumber(testCases[i]) + ".");
        }
    }
}
