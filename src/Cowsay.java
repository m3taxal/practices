
public class Cowsay {

    /**
     * Repeat a string a specified amount of times.
     *
     * @param count how many times to repeat
     * @param with  string to repeat
     * @return      the repeated string as one new string
     */
    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    /**
     * Cowsay method
     *
     * @param message   cow message. MOO
     */
    public static void Cowsay(String message){
        String ceiling = repeat(message.length()+2, "_");
        String floor = repeat(message.length()+2, "-");

        //ASCII cow magic...
        String moo = String.format("                                                    %s\n" +
                                   "                                                    <%s>\n" +
                                   "                                                    %s\n" +
                                   "                                                    /\n" +
                                   "                                                   /\n" +
                                   "                               \\|/          (__)\n" +
                                   "                                    `\\------(oo)\n" +
                                   "                                     ||     (__)\n" +   //<- for some reason, small indent is needed here
                                   "                                     ||w--||     \\|/\n" +
                                   "                                \\|/\n", ceiling, message, floor);
        System.out.println(moo);
    }

    public static void main(String[] args) {
        Cowsay("asd");
    }
}
