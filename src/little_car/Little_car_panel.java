package little_car;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.SwingConstants;

import java.awt.Font;

/**
 * 
 * @author Alessandro
 *
 *         This class creates the JPanel, containing the following objects:
 * 
 *         - a Car object; - a list of Obstacle objects; - a timer, responsible
 *         for adding new Obstacle objects in the list and moving them down -
 *         Integers car1Xpos. car1Ypos, width and car1height, setting the
 *         initial coordinates and sizes of the Car object - Integer
 *         obstacleYpos, setting the initial Y-position of each Obstacle objects
 *         (the Obstacle is initially created width pixels above the upper edge)
 *         - a label from the BlinkLabel class (blinking GAME OVER), popping up
 *         once an Obstacle impacts the Car - two JLabels
 *         "Press Enter to play again" and "Press Esc to quit",popping up once
 *         an Obstacle impacts the Car (below GAME OVER) - a Random that will
 *         randomly set the starting x-position of the Obstacles
 * 
 */
public class Little_car_panel extends JPanel {

	private Car car1;
	private Timer timer1;
	private ArrayList<Obstacle> list1;
	private Integer car1Xpos;
	private Integer car1Ypos;
	private Integer width;
	private Integer car1height;
	private Integer obstacleYpos;
	private BlinkLabel label1;
	private JLabel label2;
	private JLabel label3;
	private Random rand1;

	/**
	 * This method is the constructor for this class
	 * 
	 * - All variables are initialized
	 * 
	 * - Panel's layout, background color and borders are defined; the panel is
	 * set as Focusable so that it can receive inputs from the KeyListener
	 * 
	 * - JLabel's features are defined and added to the JPanel; they are
	 * initially set as no-visible since they will pop-up only once a collision
	 * takes place
	 * 
	 * - Timer's delay is set up and its ActionListener is added (defined in the
	 * private class TimerObstacles); timer1 is started upon creation of the
	 * JPanel
	 * 
	 * - a KeyListener is added to the JPanel (defined in the private class
	 * KeyCommands)
	 */
	public Little_car_panel() {

		car1Xpos = 225;
		car1Ypos = 220;
		width = 20;
		car1height = 40;
		list1 = new ArrayList<Obstacle>();
		rand1 = new Random();
		obstacleYpos = -20;
		car1 = new Car(car1Xpos, car1Ypos, width, car1height);

		setLayout(null);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setFocusable(true);

		label1 = new BlinkLabel("Game over");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(140, 98, 152, 51);
		label1.setFont(new Font("Impact", Font.PLAIN, 30));
		label1.setOpaque(true);
		label1.setVisible(false);
		add(label1);

		label2 = new JLabel("Press Enter to play again");
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		label2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 20));
		label2.setForeground(Color.YELLOW);
		label2.setBackground(Color.BLACK);
		label2.setBounds(96, 176, 245, 29);
		label2.setOpaque(true);
		label2.setVisible(false);
		add(label2);

		label3 = new JLabel("Press Esc to quit");
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		label3.setForeground(Color.YELLOW);
		label3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 20));
		label3.setBackground(Color.BLACK);
		label3.setBounds(140, 214, 172, 29);
		label3.setOpaque(true);
		label3.setVisible(false);
		add(label3);

		timer1 = new Timer(500, new TimerObstacles());
		timer1.start();

		addKeyListener(new KeyCommands());
	}

	/**
	 * This is the paint method
	 * 
	 * It calls the draw method from classes Car and Obstacle
	 * 
	 * repaint() draws Car and all Obstacles in their new position each time
	 * 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		car1.draw(g);
		for (Obstacle obstacle : list1) {
			obstacle.draw(g);
		}
		repaint();

	}

	/**
	 * This method checks the position of Car and each Obstacle.
	 * 
	 * If the following conditions apply simultaneously, the timer stops and the
	 * JLabels pop-up:
	 * 
	 * - the left side of any Obstacle (obstacleX1) is more to the left of the
	 * right side of Car (carX2) AND
	 * 
	 * - the right side of the same Obstacle (obstacleX2) is more to the right
	 * of the left side of Car (carX1) AND
	 * 
	 * - the lower side of the same Obstacle (obstacleY) is between the lower
	 * and upper side of CAR (carY1 and carY2)
	 * 
	 */
	public void check_collision() {
		Integer carX1 = car1.getxPos();
		Integer carX2 = carX1 + car1.getWidth();
		Integer carY1 = car1.getyPos();
		Integer carY2 = carY1 + car1.getHeight();
		for (Obstacle obstacle : list1) {
			Integer obstacleX1 = obstacle.getxPos();
			Integer obstacleX2 = obstacleX1 + obstacle.getWidth();
			Integer obstacleY = obstacle.getyPos() + obstacle.getWidth();
			if (((obstacleX1 <= carX2 && obstacleX2 >= carX1)) && ((obstacleY >= carY1 && obstacleY <= carY2))) {
				timer1.stop();
				label1.setVisible(true);
				label2.setVisible(true);
				label3.setVisible(true);

			}

		}
	}

	/**
	 * The KeyListener is created in a private class
	 *
	 * If the timer is running, every time the car is moved right/left, the
	 * check_collision() method is invoked
	 *
	 * If the timer is not running, it is possible to press Esc (to terminate
	 * the application) or Enter: this will delete all Obstacle objects, set the
	 * labels as not visible, reset the starting position of Car and re-start
	 * the timer
	 *
	 *
	 */
	private class KeyCommands implements KeyListener {

		public void keyPressed(KeyEvent e) {
			Integer key = e.getKeyCode();
			if (timer1.isRunning()) {
				if (key == KeyEvent.VK_LEFT) {
					car1.move_left();
					check_collision();
				}

				if (key == KeyEvent.VK_RIGHT) {
					car1.move_right();
					check_collision();
				}
			} else {
				if (key == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}

				if (key == KeyEvent.VK_ENTER) {
					list1.clear();
					label1.setVisible(false);
					label2.setVisible(false);
					label3.setVisible(false);
					car1.setxPos(225);
					timer1.start();
				}
			}
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}
	}

	/**
	 * The ActionListener for the timer is created in a private class
	 * 
	 * The ActionListener defines what happens every delay-milliseconds defined
	 * in the timer:
	 *
	 * - a new number between 0 and 420 (JPanel's width) is randomly generated
	 *
	 * - a new Obstacle with x-position defined by the randomly-generated number
	 * is created and added to list1
	 *
	 * - the move_down() method is invoked on all Obstacles inside list1
	 *
	 * - the check_collision() method is invoked
	 */
	private class TimerObstacles implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Integer obstacleXpos = rand1.nextInt(420);
			list1.add(new Obstacle(obstacleXpos, obstacleYpos, width, width));
			for (Obstacle obstacle : list1) {
				obstacle.move_down();
				check_collision();
			}
		}
	}

}