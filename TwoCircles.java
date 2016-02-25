/*Write a program that prompts the user to enter the center coordinates 
 * and radius of two circles. The program displays the circles and a text 
 * indicating whether the two are overlapping, whether one is contained 
 * in the other, or whether they don't overlap.
 */

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TwoCircles extends Application {
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		Pane pane = new Pane();
		
		// Call the getProperties() method to get circle dimensions from user
		double[] circleProperties = getProperties();
		
		// Assign array indices to recognizable variables
		double circle1X = circleProperties[0];
		double circle1Y = circleProperties[1];
		double circle1Radius = circleProperties[2];
		double circle2X = circleProperties[3];
		double circle2Y = circleProperties[4];
		double circle2Radius = circleProperties[5];

		// Create the first circle and set its properties
		Circle circle1 = new Circle();
		circle1.centerXProperty().set(circle1X);
		circle1.centerYProperty().set(circle1Y);
		circle1.setRadius(circle1Radius);
		circle1.setStroke(Color.BLUE);
		circle1.setFill(Color.TRANSPARENT);
		pane.getChildren().add(circle1); // Add circle to the pane
		
		// Create the second circle and set its properties
		Circle circle2 = new Circle();
		circle2.centerXProperty().set(circle2X);
		circle2.centerYProperty().set(circle2Y);
		circle2.setRadius(circle2Radius);
		circle2.setStroke(Color.RED);
		circle2.setFill(Color.TRANSPARENT);
		pane.getChildren().add(circle2); // Add circle to the pane 
		
		/* Check to see whether the two are overlapping, whether one is contained 
		 * in the other, or whether they don't overlap
		 */
		String paneText;
		// Call the distance() method to get the distance between the center points of the two circles
		double distance = distance(circle1X, circle1Y, circle2X, circle2Y);
		if (distance > (circle1Radius + circle2Radius)) {
		    paneText = "The circles do not overlap.";
		}
		else if ((distance + Math.min(circle1Radius, circle2Radius)) < Math.max(circle1Radius, circle2Radius)) {
		    paneText = "One circle contains the other.";
		}
		else{
		   paneText = "The circles overlap.";
		} 
		
		// Create a Text object and place it in the pane
		Text t = new Text();
		t.setTextAlignment(TextAlignment.CENTER);
		t.setX(300);
		t.setY(750);
		t.setText(paneText);
		t.setFill(Color.BLACK);
		t.setFont(Font.font(null, FontWeight.BOLD, 14));
		pane.getChildren().add(t);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 800, 800);
		primaryStage.setTitle("Problem 5"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private double[] getProperties() {
		
		double[] circles = new double[6];
		
		JTextField field1 = new JTextField();  
		JTextField field2 = new JTextField();  
		JTextField field3 = new JTextField();  
		JTextField field4 = new JTextField();  
		JTextField field5 = new JTextField();
		JTextField field6 = new JTextField();
		Object[] message = {  
		    "Circle 1 x-coordinate:", field1,  
		    "Circle 1 y-coordinate:", field2,  
		    "Circle 1 radius:", field3,  
		    "Circle 2 x-coordinate:", field4,  
		    "Circle 2 y-coordinate:", field5,  
		    "Circle 2 radius:", field6 
		};  
		int option = JOptionPane.showConfirmDialog(null, message, "Enter all of your values", JOptionPane.OK_CANCEL_OPTION);  
		if (option == JOptionPane.OK_OPTION)  
		{  
		    circles[0] = Double.parseDouble(field1.getText());  
		    circles[1] = Double.parseDouble(field2.getText());
		    circles[2] = Double.parseDouble(field3.getText());  
		    circles[3] = Double.parseDouble(field4.getText());  
		    circles[4] = Double.parseDouble(field5.getText()); 
		    circles[5] = Double.parseDouble(field6.getText());
		}
		return circles;
	}
	
	// A method to calculate the distance between two points
	public double distance(double c1x, double c1y, double c2x, double c2y){
		return Math.sqrt(Math.pow(c2x - c1x, 2) + Math.pow(c2y - c1y, 2));
	}

	public static void main(String[] args) {		
		launch();
	}

}
