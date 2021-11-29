/*
*	Shapes.java    
*
*	To display and manipulate polygons sides according to user input 
*
*	v1.0
*
*	23/11/21
*/

package shapes;

import conversion.Converters;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Shapes extends Application {

	private int minSides = 4; // Minimum sides for a polygon
	private int maxSides = 8; // Maximum sides for a polygon
	private int userNumber; // Holds the conversion of user input from string to integer
	private int winSize = 750; // The initial window size
	private double polySize = winSize * 0.33; // Links polygon size to a portion of the window size

	@Override
	public void start(Stage stage) {

		// POLYGONS - Instantiates needed polygon objects
		Regular poly4 = new Regular();
		Regular poly5 = new Regular();
		Regular poly6 = new Regular();
		Regular poly7 = new Regular();
		Regular poly8 = new Regular();

		// POLYGONS - Group to which polygons are added and removed for display
		VBox centerGroup = new VBox();
		centerGroup.setAlignment(Pos.CENTER); // Aligns shapes in the center

		// POLYGONS - Fade in effect for polygons added to the centerGroup
		FadeTransition fadeIn = new FadeTransition();
		fadeIn.setNode(centerGroup); // Fade effect for the centerGroup only
		fadeIn.setDuration(Duration.millis(700));
		fadeIn.setFromValue(0); // Start opacity
		fadeIn.setToValue(1); // End opacity

		// USER NODES - Adds new text field to accept user input from keyboard
		TextField userInput = new TextField();
		userInput.setMaxWidth(103);

		// USER NODES - Adds new text label to instruct users
		Label userPrompt = new Label();
		userPrompt.setText("Please enter an integer between 4 and 8");

		// USER NODES - Adds new text label to display user input errors
		Label userError = new Label();
		userError.setTextFill(Color.RED);

		// BUTTONS - Adds create button and actions to draw polygons
		Button userCreate = new Button();
		userCreate.setText("Create polygon");
		userCreate.setOnAction(e -> {
			try {
				userNumber = Converters.convertStrInt(userInput.getText()); // Converts input to int and sets variable
				if (userInput.getText().isEmpty() || userNumber < minSides || userNumber > maxSides) { // Validates input
					userError.setText(
							"Error 1x1: No valid integer entered. Please enter a valid integer between "
							+ minSides + " and " + maxSides);
				} else {
					userError.setText(""); // Clears any error message on validated input
					switch (userNumber) {
					case 4:
						centerGroup.getChildren().clear();
						poly4.drawSides(polySize, userNumber); // Draws/redraws the polygon from the user input
						centerGroup.getChildren().add(poly4);
						fadeIn.play();
						break;

					case 5:
						centerGroup.getChildren().clear();
						poly5.drawSides(polySize, userNumber); // Draws/redraws the polygon from the user input
						centerGroup.getChildren().add(poly5);
						fadeIn.play();
						break;

					case 6:
						centerGroup.getChildren().clear();
						poly6.drawSides(polySize, userNumber); // Draws/redraws the polygon from the user input
						centerGroup.getChildren().add(poly6);
						fadeIn.play();
						break;

					case 7:
						centerGroup.getChildren().clear();
						poly7.drawSides(polySize, userNumber); // Draws/redraws the polygon from the user input
						centerGroup.getChildren().add(poly7);
						fadeIn.play();
						break;

					case 8:
						centerGroup.getChildren().clear();
						poly8.drawSides(polySize, userNumber); // Draws/redraws the polygon from the user input
						centerGroup.getChildren().add(poly8);
						fadeIn.play();
						break;

					default: // Default clause to prevent a fall through error if switch cases are expanded
						userError.setText(
									"Error 1x2: Number cannot be lower than " + minSides + " or higher than "
											+ maxSides + ". Please enter a valid integer between " + minSides
											+ " and " + maxSides);
						break;
					}
				}
			} catch (NumberFormatException validateInput) { // Checks if a decimal or string has been entered
				userError.setText(
						"Error 1x3: No valid integer entered. Please enter a valid integer between "
								+ minSides + " and " + maxSides);

			}
		});

		// BUTTONS - Adds increment button and action to grow the polygon
		Button userAdd = new Button();
		userAdd.setText("+");
		userAdd.setPrefWidth(30);
		userAdd.setPrefHeight(winSize);
		userAdd.setOnAction(a -> {
			if (userInput.getText().isBlank() || userNumber < minSides || userNumber > maxSides) { // Validates input
				userError.setText(
						"Error 2x1: Initial shape not created. Please create a shape before trying to add sides");
			} else {
				userError.setText(""); // Clears error message on validated input
				if (userNumber < maxSides) { // Checks maximum sides won't be exceeded on next click
					userNumber++; // Increments the user number
					userInput.setText(Converters.convertIntStr(userNumber)); // Updates the displayed text box number
					if (centerGroup.getChildren().contains(poly4)) {
						poly4.drawSides(polySize, userNumber); // Redraws polygon with the incremented number
					} else if (centerGroup.getChildren().contains(poly5)) {
						poly5.drawSides(polySize, userNumber); // Redraws polygon with the incremented number
					} else if (centerGroup.getChildren().contains(poly6)) {
						poly6.drawSides(polySize, userNumber); // Redraws polygon with the incremented number
					} else if (centerGroup.getChildren().contains(poly7)) {
						poly7.drawSides(polySize, userNumber); // Redraws polygon with the incremented number
					} else if (centerGroup.getChildren().contains(poly8)) {
						poly8.drawSides(polySize, userNumber); // Redraws polygon with the incremented number
					}
				} else {
					userError.setText(
							"Error 2x2: Cannot increase beyond " + maxSides
									+ " sides. Please decrease or create a new shape");
				}
			}
		});

		// BUTTONS - Adds decrement button and action to shrink the polygon
		Button userMinus = new Button();
		userMinus.setText("-");
		userMinus.setPrefWidth(30);
		userMinus.setPrefHeight(winSize);
		userMinus.setOnAction(a -> {
			if (userInput.getText().isBlank() || userNumber < minSides || userNumber > maxSides) { // Validates input
				userError.setText(
						"Error 3x1: Initial shape not created. Please create a shape before trying to remove sides");
			} else {
				userError.setText(""); // Clears error message on validated input
				if (userNumber > minSides) { // Checks minimum sides won't be exceeded on next click
					userNumber--; // Increments the user number
					userInput.setText(Converters.convertIntStr(userNumber)); // Updates the displayed text box number
					if (centerGroup.getChildren().contains(poly4)) {
						poly4.drawSides(polySize, userNumber); // Redraws polygon with the incremented number
					} else if (centerGroup.getChildren().contains(poly5)) {
						poly5.drawSides(polySize, userNumber); // Redraws polygon with the incremented number
					} else if (centerGroup.getChildren().contains(poly6)) {
						poly6.drawSides(polySize, userNumber); // Redraws polygon with the incremented number
					} else if (centerGroup.getChildren().contains(poly7)) {
						poly7.drawSides(polySize, userNumber); // Redraws polygon with the incremented number
					} else if (centerGroup.getChildren().contains(poly8)) {
						poly8.drawSides(polySize, userNumber); // Redraws polygon with the incremented number
					}
				} else {
					userError.setText(
							"Error 3x2: Cannot decrease below " + minSides
									+ " sides. Please increase or create a new shape");
				}
			}
		});

		// CONTAINERS - HBox to hold the input field and button
		HBox inputFields = new HBox();
		inputFields.setSpacing(10);
		inputFields.setAlignment(Pos.CENTER);
		inputFields.getChildren().addAll(userInput, userCreate);

		// CONTAINERS - VBox to control prompt input error order
		VBox inputPrompts = new VBox();
		inputPrompts.setSpacing(10);
		inputPrompts.setPrefHeight(100);
		inputPrompts.setAlignment(Pos.CENTER);
		inputPrompts.getChildren().addAll(userPrompt, inputFields, userError);

		// CONTAINERS - BorderPane to provide root layout
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20, 20, 20, 20));
		root.setTop(inputPrompts);
		root.setLeft(userMinus);
		root.setRight(userAdd);
		root.setCenter(centerGroup);
		root.setStyle("-fx-background-color: whitesmoke;");

		// SCENE - Creates a new scene
		Scene scene = new Scene(root, winSize, winSize); // Scene height and width from variable

		// STAGE - Adds the scene to the stage and make visible
		stage.setScene(scene);
		stage.setTitle("Shape Generator");
		stage.show();
	}

	// MAIN - Program starts here
	public static void main(String[] args) {

		launch(args);
	}
}