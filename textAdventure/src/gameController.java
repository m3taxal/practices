
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

    private ArrayList<String> allLines = new ArrayList<>();

    public void scrollText(String line){
        gameDialogue.appendText("\n");
        this.letter = 0;

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.05), e -> {
            this.gameDialogue.appendText(String.valueOf(line.charAt(this.letter)));
            this.letter++;
        }));

        timeline.setCycleCount(line.length());
        timeline.play();
        timeline.setOnFinished(actionEvent -> canWrite=true);
    }

    public void addToGameDialogue(){
        if(canWrite == true){
            String playerLine = playerInput.getText();
            int rememberLine = 0;

            for(int i = 0; i < allLines.size(); i++){
                if(playerLine.equalsIgnoreCase(allLines.get(i))){
                    rememberLine = i;
                    canWrite = false;
                    System.out.println(i);
                    break;
                }
            }

            if(canWrite == false){
                switch (rememberLine){
                    case 2:
                        scrollText(allLines.get(4));
                        System.exit(0);
                        break;
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

        scrollText("""
                You are captured in an underground cell inside a dungeon. If you don't do anything in the next few seconds, you will most likely die.
                What do you do?
                Rot in your cell
                Unlock the cell with the key next to you""");
    }
}
