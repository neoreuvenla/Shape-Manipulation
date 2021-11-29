/*
*	RegularPolygon.java    
*
*	To calculate the coordinates needed to create 2D Polygons 
*
*	v1.0
*
*	23/11/21
*/

package shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Regular extends Polygon {

	private double centerX = 0.0; // Horizontal centre
	private double centerY = 0.0; // Vertical centre
	private double radius; // Passed in polygon radius
	private int sides; // Passed in polygon sides
	private double angles = 0; // Shape rotation
	private double vertices; // Vertex calculation

	// Constructor
	public Regular() {
		super(); // Polygon constructor
	}

	// Method to calculate, draw or resize polygon sides with color adjustment
	public void drawSides(double radiusIn, int sidesIn) {
		radius = radiusIn;
		sides = sidesIn;
		vertices = Math.PI * 2 / sides; // Calculates the size of the vertices

		setColor(); // Method sets polygon for new amount of sides color
		super.getPoints().clear(); // Clears any existing points
		for (int i = 0; i < sides; i++, angles += vertices) { // Increases the vertex angle each loop
			getPoints().addAll(
					centerX + radius * Math.sin(angles), // Calculates the x coordinate
					centerY + radius * Math.cos(angles)); // Calculates the y coordinate
		}
	}

	// Method to set polygon color
	public void setColor() {
		if (isEven()) {
			setFill(Color.valueOf("F5BB1C")); // Yellow if even
		} else {
			setFill(Color.valueOf("2B9348")); // Green if odd
		}
	}

	// Method to determine odd/even sides
	public boolean isEven() {
		return sides % 2 == 0; // No decimal result returns true result
	}
}