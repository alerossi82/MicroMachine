package little_car;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * This class creates a blinking label
 *
 */
public class BlinkLabel extends JLabel {
	private static final int BLINKING_RATE = 500;
	private boolean blinkingOn = true;
	private Timer timer;

	/**
	 * Constructor
	 * 
	 * @param text
	 *            the text in the label
	 * 
	 *            A timer is created to produce a blinking effect for the
	 *            label's text
	 * 
	 *            The timer is started upon creation of the label
	 * 
	 */
	public BlinkLabel(String text) {
		super(text);
		setBackground(Color.BLACK);
		setForeground(Color.YELLOW);
		timer = new Timer(BLINKING_RATE, new TimerBlinkLabel(this));
		timer.setInitialDelay(0);
		timer.start();
	}

	/**
	 * This method defines the ActionListener for the Timer
	 * 
	 *
	 */
	private class TimerBlinkLabel implements ActionListener {

		private BlinkLabel bl;
		private Color bg;
		private Color fg;
		private boolean isForeground;

		/**
		 * Constructor
		 * 
		 */
		public TimerBlinkLabel(BlinkLabel bl) {
			this.bl = bl;
			fg = bl.getForeground();
			bg = bl.getBackground();
		}

		/**
		 * This method defines the action triggered by the Timer
		 * 
		 * The method checks the boolean variable isForeground and if is false
		 * changes the color of the text to the same color of the background
		 * (and vice-versa if true); each time, the boolean variable is inverted
		 * -this creates a blinking effect
		 */
		public void actionPerformed(ActionEvent e) {
			if (isForeground) {
				bl.setForeground(fg);
			} else {
				bl.setForeground(bg);
			}
			isForeground = !isForeground;
		}
	}

}