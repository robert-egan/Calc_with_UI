package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	/*
	 * I first tried using SceneBuilder, but I could not figure out how to work 
	 * with the .fxml file or attach code to any of the buttons. I even wrote a
	 * controller file but just couldn't get any of it to work, so I went with
	 * a simpler approach, building off of the example we did in class, and using
	 * what I built in SceneBuilder as the model for panes and dimensions.
	 */
	
	//Declarations
	Button btnAbsVal;
	Button btnAdd;
	Button btnCeiling;
	Button btnClear;
	Button btnDivide;
	Button btnFactorial;
	Button btnFloor;
	Button btnMultiply;
	Button btnPower;
	Button btnSqRoot;
	Button btnSubtract;
	Label lblAnswer;
	Label lblMessage;
	TextField tfNum1;
	TextField tfNum2;
	float num1, num2, answer=0;
	char symbol=' ' ;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Instantiation of objects
			btnAbsVal = new Button("abs");
			btnAdd  = new Button("+");
			btnCeiling = new Button("ceil");
			btnClear = new Button("clear");
			btnDivide = new Button("/");
			btnFactorial = new Button("!");
			btnFloor = new Button("floor");
			btnMultiply = new Button("*");
			btnPower = new Button("^");
			btnSqRoot = new Button("sqrt");
			btnSubtract = new Button("-");
			lblAnswer = new Label("?");
			lblMessage = new Label("Welcome to TI-Eightyfree");
			tfNum1 = new TextField();
			tfNum2 = new TextField();
			
			//BorderPane to contain the whole calculator
			BorderPane root = new BorderPane();
			
			//VBox to contain the two Labels
			VBox screen = new VBox();
			root.setTop(screen);
			screen.getChildren().add(0, lblMessage);
			screen.getChildren().add(1, lblAnswer);
			
			//HBox for the two TextFields
			HBox nums = new HBox();
			root.setBottom(nums);
			nums.getChildren().add(0, tfNum1);
			nums.getChildren().add(1, tfNum2);
			
			//GridPane for the buttons
			GridPane grid = new GridPane();
			root.setCenter(grid);
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.add(btnPower, 0, 0);
			grid.add(btnSqRoot, 1, 0);
			grid.add(btnFloor, 2, 0);
			grid.add(btnCeiling, 3, 0);
			grid.add(btnMultiply, 0, 1);
			grid.add(btnDivide, 1, 1);
			grid.add(btnFactorial, 2, 1);
			grid.add(btnAdd, 0, 2);
			grid.add(btnSubtract, 1, 2);
			grid.add(btnAbsVal, 2, 2);
			grid.add(btnClear, 3, 2);
			
			setDimensionsAndAlignments();
			attachCode();
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setDimensionsAndAlignments() {
		/*
		 * Sets up dimensions, alignments, borders, and styling of all the 
		 * controls in the GUI
		 */
		tfNum1.setAlignment(Pos.CENTER);
		tfNum2.setAlignment(Pos.CENTER);
		tfNum1.setPrefSize(200, 50);
		tfNum2.setPrefSize(200, 50);
		tfNum1.setStyle("-fx-font-size:16");
		tfNum2.setStyle("-fx-font-size:16");
		btnAbsVal.setPrefSize(80,50);
		btnAdd.setPrefSize(80,50);
		btnCeiling.setPrefSize(80,50);
		btnClear.setPrefSize(80,50);
		btnDivide.setPrefSize(80,50);
		btnFactorial.setPrefSize(80,50);
		btnFloor.setPrefSize(80,50);
		btnMultiply.setPrefSize(80,50);
		btnPower.setPrefSize(80,50);
		btnSqRoot.setPrefSize(80,50);
		btnSubtract.setPrefSize(80,50);
		lblAnswer.setPrefSize(400, 80);
		lblMessage.setPrefSize(400, 80);
		lblAnswer.setAlignment(Pos.CENTER);
		lblMessage.setAlignment(Pos.CENTER);
		lblMessage.setBorder(new Border(new BorderStroke
				(Color.BLACK, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		lblAnswer.setBorder(new Border(new BorderStroke
				(Color.BLACK, BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		lblMessage.setStyle("-fx-font-size:18");
		lblAnswer.setStyle("-fx-font-size:18");
		
	}
	
	//setters for the two labels
	public void setLabelAnswer(String text) {
		lblAnswer.setText(text);
	}
	public void setLabelMessage(String text) {
		lblMessage.setText(text);
	}
	public void attachCode() {
		//Associate the button being clicked to the code that should run in the btncode function
		btnAbsVal.setOnAction(e-> btncode(e));
		btnAdd.setOnAction(e-> btncode(e));
		btnCeiling.setOnAction(e-> btncode(e));
		btnClear.setOnAction(e-> btncode(e));
		btnDivide.setOnAction(e-> btncode(e));
		btnFactorial.setOnAction(e-> btncode(e));
		btnFloor.setOnAction(e-> btncode(e));
		btnMultiply.setOnAction(e-> btncode(e));
		btnPower.setOnAction(e-> btncode(e));
		btnSqRoot.setOnAction(e-> btncode(e));
		btnSubtract.setOnAction(e-> btncode(e));
	}
	public void btncode(ActionEvent e) {
		/*
		 * Code for all of the operations. Was not able to make a switch case work
		 * because it would not switch on an object, only a primitive data type.
		 * References methods in the Calculator.java file, all of which have been
		 * made static for this project.
		 */
		
		num1 = Float.parseFloat(tfNum1.getText());
		num2 = Float.parseFloat(tfNum2.getText());
		
		if(e.getSource() == btnAbsVal) {
			answer = Calculator.getAbValue(num1);
			setLabelMessage("The absolute value of " + num1 + "=");
			setLabelAnswer("" + answer);
		}
		else if(e.getSource() == btnAdd) {
			answer = Calculator.addNumbers(num1, num2);
			symbol = '+';
			setLabelMessage("" + num1 + symbol + num1 + "=");
			setLabelAnswer("" + answer);
		}
		else if(e.getSource() == btnCeiling) {
			answer = Calculator.findCeiling(num1);
			setLabelMessage("The ceiling of " + num1 +"=");
			setLabelAnswer("" + answer);
		}
		else if(e.getSource() == btnClear) {
			setLabelMessage("Welcome to TI-Eightyfree");
			setLabelAnswer("?");
			tfNum1.setText("");
			tfNum2.setText("");
		}
		else if(e.getSource() == btnDivide) {
			if (num2 == 0) {
				setLabelAnswer("?");
				setLabelMessage("Division by Zero not possible");
				return;
			}
			answer = Calculator.divideNumbers(num1, num2);
			symbol = '/';
			setLabelMessage("" + num1 + symbol + num2 + "=");
			setLabelAnswer("" + answer);
		}
		else if(e.getSource() == btnFactorial) {
			answer = Calculator.getFactorial(num1);
			symbol = '!';
			setLabelMessage("" + num1 + symbol + "=");
			setLabelAnswer("" + answer);
			
		}
		else if(e.getSource() == btnFloor) {
			answer = Calculator.findFloor(num1);
			setLabelMessage("The floor of " + num1 + "=");
			setLabelAnswer("" + answer);
		}
		else if(e.getSource() == btnMultiply) {
			answer = Calculator.multiplyNumbers(num1, num2);
			symbol = '*';
			setLabelMessage("" + num1 + symbol + num2 + "=");
			setLabelAnswer("" + answer);
		}
		else if(e.getSource() == btnPower) {
			answer = Calculator.numberToPower(num1, num2);
			symbol = '^';
			setLabelMessage("" + num1 + symbol + num2 + "=");
			setLabelAnswer("" + answer);
		}
		else if(e.getSource() == btnSqRoot) {
			answer = Calculator.squareRootNumber(num1);
			setLabelMessage("The sq root of " + num1 + "=");
			setLabelAnswer("" + answer);
		}
		else if(e.getSource() == btnSubtract) {
			answer = Calculator.subtractNumbers(num1, num2);
			symbol = '-';
			setLabelMessage("" + num1 + symbol + num2 + "=");
			setLabelAnswer("" + answer);
		}
		else {
			tfNum1.setText("");
			tfNum2.setText("");
			lblAnswer.setText("?");
			tfNum1.requestFocus();
			return;
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
