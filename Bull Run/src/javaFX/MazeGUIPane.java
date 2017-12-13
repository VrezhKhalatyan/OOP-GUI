package javaFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import runningOfTheBulls.StreetMap;

public class MazeGUIPane extends Application {
	private GridPane grid = new GridPane();
	private BorderPane border = new BorderPane();
	private Scene sc = new Scene(border);
	public Label[][] labelGridArray = new Label[20][20];
	private StreetMap map = new StreetMap();
	int col;
	int row;

	public void start(Stage primary) {

		sc.getStylesheets().add("styles/style.css");
		grid.getStyleClass().add("grid-style");
		border.getStyleClass().add("border-style");
		Label mainTitle = new Label("Map Of Pamplona");
		mainTitle.getStyleClass().add("white-text");
		Button butt = new Button("RUN!");
		VBox vBox = new VBox();
		HBox buttHBox = new HBox();
		HBox titleBox = new HBox();
		VBox titleVBox = new VBox();
		VBox buttVBox = new VBox();

		map.makeGrid();

		for (col = 0; col < 20; col++) {
			for (row = 0; row < 20; row++) {
				Label square = new Label();
				if (map.gridArray[col][row].getValue() == ' ') {
					square.getStyleClass().add("default-box");
				} else if (map.gridArray[col][row].getValue() == 'S') {
					square.setText("Start");
					square.getStyleClass().add("start-end");
				} else if (map.gridArray[col][row].getValue() == 'E') {
					square.setText("End");
					square.getStyleClass().add("start-end");
				} else {
					square.getStyleClass().add("wall");
				}

				square.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent t) {
						row = grid.getRowIndex(square);
						col = grid.getColumnIndex(square);
						if (map.gridArray[col][row].getValue() == 'W') {
							square.getStyleClass().removeAll("wall");
							square.getStyleClass().add("default-box");
							map.gridArray[col][row].setTier(row);
							map.gridArray[col][row].setColumn(col);
							map.gridArray[col][row].setValue(' ');
						} else {
							square.getStyleClass().removeAll("default-box");
							square.getStyleClass().add("wall");
							map.gridArray[col][row].setTier(row);
							map.gridArray[col][row].setColumn(col);
							map.gridArray[col][row].setValue('W');
						}
					}
				});

				labelGridArray[col][row] = square;
				grid.add(square, col, row);
			}
		}
		titleBox.getStyleClass().add("title");
		titleBox.getChildren().add(mainTitle);
		titleVBox.getChildren().add(titleBox);

		buttHBox.getStyleClass().add("button-style");
		buttHBox.getChildren().add(butt);
		buttVBox.getChildren().add(buttHBox);

		vBox.getChildren().add(grid);

		border.setTop((titleBox));
		border.setCenter(vBox);
		border.setBottom(buttVBox);

		primary.setScene(sc);
		primary.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
