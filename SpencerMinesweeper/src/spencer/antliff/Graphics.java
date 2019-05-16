package spencer.antliff;
import hutchison.grant.NewButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Graphics extends Application {
			// create the board
			Button button;
			private static final int ROWS = 16;
			private static final int COLS = 16;
			final CellState empty = CellState.EMPTY;
			final CellState hidden = CellState.HIDDEN;
			 //create the board
			Board board = new Board(ROWS, COLS,empty);
			
			Board cover = new Board(ROWS, COLS,hidden);

			private static Button[][] grid = new Button[ROWS][COLS];
			
			public static void main(String[] args){	
				launch (args);

				
			}
			@Override
			public void start(Stage primaryStage) throws Exception {
				GridPane gridPane = new GridPane();
				
				primaryStage.setTitle("Minesweeper");
				
				primaryStage.setWidth(400);
				primaryStage.setHeight(400);
				primaryStage.setTitle("MineSweeper");
				
				for (int i = 0; i < board.getRows(); i++) {
					for (int j = 0; j < board.getCols(); j++) {
							grid[i][j] = new NewButton(i,j);
							grid[i][j].setPrefSize(20,20);
							grid[i][j].setStyle("-fx-base: #000010;");
							gridPane.add(grid[i][j],j ,i );
							
							grid[i][j].setOnAction(new EventHandler<ActionEvent>() {
					            @Override
					            public void handle(ActionEvent event) {
					            	int row = ((NewButton) event.getSource()).getRow();
					    			int col = ((NewButton)event.getSource()).getCol();
					            	CellState cs = board.getCell(row,col);
					            	
					            }
					        });
							
							
					}
				}
				Scene myScene = new Scene(gridPane);
				primaryStage.setScene(myScene);
				primaryStage.show();
			}
}
