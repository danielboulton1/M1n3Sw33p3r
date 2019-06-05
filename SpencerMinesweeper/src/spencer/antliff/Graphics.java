package spencer.antliff;
import java.util.Scanner;

import javafx.scene.image.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.*; 
import spencer.antliff.NewButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Graphics extends Application {
			// create the board
			Button button;
			Scanner in = new Scanner(System.in);
			private static final int ROWS = 16;
			private static final int COLS = 16;
			final CellState empty = CellState.EMPTY;
			 //create the board
			Board board = new Board(ROWS, COLS);
			/**
			 * returns a cellstate depending on the number inputed
			 * @param num
			 * number of bombs in a 1 block radius of a point
			 * @return
			 */
			public CellState getNum(int num) {
				if(num==1) {
					return CellState.B1;
				}
				if(num==2) {
					return CellState.B2;
				}
				if(num==3) {
					return CellState.B3;
				}
				if(num==4) {
					return CellState.B4;
				}
				if(num==5) {
					return CellState.B5;
				}
				if(num==6) {
					return CellState.B6;
				}
				if(num==7) {
					return CellState.B7;
				}
			return CellState.B8;
				
			}
			/**
			 * when clicking on a number it checks if that number has the corresponding number of flags around it.
			 * If it doesn't, method ends. If it does, all cells that aren't displayed around the cell that was clicked get displayed, and clicked.
			 * If the flagging was done incorrectly by the player and a bomb is displayed the player loses the game.
			 * @param arg
			 * 2d button array
			 * @param row
			 * row value of clicked cell
			 * @param col
			 * column value of clicked cell
			 * @param bomb
			 * bomb image
			 * @param bombWithX
			 * bomb with x image
			 * @param bombRed
			 * bomb red image
			 */
			public void clickCheck(Button[][] arg, int row, int col,Image bomb,Image bombWithX,Image bombRed) {
				CellState clickState = board.getCell(row, col);
				int flags = 0;
				for(int i=-1;i<=1;i++) {
					for (int j=-1;j<=1;j++) {
						if(((row+i)>=0 && (row+i)<ROWS)&&((col+j)>=0 && (col+j)<COLS)&& ((NewButton) arg[row+i][col+j]).returnClick()==false) {
							if(((NewButton) arg[row+i][col+j]).getFlagState()==true) {
								flags = flags +1;
							}
						}
					}
				}
				System.out.println(flags);
				if(getNum(flags)==clickState) {
					for(int i=-1;i<=1;i++) {
						for (int j=-1;j<=1;j++) {
							if(((row+i)>=0 && (row+i)<ROWS)&&((col+j)>=0 && (col+j)<COLS)&& ((NewButton) arg[row+i][col+j]).getFlagState()==false) {
								CellState state = board.getCell(row+i,col+j);
								if(state==CellState.BOMB) {
									
									for(int f=0;f<COLS;f++) {
				        				for (int g=0;g<ROWS;g++) {
				        					boolean flog = ((NewButton) grid[f][g]).getFlagState();
				        					
				        					if(board.getCell(f,g)!=CellState.BOMB && flog == true) {
				        						((NewButton) grid[f][g]).imageSet(bombWithX);
				        					}
				        					if(board.getCell(f,g)==CellState.BOMB) {
				        						((NewButton) grid[f][g]).imageSet(bomb);
				        					}
				        				}
				        			}
									((NewButton) grid[row+i][col+j]).imageSet(bombRed);
									
									break;
				        			}
								if(state==CellState.EMPTY) {
									
									System.out.println("It did it");
									emptyCheck(arg,(row+i),(col+j));
								}
								((NewButton) arg[row+i][col+j]).imageDisplay(state);
								}
							}
						}
					}
				}
			/**
			 * Recursively checks if adjacent cells around a clicked cell are empty, and displays all the cells around each empty cell including the empty cell.
			 * @param arg
			 * 2d button array
			 * @param row
			 * row value of clicked cell
			 * @param col
			 * column value of clicked cell
			 */
			public void emptyCheck(Button[][] arg,int row, int col) {
				//boolean repeat = false;
				for(int i=-1;i<=1;i++) {
					for (int j=-1;j<=1;j++) {
						if(((row+i)>=0 && (row+i)<ROWS)&&((col+j)>=0 && (col+j)<COLS)&& ((NewButton) arg[row+i][col+j]).getFlagState()==false) {
						CellState state = board.getCell(row+i,col+j);
							System.out.println(state+"state");
							System.out.println(((NewButton) arg[row+i][col+j]).returnClick());
							if(state==CellState.EMPTY && ((NewButton) arg[row+i][col+j]).returnClick()==false) {
								System.out.println("yes");
								//basically, image display changes the clicked value to true and it makes the beenclicked function pretty much useless
								((NewButton) arg[row+i][col+j]).imageDisplay(state);
								emptyCheck(arg,row+i,col+j);
								}
							((NewButton) arg[row+i][col+j]).imageDisplay(state);
						
						
							}
						}
				}
				
			}
	

			public static Button[][] grid = new Button[ROWS][COLS];
			
			public static void main(String[] args){	
				launch (args);

				
			}
			/**
			 * checks if the player has won by clicking on all non bomb cells
			 * @param grid
			 * 2d button array
			 * @return
			 */
			public boolean winCheck(Button[][] grid) {
				int rows = board.getRows();
				int cols = board.getCols();
				int nCells = 216;
				int nClicks = 0;
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
					if (((NewButton)grid[i][j]).returnClick()==true) {
						nClicks=nClicks+1;
					}
					}
				}
				if(nCells-nClicks==0) {
					return true;
				}
				return false;
			}
			@Override
			/**
			 * Starts the game
			 */
			public void start(Stage primaryStage) throws Exception {
				
				GridPane gridPane = new GridPane();
				//images
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
				Image Flag = new Image("Flag.png");		
				Image bombRed = new Image("bombWithRedBackground.png");
				Image bombWithX = new Image("bombWithX.png");
				Image hutchHappy = new Image("hutchHappyminesweeper.png");
				Image hutchSad = new Image("hutchSadminesweeper.png");
				primaryStage.setWidth(360);
				primaryStage.setHeight(360);
				primaryStage.setTitle("MineSweeper");
			
				for (int i = 0; i < board.getRows(); i++) {
					for (int j = 0; j < board.getCols(); j++) {
							grid[i][j] = new NewButton(i,j);
							grid[i][j].setMinSize(20, 20);
							grid[i][j].setMaxSize(20, 20);
							((NewButton) grid[i][j]).imageSet(raisedBlank);
							gridPane.add(grid[i][j],j ,i );
							grid[i][j].setOnMouseReleased(new EventHandler<MouseEvent>() {
								/**
								 * mouse events
								 */
					            public void handle(MouseEvent event) {
					            	MouseButton mbutton = event.getButton();
					            	int row = ((NewButton) event.getSource()).getRow();
					    			int col = ((NewButton)event.getSource()).getCol();
					    			boolean setClick = ((NewButton) grid[row][col]).returnClick();
					    			boolean flog = ((NewButton) grid[row][col]).getFlagState();
					            	CellState cs = board.getCell(row,col);
					            	System.out.println(board.getCell(row, col));
					            	
					            	if(mbutton==MouseButton.PRIMARY) {
					            	switch (cs){
					        		case BOMB:
					        			flog = ((NewButton) grid[row][col]).getFlagState();
					        			System.out.println(flog);
					        			if (flog==false && setClick==false) {
					        			((NewButton) grid[row][col]).beenClicked();
				            			setClick = ((NewButton) grid[row][col]).returnClick();
					        			for(int i=0;i<COLS;i++) {
					        				for (int j=0;j<ROWS;j++) {
					        					flog = ((NewButton) grid[i][j]).getFlagState();
					        					if(board.getCell(i, j)==CellState.BOMB) {
					        						((NewButton) grid[i][j]).imageSet(bomb);
					        					}
					        					if(board.getCell(i, j)!=CellState.BOMB && flog == true) {
					        						((NewButton) grid[i][j]).imageSet(bombWithX);
					        					}
					        				}
					        				
					        			}
					        			((NewButton) grid[row][col]).imageSet(bombRed);
					        			//optional hutch lose screen
					        			System.out.println("lose time");
					            		for(int i = 0;i<ROWS;i++) {
					            			for(int j = 0;j<COLS;j++) {
					            				((NewButton) grid[i][j]).imageSet(null);
					            				grid[i][j].setMinSize(0, 0);
												grid[i][j].setMaxSize(0, 0);
					            				boolean flagstate = ((NewButton) grid[i][j]).getFlagState();
					            				if (flagstate==true) {
					            					((NewButton) grid[i][j]).beenFlagged();
					            					}
					            				boolean clickstate = ((NewButton) grid[i][j]).returnClick();
					            				if (clickstate==false) {
					            					((NewButton) grid[i][j]).beenClicked();
					            					}
					            				}
					            			}
					            		grid[8][8].setMinSize(360, 360);
										grid[8][8].setMaxSize(360, 360);
										((NewButton) grid[8][8]).imageSet(hutchSad);
										//end of optional hutch lose screen
					        			}
					        			break;
					        		case FLAGGED:
					        			
					        			break;
					        		case B1:
					        			flog = ((NewButton) grid[row][col]).getFlagState();
					        			setClick = ((NewButton) grid[row][col]).returnClick();
					        			System.out.println(flog);
					        			if (flog==false && setClick==false) {
					        			((NewButton) grid[row][col]).imageSet(one);
					        			((NewButton) grid[row][col]).beenClicked();
					        			setClick = ((NewButton) grid[row][col]).returnClick();
					        			//if been clicked is true, make all adjacent non clicked squares visible
					        			break;
					        			}
					        			if (flog==false && setClick==true) {
					        				clickCheck(grid,row,col,bomb,bombWithX,bombRed);
					        				break;
					        			}
					        			if(setClick==true) {
					        			break;
					        			}
					        		case B2:
					        			//grid[row][col].setStyle("-fx-base:green");
					        			setClick = ((NewButton) grid[row][col]).returnClick();
					        			flog = ((NewButton) grid[row][col]).getFlagState();
					        			System.out.println(flog);
					        			if (flog==false && setClick==false) {
					        			((NewButton) grid[row][col]).imageSet(two);
					        			((NewButton) grid[row][col]).beenClicked();
				            			setClick = ((NewButton) grid[row][col]).returnClick();
					        			break;
					        			}
					        			if (flog==false && setClick==true) {
					        				clickCheck(grid,row,col,bomb,bombWithX,bombRed);
					        				break;
					        			}
					        			break;
					        		case B3:
					        			flog = ((NewButton) grid[row][col]).getFlagState();
					        			setClick = ((NewButton) grid[row][col]).returnClick();
					        			System.out.println(flog);
					        			if (flog==false && setClick==false) {
					        			((NewButton) grid[row][col]).imageSet(three);
					        			((NewButton) grid[row][col]).beenClicked();
				            			setClick = ((NewButton) grid[row][col]).returnClick();
				            			System.out.println(setClick);
					        			break;
					        			}
					        			if (flog==false && setClick==true) {
					        				clickCheck(grid,row,col,bomb,bombWithX,bombRed);
					        				break;
					        			}
					        			break;
					        		case B4:
					        			flog = ((NewButton) grid[row][col]).getFlagState();
					        			setClick = ((NewButton) grid[row][col]).returnClick();
					        			System.out.println(flog);
					        			if (flog==false && setClick==false) {
					        			((NewButton) grid[row][col]).imageSet(four);
					        			((NewButton) grid[row][col]).beenClicked();
				            			setClick = ((NewButton) grid[row][col]).returnClick();
				            			System.out.println(setClick);
					        			break;
					        			}
					        			if (flog==false && setClick==true) {
					        				clickCheck(grid,row,col,bomb,bombWithX,bombRed);
					        				break;
					        			}
					        			break;
					        		case B5:
					        			flog = ((NewButton) grid[row][col]).getFlagState();
					        			setClick = ((NewButton) grid[row][col]).returnClick();
					        			System.out.println(flog);
					        			if (flog==false && setClick==false) {
					        			((NewButton) grid[row][col]).imageSet(five);
					        			((NewButton) grid[row][col]).beenClicked();
				            			setClick = ((NewButton) grid[row][col]).returnClick();
				            			System.out.println(setClick);
					        			break;
					        			}
					        			if (flog==false && setClick==true) {
					        				clickCheck(grid,row,col,bomb,bombWithX,bombRed);
					        				break;
					        			}
					        			break;
					        		case B6:
					        			flog = ((NewButton) grid[row][col]).getFlagState();
					        			setClick = ((NewButton) grid[row][col]).returnClick();
					        			System.out.println(flog);
					        			if (flog==false && setClick==false) {
					        			((NewButton) grid[row][col]).imageSet(six);
					        			((NewButton) grid[row][col]).beenClicked();
				            			setClick = ((NewButton) grid[row][col]).returnClick();
				            			System.out.println(setClick);
					        			break;
					        			}
					        			if (flog==false && setClick==true) {
					        				clickCheck(grid,row,col,bomb,bombWithX,bombRed);
					        				break;
					        			}
					        			break;
					        		case B7:
					        			flog = ((NewButton) grid[row][col]).getFlagState();
					        			setClick = ((NewButton) grid[row][col]).returnClick();
					        			System.out.println(flog);
					        			if (flog==false && setClick==false) {
					        			((NewButton) grid[row][col]).imageSet(seven);
					        			((NewButton) grid[row][col]).beenClicked();
				            			setClick = ((NewButton) grid[row][col]).returnClick();
				            			System.out.println(setClick);
					        			break;
					        			}
					        			if (flog==false && setClick==true) {
					        				clickCheck(grid,row,col,bomb,bombWithX,bombRed);
					        				break;
					        			}
					        			break;
					        		case B8:
					        			flog = ((NewButton) grid[row][col]).getFlagState();
					        			setClick = ((NewButton) grid[row][col]).returnClick();
					        			System.out.println(flog);
					        			if (flog==false && setClick==false) {
					        			((NewButton) grid[row][col]).imageSet(eight);
					        			((NewButton) grid[row][col]).beenClicked();
				            			setClick = ((NewButton) grid[row][col]).returnClick();
				            			System.out.println(setClick);
					        			break;
					        			}
					        			if (flog==false && setClick==true) {
					        				clickCheck(grid,row,col,bomb,bombWithX,bombRed);
					        				break;
					        			}
					        			break;
					        		case EMPTY:
					        			flog = ((NewButton) grid[row][col]).getFlagState();
					        			setClick = ((NewButton) grid[row][col]).returnClick();
					        			System.out.println(flog);
					        			if (flog==false && setClick==false) {
					        			((NewButton) grid[row][col]).imageSet(blank);
					        			((NewButton) grid[row][col]).beenClicked();
				            			setClick = ((NewButton) grid[row][col]).returnClick();
				            			System.out.println(setClick);
					        			emptyCheck(grid,row,col);
					
					        			break;
					        			}
					        			break;
									default:
										break;
					            	}
					            	if (winCheck(grid)==true) {
					            		System.out.println("Winner time");
					            		for(int i = 0;i<ROWS;i++) {
					            			for(int j = 0;j<COLS;j++) {
					            				((NewButton) grid[i][j]).imageSet(null);
					            				grid[i][j].setMinSize(0, 0);
												grid[i][j].setMaxSize(0, 0);
					            				boolean flagstate = ((NewButton) grid[i][j]).getFlagState();
					            				if (flagstate==true) {
					            					((NewButton) grid[i][j]).beenFlagged();
					            					}
					            				boolean clickstate = ((NewButton) grid[i][j]).returnClick();
					            				if (clickstate==false) {
					            					((NewButton) grid[i][j]).beenClicked();
					            					}
					            				}
					            			}
					            		grid[8][8].setMinSize(360, 360);
										grid[8][8].setMaxSize(360, 360);
										((NewButton) grid[8][8]).imageSet(hutchHappy);
					            		}
					            	}
					            	if(mbutton==MouseButton.SECONDARY ) {
					            		System.out.println(setClick);
					            		System.out.println(flog);
					            		if(flog == false && setClick==false) {
					            			((NewButton) grid[row][col]).imageSet(Flag);
					            			((NewButton) grid[row][col]).beenFlagged();
					            		}
					            		if(flog==true) {
					            			((NewButton) grid[row][col]).imageSet(raisedBlank);
					            			((NewButton) grid[row][col]).beenFlagged();
					            		}
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
