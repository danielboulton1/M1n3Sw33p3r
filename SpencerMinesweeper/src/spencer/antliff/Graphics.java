package spencer.antliff;
import java.util.Scanner;

import javafx.scene.image.*;
import javafx.scene.paint.*; 
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
			public void emptyCheck(Button[][] arg,int row, int col) {
				for(int i=-1;i<1;i++) {
					for (int j=-1;j<1;j++) {
						CellState state = board.getCell(row+i,col+j);
						if(i==0 && j==0) {
							i=0;
							j=0;
						}else {
							if(state==CellState.EMPTY) {
								emptyCheck(arg,row,col);
							}
							((NewButton) arg[row+i][col+j]).imageDisplay(state);
							
						}
					}
				}
				
			}
	

			private static Button[][] grid = new Button[ROWS][COLS];
			
			public static void main(String[] args){	
				launch (args);

				
			}
			@Override
			public void start(Stage primaryStage) throws Exception {
				
				GridPane gridPane = new GridPane();
				Image raisedBlank = new Image("raisedBlank.png");
				Image one = new Image("1.png");
				Image two = new Image("2.png");
				Image three = new Image("3.png");				
				Image four = new Image("4 copy.png");
				Image five = new Image("5 copy.png");
				Image six = new Image("6 copy.png");
				Image seven = new Image("7 copy.png");
				Image eight = new Image("8 copy.png");
				Image blank = new Image("blank copy.png");
				Image bomb = new Image("bombImage.png");
				/*				
				Image bombRed = new Image("bombWithRedBackground.png");
				Image bombWithX = new Image("bombWithX.png");
				Image Flag = new Image("Flag.png");
				
				*/
				primaryStage.setTitle("Minesweeper");
				
				primaryStage.setWidth(360);
				primaryStage.setHeight(360);
				primaryStage.setTitle("MineSweeper");
			
				for (int i = 0; i < board.getRows(); i++) {
					for (int j = 0; j < board.getCols(); j++) {
							grid[i][j] = new NewButton(i,j);
							grid[i][j].setMinSize(20, 20);
							grid[i][j].setMaxSize(20, 20);
							((NewButton) grid[i][j]).beenClicked(false);
							((NewButton) grid[i][j]).imageSet(raisedBlank);
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
					        			((NewButton) grid[row][col]).imageSet(bomb);
					        			((NewButton) grid[row][col]).beenClicked(true);
					        			break;
					        		case FLAGGED:
					        			break;
					        		case B1:
					        			//grid[row][col].setStyle("-fx-base:blue");
					        			((NewButton) grid[row][col]).imageSet(one);
					        			((NewButton) grid[row][col]).beenClicked(true);
					        			break;
					        		case B2:
					        			grid[row][col].setStyle("-fx-base:green");
					        			((NewButton) grid[row][col]).imageSet(two);
					        			((NewButton) grid[row][col]).beenClicked(true);
					        			break;
					        		case B3:
					        			((NewButton) grid[row][col]).imageSet(three);
					        			((NewButton) grid[row][col]).beenClicked(true);
					        			break;
					        		case B4:
					        			((NewButton) grid[row][col]).imageSet(four);
					        			((NewButton) grid[row][col]).beenClicked(true);
					        			break;
					        		case B5:
					        			((NewButton) grid[row][col]).imageSet(five);
					        			((NewButton) grid[row][col]).beenClicked(true);
					        			break;
					        		case B6:
					        			((NewButton) grid[row][col]).imageSet(six);
					        			((NewButton) grid[row][col]).beenClicked(true);
					        			break;
					        		case B7:
					        			((NewButton) grid[row][col]).imageSet(seven);
					        			((NewButton) grid[row][col]).beenClicked(true);
					        			break;
					        		case B8:
					        			((NewButton) grid[row][col]).imageSet(eight);
					        			((NewButton) grid[row][col]).beenClicked(true);
					        			break;
					        		case EMPTY:
					        			((NewButton) grid[row][col]).imageSet(blank);
					        			((NewButton) grid[row][col]).beenClicked(true);
					        			//emptyCheck(grid[row][col],row,col);
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
