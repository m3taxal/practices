public class TikTakToe {
    public static void main(String[] args) {
        char[][] board = {
                {'x', ' ', 'o'},
                {'x', ' ', 'x'},
                {'x', ' ', 'o'},
        };

        System.out.println(checkBoard(board));
    }

    private static String checkBoard(char[][] board){
        /*
        "wins" zählt wie oft gewonnen wurde.
        Hat ein Spieler (mehrmals)/haben beide Spieler (mehrmals gewonnen), ist das Feld invalide.
        Bei Tic-Tac-Toe dürfen im Feld nur !einmal! 3 gleiche Charaktere hintereinanderstehen,
        deshalb darf auch kein Spieler mehrmals gewonnen haben.
        Z.b wird
                {'x', 'x', 'x'}
                {'x', 'o', 'x'} -> 2 Siege für Spieler x
                {'x', ' ', 'x'}
        genauso invalide angesehen wie
                {'x', 'x', 'o'}
                {'x', 'o', 'o'} -> 1 Sieg für Spieler x, 1 Sieg für Spieler o
                {'x', ' ', 'o'}
        weil in beiden Fällen mehrere Siege gezählt wurden.
         */
        int wins = 0;

        //Merkt sich, welcher Spieler gewonnen hat anhand des Symbols. Entweder 'x' oder 'o'
        String winMessage = "";

        /*
        Das leere Feld soll nicht auch als Spieler angesehen werden,
        deshalb ist diese Variable als Extra-Kondition mit eingebunden.
         */
        char LEERES_FELD = ' ';

        //Checkt zeilenweise.
        for(int i = 0; i < 3; i++){
            if(board[i][0] != LEERES_FELD && (board[i][0] == board[i][1]) && (board[i][1]== board[i][2])){
                wins += 1;

                //winMessage merkt sich durch boards[i][0], welcher Spieler gewonnen hat.
                winMessage = "Spieler: " + board[i][0] + " hat gewonnen";
            }
        }

        //Checkt spaltenweise.
        for(int i = 0; i < 3; i++){
            if(board[0][i] != LEERES_FELD && (board[0][i] == board[1][i]) && (board[1][i]== board[2][i])){
                wins += 1;

                //winMessage merkt sich durch boards[0][i], welcher Spieler gewonnen hat.
                winMessage = "Spieler: " + board[0][i] + " hat gewonnen";
            }
        }

        //Checks diagonal von oben anfangend.
        if(board[0][0] != LEERES_FELD && (board[0][0] == board[1][1]) &&(board[1][1] == board[2][2])) {
            wins += 1;

            //winMessage merkt sich durch boards[0][0], welcher Spieler gewonnen hat.
            winMessage = "Spieler: " + board[0][0] + " hat gewonnen";
        }

        //Checkt diagonal von unten anfangend.
        if(board[2][0] != LEERES_FELD && (board[2][0] == board[1][1])&&(board[1][1] == board[0][2])) {
            wins += 1;

            //winMessage merkt sich durch boards[2][0], welcher Spieler gewonnen hat.
            winMessage = "Spieler: " + board[2][0] + " hat gewonnen";
        }

        if(wins > 1){ //Wenn mehrere Siege gezählt wurden.
            return "Invalides Feld";
        }
        else if (wins == 1) {
            return winMessage; /*
                                Wenn es genau nur einen Sieg gab. Der einzig valide Fall.
                                "winMessage" hat sich durch Zuweisung gemerkt, welcher Spieler gewonnen hat.
                                */
        }
        else { //Wenn es keine Siege gab.
            return "Kein Spieler hat bisher gewonnen";
        }
    }
}
