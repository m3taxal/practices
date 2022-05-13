
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class gameController implements Initializable {

    @FXML
    private TextArea gameDialogue;

    @FXML
    private TextField playerInput;

    private int letter = 0;

    private boolean canWrite = true;

    //all the game dialogue, stored in dialogue.txt
    private final ArrayList<String> allLines = new ArrayList<>();

    /**
     * Scrolls text in the gameDialogue window. Also determines
     * whether game ends or continues.
     *
     * @param line      line that is to be scrolled
     * @param endGame   determines whether game ends. If true,
     *                  the game will continue. If false, the scrolling
     *                  will be disabled and the game ends.
     *                  Ending does not mean terminating the program in this case.
     */
    public void scrollText(String line, boolean endGame){
        //to separate different lines in gameDialogue window
        gameDialogue.appendText("\n");

        this.letter = 0;

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.03), e -> {
            this.gameDialogue.appendText(String.valueOf(line.charAt(this.letter)));
            this.letter++;
        }));

        //play for amount of characters in line, appending each letter
        timeline.setCycleCount(line.length());

        timeline.play();
        timeline.setOnFinished(actionEvent -> canWrite=endGame);
    }

    //store all valid lines the player has written
    private final ArrayList<String> currentLines = new ArrayList<>();

    /**
     * Adds valid player lines to gameDialogue window.
     */
    public void addToGameDialogue(){
        if(canWrite){
            String playerLine = playerInput.getText();
            int rememberPlayerLine = 0;

            for(int i = 0; i < allLines.size(); i++){
                if(playerLine.equalsIgnoreCase(allLines.get(i))){
                    if(!currentLines.contains(allLines.get(i))){ //only continue if dialogue.txt actually contains playerLine

                        //get last two strings (actions player can take) of gameDialogue
                        String[] gameLines = gameDialogue.getText().split("\n");
                        String lastLine = gameLines[gameLines.length-1];
                        String secondToLastLine = gameLines[gameLines.length-2];

                        if(playerLine.equalsIgnoreCase(lastLine) || playerLine.equalsIgnoreCase(secondToLastLine)){ //if playerLine actually equals either one of the last two actions
                            currentLines.add(allLines.get(i));
                            rememberPlayerLine = i;
                            canWrite = false;
                            gameDialogue.appendText("\n" + ">" + allLines.get(i));
                        }
                    }
                    break;
                }
            }

            if(!canWrite){
                switch (rememberPlayerLine) { //handles line-skipping and game-flow (e.g. what line to go after playerLine...)
                    case 2 -> scrollText(allLines.get(4), false);
                    case 3 ->
                            scrollText(allLines.get(5) + "\n" + allLines.get(6) + "\n" + allLines.get(7) + "\n" + allLines.get(8), true);
                    case 7 -> scrollText(allLines.get(9), false);
                    case 8 -> scrollText(allLines.get(10) + "\n" + allLines.get(11), false);
                }
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameDialogue.setEditable(false);
        gameDialogue.setWrapText(true);

        try{
            File dialogueLines = new File("src/dialogue.txt");
            Scanner myReader = new Scanner(dialogueLines);
            while(myReader.hasNextLine()){
                allLines.add(myReader.nextLine());
            }
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("ERROR");
            e.printStackTrace();
        }

        //begin with starting dialogue (nothing entered by player yet)
        canWrite = false;
        scrollText("""
                You are captured in an underground cell inside a dungeon. If you don't do anything in the next few seconds, you will most likely die.
                What do you do?
                Rot in your cell
                Unlock the cell with the key next to you""", true);
    }
}
