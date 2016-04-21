package little_car;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Alessandro
 * 
 *         This class creates the JFrame.
 *
 */
public class Little_car_frame extends JFrame {
	/**
	 * The frame is set as non resizable.
	 * 
	 * A new JPanel is created (from class Little_car_panel ) and added to the
	 * JFrame.
	 */
	public Little_car_frame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().add(new Little_car_panel());
	}
}
