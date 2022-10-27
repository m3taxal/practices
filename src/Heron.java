
public class Heron {
    public static void main(String[] args) {
        System.out.println(kubik(5));
    }

    /**
     * Returns the absolute value of a given number.
     * @param num   double which can be either negative or positive
     * @return      absolute value of num
     */
    public static double absolute(double num){
        if(num < 0){
            return -num;
        }

        return num;
    }

    public static double algorithm(double area){
        //Erschaffe ein Quadrat mit Breite 1 und Länge gleich dem Flächeninhalt
        double width = 1;
        double length = area;

        double ERROR_THRESHOLD = 0.00000001f; //Fehlerschranke

        while (absolute(width-length) >= ERROR_THRESHOLD){
            double newWidth = (width+length)/2; //nach der Formel: a' = (a+b)/2
            double newLength = area/newWidth; //nach der Formel: b' = A/a'

            //neue Zuweisungen der Seitenlängen
            width = newWidth;
            length = newLength;
        }

        //man könnte auch die Länge nehmen; ist egal da beide Seitenlängen (hoffentlich) identisch sind
        return width;
    }

    public static float kubik(float volume){
        //Erschaffe einen Quader mit Länge = 1, Breite = 1 und Höhe = Volumen
        float width = 1;
        float length = 1;
        float height = volume;

        float ERROR_THRESHOLD = 0.00001f; //Fehlerschranke

        while (absolute(width-height) >= ERROR_THRESHOLD && absolute(length-height) >= ERROR_THRESHOLD){
            float newWidth = (width+length+height)/3; //nach der Formel: (a+b+c)/3
            float newLength = (width+length+height)/3; //nach der Formel: (a+b+c)/3
            float newHeight = volume/(newWidth*newLength); //nach der Formel: Volumen/(a'*b')

            //Neuzuweisungen
            width = newWidth;
            length = newLength;
            height = newHeight;
        }

        //egal welche Kante, weil alle ungefähr gleich lang sein sollten
        return width;
    }
}
