import java.util.Arrays;
import java.util.Random;

public class GummyBears {
    static int RED_GB = 31;
    static int BLUE_GB = 67;

    static int[] jar = new int[RED_GB+BLUE_GB]; //amount of gummy bears inside jars equals total amount

    public static void main(String[] args){
        fillJar();
        stuffYourself();
        if(jar[0] == 1){
            System.out.println("There are an even number of blue gummy bears inside the jar.");
        }else {
            System.out.println("There are an odd number of blue gummy bears inside the jar.");
        }
    }

    private static void stuffYourself(){
        while(jar.length > 1){
            //draw gummy bears "from jar"
            int firstGB = drawGB();
            int secondGB = drawGB();

            //if both gummy bears are of the same color, eat both and add a red one to the jar
            if(firstGB == secondGB){
                jar = addToArray(jar, 1);
            }
            //if both gummy bears are not of the same color, eat red and keep blue
            else {
                jar = addToArray(jar , 0);
            }
        }
    }

    private static void fillJar(){
        for(int i = 0; i < RED_GB; i++){
            jar[i] = 1; //1 for red gummy bears
        }
    }

    private static int drawGB(){
        //if only one gummy bear is left inside the jar
        if(jar.length == 1){
            int tmp = jar[0];
            jar = removeAtIndex(jar, 0);
            return tmp;
        }

        Random generator = new Random();
        int nextGB = generator.nextInt(jar.length-1)+1; //draw a random gummy bear in form of index
        int GB_TYPE = jar[nextGB]; //decide whether that gummy bear is red or blue
        jar = removeAtIndex(jar, nextGB);
        return GB_TYPE;
    }

    private static int[] addToArray(int[] arr, int toAdd){
        if(arr == null){
            //in case something is wrong with either the index or the array
            return arr;
        }

        int[] copiedArr = new int[arr.length+1]; //copy array

        copiedArr[0] = toAdd; //set the newest element as first to add

        //copy elements from original array
        for(int i = 0; i < arr.length; i++){
            copiedArr[i+1] = arr[i];
        }

        return copiedArr;
    }

    private static int[] removeAtIndex(int[] arr, int index){
        if(arr == null || index < 0 || index >= arr.length){
            //in case something is wrong with either the index or the array
            return arr;
        }

        int[] copiedArr = new int[arr.length-1]; //copy array

        //copy elements from original array into new array
        for(int i = 0, k = 0; i < arr.length; i++){
            //if i equals index to be removed
            if(i == index){
                continue;
            }

            copiedArr[k] = arr[i]; //if it doesn't equal index to be removed
            k += 1;
        }

        return copiedArr;
    }
}
