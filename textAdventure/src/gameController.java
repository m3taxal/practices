import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class gameController implements Initializable {

    @FXML
    private ImageView triangle;

    @FXML
    private TextArea gameDialogue;

    @FXML
    private TextField playerInput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameDialogue.setEditable(false);

        //sets text limit for playerInput (no idea how it actually works)
        Pattern pattern = Pattern.compile(".{0,78}");
        TextFormatter formatter = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
            return pattern.matcher(change.getControlNewText()).matches() ? change : null;
        });

        playerInput.setTextFormatter(formatter);

        FadeTransition ft = new FadeTransition();
        ft.setNode(triangle);
        ft.setDuration(Duration.millis(500));
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft.setCycleCount(FadeTransition.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
    }
}
