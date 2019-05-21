package spencer.antliff;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int ROWS = 16;
		final int COLS = 16;
		final CellState empty = CellState.EMPTY;
		final CellState hidden = CellState.HIDDEN;
		 //create the board
		Board board = new Board(ROWS, COLS,empty);
		
		board.display();
		Board cover = new Board(ROWS, COLS,hidden);
		cover.display();
	}

}
