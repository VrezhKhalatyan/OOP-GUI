package lab8;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MultiplicationTable extends Application {
	private int result;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane bp = new BorderPane();
		bp.getStyleClass().add("grid");

		GridPane gp = new GridPane();

		primaryStage.setTitle("Reverse Multiplication Table");
		
		Label title = new Label("Reverse Multiplication Table");
		title.getStyleClass().add("title");

		Label enterAnswerLabel = new Label("Enter Answer: ");
		enterAnswerLabel.getStyleClass().add("inputLabel");

		TextField answerChosen = new TextField("0");
		answerChosen.getStyleClass().add("answerLabel");

		Label columnLeft = new Label();
		columnLeft.getStyleClass().add("columnleft");

		Label topRow = new Label();
		topRow.getStyleClass().add("topRow");

		Button b = new Button("Find Problems");
		b.getStyleClass().add("button");
		
		HBox titleBox = new HBox();
		titleBox.getStyleClass().add("titleBox");
		titleBox.getChildren().add(title);
		titleBox.setAlignment(Pos.CENTER);

		HBox inputCounterBox = new HBox();
		inputCounterBox.getStyleClass().add("inputBox");
		inputCounterBox.getChildren().add(enterAnswerLabel);
		inputCounterBox.getChildren().add(answerChosen);
		inputCounterBox.getChildren().add(b);

		for (int i = 0; i < 1; i++)
			for (int j = 0; j < 11; j++) {
				Label topLabel = new Label();
				topLabel.getStyleClass().add("topLabel");
				topLabel.setPrefHeight(50);
				topLabel.setPrefWidth(50);
				topLabel.setAlignment(Pos.CENTER);
				topLabel.setText("" + j + "");
				gp.add(topLabel, j, i);
			}
		for (int k = 1; k < 11; k++)
			for (int l = 0; l < 1; l++) {
				Label leftLabel = new Label();
				leftLabel.getStyleClass().add("leftLabel");
				leftLabel.setPrefHeight(50);
				leftLabel.setPrefWidth(50);
				leftLabel.setAlignment(Pos.CENTER);
				leftLabel.setText(" " + k + " ");
				gp.add(leftLabel, l, k);
			}

		for (int rowCounter = 1; rowCounter < 11; rowCounter++)
			for (int colCounter = 1; colCounter < 11; colCounter++) {
				Label centerLabel = new Label();
				centerLabel.getStyleClass().add("centerLabel");
				centerLabel.setPrefHeight(50);
				centerLabel.setPrefWidth(50);
				centerLabel.setAlignment(Pos.CENTER);
				int answer = rowCounter * colCounter;
				centerLabel.setText(rowCounter + " * " + colCounter);
				gp.add(centerLabel, colCounter, rowCounter);

				b.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {

					Boolean clicked = false;

					@Override
					public void handle(Event arg0) {
						if (clicked == true) {
							clicked = false;
							result = Integer.parseInt(answerChosen.getText());
							if(result == answer)
							centerLabel.getStyleClass().add("highlight");
						}
						else{
							clicked = true;
							centerLabel.getStyleClass().remove("highlight");
						}

					}

				});
			}

		Scene sc = new Scene(bp);
		sc.getStylesheets().add("styles/style.css");

		bp.setTop(titleBox);
		bp.setCenter(inputCounterBox);
		bp.setBottom(gp);

		primaryStage.setScene(sc);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
