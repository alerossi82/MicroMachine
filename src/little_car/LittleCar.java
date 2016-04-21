package little_car;

import java.awt.EventQueue;

/**
 * 
 * @author Alessandro
 * 
 *         This is a Swing-based GUI that emulates a simple game where a car
 *         (represented by a red rectangle) tries to avoid obstacles (represeted
 *         by blue squares) that appear randomly from the upper edge of the
 *         screen. The car can be moved horizontally using the left-right arrow
 *         keys; if the car and an obstacle collide, the car and the obstacles
 *         stops and a blinking GAME OVER label pops-up. Below this, two label
 *         would pop-up, prompting the player to press Enter to start a new game
 *         or Esc to terminate the application
 * 
 *
 */
public class LittleCar {
	/**
	 * This is the main thread
	 * 
	 * The run() method creates the frame (from the Little_car_frame class) and
	 * set it as visible.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Little_car_frame frame = new Little_car_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
