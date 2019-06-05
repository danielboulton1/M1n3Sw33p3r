package spencer.antliff;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NewButton extends Button {
	private int row;
	private int col;
	private boolean clicked;
	private boolean flagged;
	private CellState state;
	//private boolean bombed;
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
	/**
	 * NewButton constructor
	 * @param r
	 * row value
	 * @param c
	 * column value
	 */
	public NewButton (int r, int c){

		super();
		row = r;
		col = c;
		clicked = false;
	}
	/**
	 * change the CellState
	 * @param cs
	 * new CellState
	 */
	public void setState (CellState cs){
		state = cs;
	}
	/**
	 * change flag state
	 */
	public void beenFlagged() {
		flagged=!flagged;
	}
	/**
	 * returns the flagState of the NewButton(true or false)
	 * @return
	 */
	public boolean getFlagState() {
		return flagged;
	}
	/**
	 * Change the click state
	 */
	public void beenClicked() {
		clicked =!clicked;
	}
	/**
	 * returns click state true or false
	 * @return
	 */
	public boolean returnClick() {
		return clicked;
	}
	/**
	 * returns the row value of a NewButton
	 * @return
	 */
	public int getRow(){
		return row;
	}
	/**
	 * returns the column value of a NewButton
	 * @return
	 */
	public int getCol(){
		return col;
	}
	//for emptyCheck
	/**
	 * displays an image depending on the CellState that's inputed
	 * @param cs
	 * cellstate that determines the image that is displayed
	 */
	public void imageDisplay(CellState cs) {
		if (cs==CellState.B1 && clicked == false) {
			imageSet(one);
			clicked = true;
		}
		if (cs==CellState.B2 && clicked == false) {
			imageSet(two);
			clicked = true;
		}
		if (cs==CellState.B3 && clicked == false) {
			imageSet(three);
			clicked = true;
		}
		if (cs==CellState.B4 && clicked == false) {
			imageSet(four);
			clicked = true;
		}
		if (cs==CellState.B5 && clicked == false) {
			imageSet(five);
			clicked = true;
		}
		if (cs==CellState.B6 && clicked == false) {
			imageSet(six);
			clicked = true;
		}
		if (cs==CellState.B7 && clicked == false) {
			imageSet(seven);
			clicked = true;
		}
		if (cs==CellState.B8 && clicked == false) {
			imageSet(eight);
			clicked = true;
		}
		if (cs==CellState.EMPTY && clicked == false) {
			imageSet(blank);
			clicked = true;
		}
	}
	/**
	 * changes the image of a NewButton
	 * @param image
	 * Desired image to be displayed
	 */
	public void imageSet(Image image) {
		ImageView iv = new ImageView();
		iv.setImage(image);
		super.setGraphic(iv);
	}
	@Override
	/**
	 * changes non-string values to string
	 */
	public String toString(){
		return "[" + String.valueOf(getRow()) + "," + String.valueOf(getCol())+"]";
	}
	
	
}
