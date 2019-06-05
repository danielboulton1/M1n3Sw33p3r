package spencer.antliff;

import java.util.Scanner;
public class Driver {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int ROWS = 16;
		final int COLS = 16;
		 //create the board
		Board board = new Board(ROWS, COLS);
		board.display();
		Board cover = new Board(ROWS, COLS);
		cover.display();
	}
}