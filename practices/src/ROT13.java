import java.util.Arrays;

public class ROT13 {
    public static void encrypt(String toEncrypt){
        char[] alphabetLowercase = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetUppercase = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

        String newMessage = "";

        for(int letter = 0; letter < toEncrypt.length(); letter++){
            char encryptLetter = toEncrypt.charAt(letter);

            if(String.valueOf(encryptLetter).equals(" ")){
                newMessage += " ";
            }

            if(Character.isUpperCase(encryptLetter)){;
                int found = new String(alphabetUppercase).indexOf(encryptLetter);
                newMessage += alphabetUppercase[found+13];
            }

            if(Character.isLowerCase(encryptLetter)) {
                int found = new String(alphabetLowercase).indexOf(encryptLetter);
                newMessage += alphabetLowercase[found+13];
            }
        }

        System.out.println(newMessage);
    }

    public static void main(String[] args) {
        encrypt(args[0]);
    }
}
