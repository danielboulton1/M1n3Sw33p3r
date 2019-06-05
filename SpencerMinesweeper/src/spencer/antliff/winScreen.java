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
import javafx.stage.Modality;
import javafx.stage.Stage;
public class winScreen extends Graphics {

	public static void display(String args) {
		Stage winScreen = new Stage();
		winScreen.initModality(Modality.APPLICATION_MODAL);
		winScreen.setTitle("Good job.");
		winScreen.setMinHeight(600);
		winScreen.setMinWidth(600);
		Button newgame = new Button();
		
		newgame.setOnAction(e ->{
			winScreen.close();
		}
		
	}
}
