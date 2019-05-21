package spencer.antliff;
import java.util.Scanner;

import spencer.antliff.NewButton;
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
			Scanner in = new Scanner(System.in);
			private static final int ROWS = 16;
			private static final int COLS = 16;
			final CellState empty = CellState.EMPTY;
			final CellState hidden = CellState.HIDDEN;
			 //create the board
			Board board = new Board(ROWS, COLS,empty);
			
	

			private static Button[][] grid = new Button[ROWS][COLS];
			
			public static void main(String[] args){	
				launch (args);

				
			}
			@Override
			public void start(Stage primaryStage) throws Exception {
				
				GridPane gridPane = new GridPane();
				
				primaryStage.setTitle("Minesweeper");
				
				primaryStage.setWidth(1000);
				primaryStage.setHeight(1000);
				primaryStage.setTitle("MineSweeper");
				
				for (int i = 0; i < board.getRows(); i++) {
					for (int j = 0; j < board.getCols(); j++) {
							grid[i][j] = new NewButton(i,j);
							grid[i][j].setPrefSize(20,20);
							grid[i][j].setStyle("-fx-base:gray;-fx-border-color:black");
							gridPane.add(grid[i][j],j ,i );
							
							grid[i][j].setOnAction(new EventHandler<ActionEvent>() {
					            @Override
					            public void handle(ActionEvent event) {
					            	int row = ((NewButton) event.getSource()).getRow();
					    			int col = ((NewButton)event.getSource()).getCol();
					            	CellState cs = board.getCell(row,col);
					            	System.out.println(board.getCell(row, col));
					            	switch (cs){
					        		case BOMB:
					        			break;
					        		case FLAGGED:
					        			break;
					        		case B1:
					        			grid[row][col].setStyle("-fx-base:blue");
					        			System.out.println("yuh");

					        			break;
					        		//blue	
					        		case B2:
					        			grid[row][col].setStyle("-fx-base:green");
					        		//green
					        			System.out.println("yuh");
					        			break;
					        		case B3:
					        			grid[row][col].setStyle("-fx-base:red");
					        		//red
					        			System.out.println("yuh");
					        			break;
					        		case B4:
					        			grid[row][col].setStyle("-fx-base:purple");
					        		//purple
					        			System.out.println("yuh");
					        			break;
					        		case B5:
					        			grid[row][col].setStyle("-fx-base:pink");
					        		//dark red
					        			System.out.println("yuh");
					        			break;
					        		case B6:
					        			grid[row][col].setStyle("-fx-base:yellow");
					        		//Turquoise
					        			System.out.println("yuh");
					        			break;
					        		case B7:
					        			grid[row][col].setStyle("-fx-base:black");
					        		//black
					        			System.out.println("yuh");
					        			break;
					        		case B8:
					        			grid[row][col].setStyle("-fx-base:gray");
					        		//dark gray
					        			System.out.println("yuh");
					        			break;
					        		case EMPTY:
					        		//light gray
					        			break;
									default:
										break;
					        			
									}			
					            }
					        });
							
							
					}
				}
				
				Scene myScene = new Scene(gridPane);
				primaryStage.setScene(myScene);
				
				primaryStage.show();
			
			}
}
