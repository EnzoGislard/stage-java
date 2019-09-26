package view;

import java.awt.Color;

import javax.swing.JFrame;

import controller.Controller;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private LoginPanel loadPanel;
	private DecryptPanel chooseFPanel;
	
	final int FRAME_WIDTH = 600;
	final int FRAME_HEIGHT = 300;

	/**
	 * This constructor set the size of the home window, his color and put a panel
	 * into it
	 */
	public Frame(Controller controller) {
		

		this.setTitle("Let's decrypt!");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);

		this.loadPanel = new LoginPanel(controller, this);
		this.chooseFPanel = new DecryptPanel(controller, this);

		this.setContentPane(this.loadPanel);
		//this.setContentPane(this.chooseFPanel);
		this.requestFocus();

		this.setVisible(true);
	}



	public LoginPanel getLoadPanel() {
		return loadPanel;
	}
	
	public DecryptPanel getChooseFPanel() {
		return chooseFPanel;
	}

	public void setLoadPanel(LoginPanel pan) {
		loadPanel = pan;
	}
	public void setChooseFPanel(DecryptPanel an) {
		chooseFPanel = an;
	}


}
