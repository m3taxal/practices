
public class Cowsay {

    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }
    public static void sayCow(String message){
        String ceiling = repeat(message.length()+2, "_");
        String floor = repeat(message.length()+2, "-");
        String moo = String.format("                                                    %s\n" +
                                   "                                                    <%s>\n" +
                                   "                                                    %s\n" +
                                   "                                                    /\n" +
                                   "                                                   /\n" +
                                   "                               \\|/          (__)\n" +
                                   "                                    `\\------(oo)\n" +
                                   "                                     ||     (__)\n" +
                                   "                                     ||w--||     \\|/\n" +
                                   "                                \\|/\n", ceiling, message, floor);
        System.out.println(moo);
    }

    public static void main(String[] args) {
        sayCow(args[0]);
    }
}
