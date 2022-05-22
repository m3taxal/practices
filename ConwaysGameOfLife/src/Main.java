
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    private static GridPane grid;

    public static GridPane getGrid() {
        return grid;
    }

    private void initGrid(){
        grid = new GridPane();
        grid.setGridLinesVisible(true);
        final int numCols = 100 ;
        final int numRows = 100 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            grid.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            grid.getRowConstraints().add(rowConst);
        }
    }

    @Override
    public void start(Stage stage) {
        initGrid();

        Scene scene = new Scene(grid, 1000, 1000);

        Controller controller = new Controller();
        controller.initCells(grid);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case SPACE -> controller.evolve();
                }
            }
        });

        stage.setTitle("Conway's Game Of Life");
        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();
    }
}
