
public class ROT13 {

    /**
     * Encrypt messages with ROT13-Encryption.
     *
     * @param toEncrypt message to encrypt
     */
    public ROT13(String toEncrypt){
        char[] alphabetLowercase = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetUppercase = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

        StringBuilder newMessage = new StringBuilder();

        for(int letter = 0; letter < toEncrypt.length(); letter++){
            char encryptLetter = toEncrypt.charAt(letter);

            //spaces stay the same
            if(String.valueOf(encryptLetter).equals(" ")){
                newMessage.append(" ");
            }

            if(Character.isUpperCase(encryptLetter)){
                int found = new String(alphabetUppercase).indexOf(encryptLetter);
                newMessage.append(alphabetUppercase[found + 13]);
            }

            if(Character.isLowerCase(encryptLetter)) {
                int found = new String(alphabetLowercase).indexOf(encryptLetter);
                newMessage.append(alphabetLowercase[found + 13]);
            }
        }

        System.out.println(newMessage);
    }
}
