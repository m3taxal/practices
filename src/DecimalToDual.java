public class DecimalToDual {
    //---------------------------------------------------------------------------//
    public static String transformDual(int dec) {
        if(dec == 0){
            return "0";
        }

        //builds the dual number
        String buildDual = "";

        while (dec != 0){

            /*
            Example: 53
            53 % 2 = 1 (26*2 is left over)
            26 % 2 = 0 (13*2 is left over)
            13 % 2 = 1 (6*2 is left over)
            6 % 2 = 0 (3*2 is left over)
            3 % 2 = 1 (1*2 is left over)

            And because 1/2 == 0 (integer division), the loop stops.
             */
            if(dec%2 == 0){
                buildDual += "0";
            }else {
                buildDual += "1";
            }

            dec /= 2;
        }

        //to get the actual dual number, you have to reverse the string
        //to reverse a string, start at the last position and add each element according to decreasing index
        String reversedDual = "";
        for(int letter = buildDual.length()-1; letter > -1; letter--){
            reversedDual += buildDual.charAt(letter);
        }

        return reversedDual;
    }

    //---------------------------------------------------------------------------//
    public static void main(String[] args) {
        int[] testCases = {12, 12, 1232, 2361, 6572, 4444, 0, 1, 236758};
        /*
        Check if test cases are correct:
        12 - 1100
        12 - 1100
        1232 - 10011010000
        2361 - 100100111001
        6572 - 1100110101100
        4444 - 1000101011100
        0 - 0
        1 - 1
        236758 - 111001110011010110
         */

        for(int i = 0; i < testCases.length; i++){
            System.out.println(testCases[i] + ": " + transformDual(testCases[i]));
        }
    }
}
