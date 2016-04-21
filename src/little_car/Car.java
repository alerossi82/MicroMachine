package little_car;

import java.awt.Color;
import java.awt.Graphics;
import java.io.ObjectInputStream.GetField;

/**
 * This class defines the Car object
 * 
 */

public class Car extends Components {

	/**
	 * 
	 * Constructor (inherited by the superclass)
	 */
	public Car(Integer xPos, Integer yPos, Integer width, Integer height) {
		super(xPos, yPos, width, height);
	}

	/**
	 * This method draws the Car object
	 * 
	 */
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(getxPos(), getyPos(), getWidth(), getHeight());
	}
}