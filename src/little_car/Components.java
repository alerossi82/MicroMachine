package little_car;

import java.awt.Graphics;

/**
 * This is the superclass for Car and Obstacle
 *
 * The four attributes define the coordinates of the shape to be filled (xPos,
 * yPos) and its dimensions (width, height)
 * 
 * All attributes are private and child classes can access them only through the
 * Accessors methods
 * 
 */

public class Components {
	private Integer xPos;
	private Integer yPos;
	private Integer width;
	private Integer height;

	/**
	 * Constructor
	 */
	public Components(Integer xPos, Integer yPos, Integer width, Integer height) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}

	/**
	 * Accessors for all attributes
	 */
	public Integer getxPos() {
		return xPos;
	}

	public void setxPos(Integer xPos) {
		this.xPos = xPos;
	}

	public Integer getyPos() {
		return yPos;
	}

	public void setyPos(Integer yPos) {
		this.yPos = yPos;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * This is the method assigned to the right key arrow
	 * 
	 * If the x-position of the object is <420 (Panel's width), this method
	 * increases the x-position for its width
	 * 
	 * 
	 */
	public void move_right() {
		if (getxPos() < 420)
			setxPos(getxPos() + getWidth());
	}

	/**
	 * This method is assigned to the left key arrow
	 * 
	 * This method decreases the x-position of Object for its width, until a
	 * minimum of 0
	 * 
	 * 
	 */
	public void move_left() {
		setxPos(getxPos() - getWidth());
		if (getxPos() < 0) {
			setxPos(0);
		}
	}

	/**
	 * This method increases the y-position of an object for its width
	 */
	public void move_down() {
		setyPos(getyPos() + getWidth());
	}
}