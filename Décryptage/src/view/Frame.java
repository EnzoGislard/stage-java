package view;

import java.awt.Color;

import javax.swing.JFrame;

import model.Model;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private LoadPanel loadPanel;

	/**
	 * This constructor set the size of the home window, his color and put a panel
	 * into it
	 */
	public Frame(Model model) {

		this.setTitle("Home");
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);

		this.loadPanel = new LoadPanel(model);

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
