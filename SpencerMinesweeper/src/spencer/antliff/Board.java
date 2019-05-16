package spencer.antliff;
import java.util.Random;
public class Board {
	private static Cell[][] board;
	private static int rows;
	private static int cols;
	
	static CellState empty = CellState.EMPTY;
	static CellState hidden = CellState.HIDDEN;
	public Board(int aRows, int aCols,CellState cell) {
		board = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(cell); // no color
			}
		}
		if(cell==CellState.EMPTY) {
		bombPlace(board, rows, cols);
		numPlace(board, rows, cols);
	
		}	
	}
	public CellState getCell(int row,int col) {
		CellState cell = board[row][col].getState();
		return cell;
	}
	public int getRows() {
		return rows;
	}
	public int getCols() {
		return cols;
	}
	public void numPlace(Cell[][] arr,int row, int col) {
		//to organize direction checks
		CellState up = CellState.BOMB;
		CellState down = CellState.BOMB;
		CellState left = CellState.BOMB;
		CellState right = CellState.BOMB;
		CellState upLeft = CellState.BOMB;
		CellState upRight = CellState.BOMB;
		CellState downLeft = CellState.BOMB;
		CellState downRight = CellState.BOMB;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(arr[i][j].getState()==CellState.EMPTY) {
					int num=0;
					boolean finish = false;
					while(!finish) {
				//numPlace on corners
						if(j==0 && i ==0) {
							if(right==arr[i][j+1].getState()) {
								num=num+1;
							}
							if(down==arr[i][j+1].getState()) {
								num=num+1;
							}
							if(downRight==arr[i+1][j+1].getState()) {
								num=num+1;
							}
							arr[i][j].setNum(num);
							finish = true;
							break;
							}
						if(j==col-1 && i ==0) {
							if(left==arr[i][j-1].getState()) {
								num=num+1;
							}
							if(down==arr[i+1][j].getState()) {
								num=num+1;
							}
							if(downLeft==arr[i+1][j-1].getState()) {
								num=num+1;
							}
							arr[i][j].setNum(num);
							finish = true;
							break;
						}
						if(j==0 && i ==row-1) {
							if(right==arr[i][j+1].getState()) {
								num=num+1;
							}
							if(up==arr[i-1][j].getState()) {
								num=num+1;
							}
							if(upRight==arr[i-1][j+1].getState()) {
								num=num+1;
							}
							arr[i][j].setNum(num);
							finish = true;
							break;
						}
						if(j==col-1 && i ==row-1) {
							if(left==arr[i][j-1].getState()) {
								num=num+1;
							}
							if(up==arr[i-1][j].getState()) {
								num=num+1;
							}
							if(upLeft==arr[i-1][j-1].getState()) {
								num=num+1;
							}
							arr[i][j].setNum(num);
							finish = true;
							break;
						}
						//numPlace on edges
						if(i==0) {
							if(down==arr[i+1][j].getState()) {
								num=num+1;
							}
							if(left==arr[i][j-1].getState()) {
								num=num+1;
							}
							if(right==arr[i][j+1].getState()) {
								num=num+1;
							}
							if(downLeft==arr[i+1][j-1].getState()) {
								num=num+1;
							}
							if(downRight==arr[i+1][j+1].getState()) {
								num=num+1;
							}
							arr[i][j].setNum(num);
							finish = true;
							break;
						}
						if(j ==0) {
							if(up==arr[i-1][j].getState()) {
								num=num+1;
							}
							if(down==arr[i+1][j].getState()) {
								num=num+1;
							}
							if(right==arr[i][j+1].getState()) {
								num=num+1;
							}
							if(downRight==arr[i+1][j+1].getState()) {
								num=num+1;
							}
							if(upRight==arr[i-1][j+1].getState()) {
								num=num+1;
							}
							arr[i][j].setNum(num);
							finish = true;
							break;
						}
						if(j==col-1) {
							if(up==arr[i-1][j].getState()) {
								num=num+1;
							}
							if(down==arr[i+1][j].getState()) {
								num=num+1;
							}
							if(left==arr[i][j-1].getState()) {
								num=num+1;
							}
							if(downLeft==arr[i+1][j-1].getState()) {
								num=num+1;
							}
							if(upLeft==arr[i-1][j-1].getState()) {
								num=num+1;
							}
							arr[i][j].setNum(num);
							finish = true;
							break;
						}
						if(i ==row-1) {
							if(up==arr[i-1][j].getState()) {
								num=num+1;
							}
							if(left==arr[i][j-1].getState()) {
								num=num+1;
							}
							if(right==arr[i][j+1].getState()) {
								num=num+1;
							}
							if(upLeft==arr[i-1][j-1].getState()) {
								num=num+1;
							}
							if(upRight==arr[i-1][j+1].getState()) {
								num=num+1;
							}
							arr[i][j].setNum(num);
							finish = true;
							break;
						}
				
						//numPlace everywhere else
						if(up==arr[i-1][j].getState()) {
							num=num+1;
						}
						if(down==arr[i+1][j].getState()) {
							num=num+1;
						}
						if(left==arr[i][j-1].getState()) {
							num=num+1;
						}
						if(right==arr[i][j+1].getState()) {
							num=num+1;
						}
						if(upLeft==arr[i-1][j-1].getState()) {
							num=num+1;
						}
						if(upRight==arr[i-1][j+1].getState()) {
							num=num+1;
						}
						if(downLeft==arr[i+1][j-1].getState()) {
							num=num+1;
						}
						if(downRight==arr[i+1][j+1].getState()) {
							num=num+1;
						}
						arr[i][j].setNum(num);
						finish = true;
					}
				}
			}
		}
	}
	public void bombPlace(Cell[][] arr,int row, int col) {
		Random r = new Random();
		CellState bomb = CellState.BOMB;
		int nBombs = 40;
		boolean done = false;
		while(!done) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					CellState isEmpty = arr[i][j].getState();
						if (isEmpty==CellState.EMPTY) {
							int R = r.nextInt(101);
								if(R>99) {
									arr[i][j].setState(bomb);
									nBombs = nBombs-1;
								}
									if (nBombs == 0) {
										done = true;
										return;
									}
						}
				}
				
			}
		}
	}
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
}
