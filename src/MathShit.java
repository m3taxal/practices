import java.util.Arrays;

public class MathShit {

    public static void main(String[] args) {
        String[] tmp = {"1", "1", "3", "1", "2", "3", "a", "5", "ba", "2", "ab"};
        //powerset(tmp);
        System.out.println(isPrime(23122));
        //System.out.println(Arrays.toString(removeDuplicates(tmp)));
    }
    public static float varianz(float mittelwert, int[] zahlen){
        float summe = 0; //in dieser Variable wird der Wert für die Varianz gespeichert

        for(int zahl = 0; zahl < zahlen.length; zahl++){
            //nach der Formel: (x̄-i)^2
            summe += (mittelwert-zahlen[zahl])*(mittelwert-zahlen[zahl]);
        }

        summe /= zahlen.length-1; //nach der Formel: 1/(n-1)
        return summe;
    }

    public static double standardAbweichung(float varianz){
        return Math.sqrt(varianz); //Wurzel aus der Varianz
    }

    public static boolean isPrime(int n){
        if(n == 2){
            return true;
        }

        for(int i = 2; i < n; i++){
            if(n%i == 0){
                return false;
            }
        }

        return true;
    }

    private static int[] addToBinary(int[] binary){
        binary[0] += 1;

        if(binary[0] == 2){
            for(int i = 0; i < binary.length; i++){
                if(binary[i] == 2){
                    binary[i] = 0;
                    if(i != binary.length-1){
                        binary[i+1] += 1;
                    }
                }
            }
        }

        return binary;
    }

    private static boolean isAllElem(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != elem) {
                return false;
            }
        }
        return true;
    }

    private static int countElem(int[] arr, int elem){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                count += 1;
            }
        }

        return count;
    }

    private static String[] addElem(String[] arr, String elem){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null){
                arr[i] = elem;
                break;
            }
        }

        return arr;
    }

    private static boolean isDuplicate(String[] arr, String elem){
        int amount = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == elem){
                amount += 1;
                if(amount == 2){
                    return true;
                }
            }
        }

        return false;
    }

    private static String[] removeDuplicates(String[] arr){
        int[] newArr = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            if(!isDuplicate(arr, arr[i])){
                newArr[i] = 1;
            }
        }

        String[] superNewArr = new String[countElem(newArr, 1)];
        for(int j = 0; j < newArr.length; j++){
            if(newArr[j] == 1){
                superNewArr = addElem(superNewArr, arr[j]);
            }
        }

        return superNewArr;
    }

    private static void powerset(String[] menge){
        menge = removeDuplicates(menge);
        int[] newSet = new int[menge.length];

        while (!isAllElem(newSet, 1)){
            if(isAllElem(newSet, 0)){
                System.out.println("[]");
            }

            newSet = addToBinary(newSet);

            String[] tmpSet = new String[countElem(newSet, 1)];

            for(int counter = 0; counter < newSet.length; counter++){
                if(newSet[counter] == 1){
                    tmpSet = addElem(tmpSet, menge[counter]);
                    //System.out.print(menge[counter]);
                    //System.out.print(",");
                }
            }

            System.out.print(Arrays.toString(tmpSet));

            System.out.print("\n");
        }
    }
}
