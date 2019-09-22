package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;

public class IHMPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Model model;
	private Font font = new Font("Serif", Font.CENTER_BASELINE, 20);
	
	
	public int drawLigne = 0;
	public int change_back = 0;
	public int drawData = 0;
	public int drawPoints = 0;
	public int draw_back = 1;
	public int initEnd = 0;

	public int counterInitX = 100;
	public int counterInitY = 700;

	public int counterPointX = -700;
	public int conterPointYTemp = 700;
	public int counterPointYHum = 700;

	public Label order;
	public Label temperature;
	public Label humidity;
	public Label rosee;

	public Label temperatureMax;
	public Label humidityMax;
	public Label tempTimeMax;
	public Label tempHumMax;

	public final JTextField orderText;
	public Button send;
	public Button start;
	public Button stop;
	

	/**
	 * This constructor create a button into the panel and load an image into it
	 */
	public IHMPanel(Model model) {

		this.setLayout(null);

		this.setModel(model);

		temperature = new Label("Température :");
		humidity = new Label("Humidité :");
		rosee = new Label("Pas de condensation :");
		temperatureMax = new Label("30°C");
		humidityMax = new Label("100 %");
		tempTimeMax = new Label("60 s");
		tempHumMax = new Label("60 s");
		order = new Label("Consigne :");

		orderText = new JTextField(2);
		send = new Button("Envoyer");
		start = new Button("Start");
		stop = new Button("Stop");
		
		//Antoine//
		
		order = configureLabel(order, 100, 800, 100, 50, font, Color.cyan, Label.CENTER, false);
		temperature = configureLabel(temperature, 350, 20, 150, 50, font, Color.yellow, Label.CENTER, false);
		humidity = configureLabel(humidity, 1150, 20, 150, 50, font, Color.yellow, Label.CENTER, false);
		rosee = configureLabel(rosee, 900, 800, 200, 50, font, Color.yellow, Label.CENTER, false);
		
		temperatureMax = configureLabel(temperatureMax, 80, 50, 50, 50, font, Color.black, Label.CENTER, false);
		temperatureMax.setForeground(Color.white);
		
		humidityMax = configureLabel(humidityMax, 880, 50, 50, 50, font, Color.black, Label.CENTER, false);
		humidityMax.setForeground(Color.white);
		
		tempTimeMax = configureLabel(tempTimeMax, 715, 675, 50, 50, font, Color.black, Label.CENTER, false);
		tempTimeMax.setForeground(Color.white);
		
		tempHumMax = configureLabel(tempHumMax, 1515, 675, 50, 50, font, Color.black, Label.CENTER, false);
		tempHumMax.setForeground(Color.white);
		
		orderText.setText("17");
		orderText.setBounds(210, 800, 100, 50);
		orderText.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		orderText.setBackground(Color.cyan);
		orderText.setHorizontalAlignment(JTextField.CENTER);
		orderText.setBorder(null);
		orderText.setVisible(false);

		send = configureButton(send, 340, 800, 100, 50, font, Color.cyan, false);
		start = configureButton(start, 1400, 775, 100, 50, font, Color.cyan, false);
		stop = configureButton(stop, 1400, 825, 100, 50, font, Color.cyan, false);

		add(order);
		add(orderText);
		add(send);
		add(temperature);
		add(humidity);
		add(rosee);
		add(temperatureMax);
		add(humidityMax);
		add(tempTimeMax);
		add(tempHumMax);
		add(start);
		add(stop);
	}

	private Label configureLabel(Label label, int x, int y, int width, int heigh, Font font, Color colorBackground, int alignment, boolean isVisible) {
		label.setBounds(x, y, width, heigh);
		label.setFont(font);
		label.setBackground(colorBackground);
		label.setAlignment(alignment);
		label.setVisible(isVisible);
		
		return label;
	}
	
	private Button configureButton(Button button, int x, int y, int width, int heigh, Font font, Color colorBackground, boolean isVisible) {
		button.setBounds(x, y, width, heigh);
		button.setFont(font);
		button.setBackground(colorBackground);
		button.setVisible(isVisible);
		
		return button;
	}
	
	
	public void paintComponent(Graphics g) {

	
	}


	public Model getModel() {
		return model;
	}

	public void setModel(Model model2) {
		this.model = model2;
	}

}
