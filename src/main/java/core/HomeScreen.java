package core;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomeScreen extends Application {
	
	private Button solnBtn;
	private TextField leftOperandTxtBox;
	private TextField rightOperandTxtBox;
	private TextField answerTxBox;
	private ComboBox<String> operatorDropdown;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		initUI(primaryStage);	
		
	}

	private void initUI(Stage primaryStage) {
		Pane canvas = new Pane();
		
		canvas.setStyle("-fx-background-color:white");
		
		addControlToCanvas(canvas);
		
		Scene scene = new Scene(canvas, 320,200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple Calculator APP");
		primaryStage.show();
		
	}

	private void addControlToCanvas(Pane canvas) {
		int row1 = 20;
		int row2 = 60;
		int txtBoxWidth = 50;
		
		Label label = new Label("Simaple Calculator using JavaFX");
		label.setFont(Font.font("serif", FontWeight.NORMAL,20));
		label.relocate(20, 20);
		
		leftOperandTxtBox = new TextField();
		leftOperandTxtBox.setMaxWidth(txtBoxWidth);
		leftOperandTxtBox.relocate(20, row2);
		
		operatorDropdown = new ComboBox<String>();
		operatorDropdown.getItems().addAll("+","-","x","/","%");
		operatorDropdown.setValue("+");
		operatorDropdown.relocate(80, row2);
		
		
		rightOperandTxtBox = new TextField();
		rightOperandTxtBox.setMaxWidth(txtBoxWidth);
		rightOperandTxtBox.relocate(150, row2);
		
		solnBtn = new Button("=");
		solnBtn.relocate(210, row2);
		
		
		answerTxBox = new TextField();
		answerTxBox.setMaxWidth(txtBoxWidth);
		answerTxBox.setEditable(false);
		answerTxBox.relocate(250, row2);
		
		setSolnBtnClickHandler();
		
		
		canvas.getChildren().addAll(label,leftOperandTxtBox,rightOperandTxtBox,operatorDropdown,solnBtn,answerTxBox);
	}

	private void setSolnBtnClickHandler() {
		solnBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Double leftOperand = Double.valueOf(leftOperandTxtBox.getText());
				Double rightOperand = Double.valueOf(rightOperandTxtBox.getText());
				String operator = operatorDropdown.getValue();
				
				ArithmeticSolver solver = new ArithmeticSolver();
				String answer = String.valueOf(solver.solve(operator,leftOperand,rightOperand));
				
				answerTxBox.setText(answer);
				
			}
			
		});
		
	}

}
