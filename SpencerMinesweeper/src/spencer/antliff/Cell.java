package spencer.antliff;

public class Cell {
private CellState state;
	
	public Cell(CellState cs) {
		state = cs;
		
	}
	public void setNum(int num) {
		if(num==1) {
			setState(CellState.B1);
		}
		if(num==2) {
			setState(CellState.B2);
		}
		if(num==3) {
			setState(CellState.B3);
		}
		if(num==4) {
			setState(CellState.B4);
		}
		if(num==5) {
			setState(CellState.B5);
		}
		if(num==6) {
			setState(CellState.B6);
		}
		if(num==7) {
			setState(CellState.B7);
		}
		if(num==8) {
			setState(CellState.B8);
		}
	}
	public void setState (CellState cs){
		state = cs;
	}
	
	public CellState getState() {
		return state;
	}

	public String toString() {
		switch (state) {
		case HIDDEN:
			return "H";
		case SHOW:
			return "S";
		case BOMB:
			return "x";
		case B1:
			return "1";
		case B2:
			return "2";
		case B3:
			return "3";
		case B4:
			return "4";
		case B5:
			return "5";
		case B6:
			return "6";
		case B7:
			return "7";
		case B8:
			return "8";
		case EMPTY:
			return "-";
		default:
			return "-";
		}
	}

}
