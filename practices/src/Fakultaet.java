public class Fakultaet {
    /**
     * Berechnet Fakultaeten von Zahlen.
     * BEACHTE: !31 ist Maximum (danach loopt 32bit Integer)
     *
     * @param fakSum    immer 1 als Parameter einsetzen
     * @param fakNum    Zahl, von der man die Fakultaet herausfinden will
     * @return          Fakultaet von fakNum
     */
    public int fakultaetRechner(int fakSum, int fakNum){
        if(fakSum == 1){
            if(fakNum == 1){
                return 1;
            }

            if(fakNum == 0){
                return 0;
            }
        }

        if(fakNum == 0){
            return fakSum;
        }
        else{
            fakSum *= fakNum;
        }

        return fakultaetRechner(fakSum, fakNum-1);
    }
}
