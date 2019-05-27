package spencer.antliff;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NewButton extends Button {
	private int row;
	private int col;
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
	public NewButton (int r, int c){

		super();
		row = r;
		col = c;
	}
	public boolean beenClicked(boolean click) {
		return click;
	}
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	public void imageDisplay(CellState cs) {
		if (cs==CellState.B1 && beenClicked(false)) {
			imageSet(one);
			beenClicked(true);
		}
		if (cs==CellState.B2 && beenClicked(false)) {
			imageSet(two);
			beenClicked(true);
		}
		if (cs==CellState.B3 && beenClicked(false)) {
			imageSet(three);
			beenClicked(true);
		}
		if (cs==CellState.B4 && beenClicked(false)) {
			imageSet(four);
			beenClicked(true);
		}
		if (cs==CellState.B5 && beenClicked(false)) {
			imageSet(five);
			beenClicked(true);
		}
		if (cs==CellState.B6 && beenClicked(false)) {
			imageSet(six);
			beenClicked(true);
		}
		if (cs==CellState.B7 && beenClicked(false)) {
			imageSet(seven);
			beenClicked(true);
		}
		if (cs==CellState.B8 && beenClicked(false)) {
			imageSet(eight);
			beenClicked(true);
		}
		if (cs==CellState.EMPTY && beenClicked(false)) {
			imageSet(blank);
			beenClicked(true);
		}
	}
	public void imageSet(Image image) {
		ImageView iv = new ImageView();
		iv.setImage(image);
		super.setGraphic(iv);
	}
	@Override
	public String toString(){
		return "[" + String.valueOf(getRow()) + "," + String.valueOf(getCol())+"]";
	}
	
	
}
