package view;

import java.awt.Color;

import javax.swing.JFrame;

import controller.Controller;

public class ViewFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private ViewLoginPanel loginPanel;
	private ViewDecryptPanel decryptPanel;
	
	final int FRAME_WIDTH = 600;
	final int FRAME_HEIGHT = 300;

	/**
	 * This constructor set the size of the home window, his color and put a panel
	 * into it
	 */
	public ViewFrame(Controller controller) {
		

		this.setTitle("Let's decrypt!");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);

		this.loginPanel = new ViewLoginPanel(controller, this);
		this.decryptPanel = new ViewDecryptPanel(controller, this);

		this.setContentPane(this.loginPanel);
		//this.setContentPane(this.chooseFPanel);
		this.requestFocus();

		this.setVisible(true);
	}



	public ViewLoginPanel getLoadPanel() {
		return loginPanel;
	}
	
	public ViewDecryptPanel getChooseFPanel() {
		return decryptPanel;
	}

	public void setLoadPanel(ViewLoginPanel pan) {
		loginPanel = pan;
	}
	public void setChooseFPanel(ViewDecryptPanel an) {
		decryptPanel = an;
	}


}
