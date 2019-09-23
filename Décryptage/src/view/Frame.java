package view;

import java.awt.Color;

import javax.swing.JFrame;

import controller.Controller;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private LoadPanel loadPanel;
	
	final int FRAME_WIDTH = 600;
	final int FRAME_HEIGHT = 300;

	/**
	 * This constructor set the size of the home window, his color and put a panel
	 * into it
	 */
	public Frame(Controller controller) {
		

		this.setTitle("Home");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);

		this.loadPanel = new LoadPanel(controller);

		this.setContentPane(this.loadPanel);
		this.requestFocus();

		this.setVisible(true);
	}



	public LoadPanel getLoadPanel() {
		return loadPanel;
	}

	public void setLoadPanel(LoadPanel pan) {
		loadPanel = pan;
	}

}
