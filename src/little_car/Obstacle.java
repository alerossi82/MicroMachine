package little_car;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class defines the Obstacle objects
 *
 */

public class Obstacle extends Components {

	/**
	 * Constructor (inherited by the superclass)
	 */
	public Obstacle(Integer xPos, Integer yPos, Integer width, Integer height) {
		super(xPos, yPos, width, height);
	}

	/**
	 * This method draws the Obstacle
	 */
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(getxPos(), getyPos(), getWidth(), getWidth());
	}

}