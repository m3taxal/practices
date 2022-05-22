
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {
    private Rectangle[][] cellBodies;

    public void evolve(){
        int[][] neighbours = new int[99][99];

        for(int i = 1; i < 99; i++){ //column
            for(int j = 1; j < 99; j++){ //row
                int livingNeighbours = 0;
                if(cellBodies[i][j-1].getFill().equals(Color.RED)){
                    livingNeighbours += 1;
                }

                if(cellBodies[i][j+1].getFill().equals(Color.RED)){
                    livingNeighbours += 1;
                }

                if(cellBodies[i-1][j-1].getFill().equals(Color.RED)){
                    livingNeighbours += 1;
                }

                if(cellBodies[i+1][j-1].getFill().equals(Color.RED)){
                    livingNeighbours += 1;
                }

                if(cellBodies[i-1][j].getFill().equals(Color.RED)){
                    livingNeighbours += 1;
                }

                if(cellBodies[i+1][j].getFill().equals(Color.RED)){
                    livingNeighbours += 1;
                }

                if(cellBodies[i-1][j+1].getFill().equals(Color.RED)){
                    livingNeighbours += 1;
                }


                if(cellBodies[i+1][j+1].getFill().equals(Color.RED)){
                    livingNeighbours += 1;
                }

                neighbours[i][j] = livingNeighbours;
            }
        }

        for(int i = 0; i < 99; i++){
            for(int j = 0; j < 99; j++){
                if(cellBodies[i][j].getFill().equals(Color.RED)){
                    if(neighbours[i][j] < 2){
                        cellBodies[i][j].setFill(Color.TRANSPARENT);
                    }

                    if(neighbours[i][j] == 2 || neighbours[i][j] == 3){
                        cellBodies[i][j].setFill(Color.RED);
                    }

                    if(neighbours[i][j] > 3){
                        cellBodies[i][j].setFill(Color.TRANSPARENT);
                    }
                }

                if(cellBodies[i][j].getFill().equals(Color.TRANSPARENT) && neighbours[i][j] == 3){
                    cellBodies[i][j].setFill(Color.RED);
                }
            }
        }
    }

    public void initCells(GridPane gridPane){
        cellBodies = new Rectangle[100][100]; //column, row

        for(int currentColumn = 0; currentColumn < cellBodies.length; currentColumn++){
            for(int currentRow = 0; currentRow < 100; currentRow++){
                cellBodies[currentColumn][currentRow] = new Rectangle();
                Rectangle temp = cellBodies[currentColumn][currentRow];

                temp.setHeight(10);
                temp.setWidth(10);
                temp.setFill(Color.TRANSPARENT);

                int finalCurrentColumn = currentColumn;
                int finalCurrentRow = currentRow;
                cellBodies[currentColumn][currentRow].setOnMouseClicked(mouseEvent -> {
                    if(cellBodies[finalCurrentColumn][finalCurrentRow].getFill().equals(Color.TRANSPARENT)){
                        cellBodies[finalCurrentColumn][finalCurrentRow].setFill(Color.RED);
                    }
                    else {
                        cellBodies[finalCurrentColumn][finalCurrentRow].setFill(Color.TRANSPARENT);
                    }
                });

                gridPane.add(temp, currentColumn, currentRow);
            }
        }
    }
}
