package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import controller.Controller;
import controller.ControllerDecrypt;

public class DecryptPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Controller controller;

	public Frame frame;
	
	private String nameOfSourceFile;
	private String pathOfSourceFile;
	private String pathOfDestinationDirectory;

	private JFileChooser sourceFileChooser = new JFileChooser();
	private JFileChooser destinationFileChooser = new JFileChooser();

	private String userName;

	private Image img;

	private JButton sourceButton;
	private JButton destinationButton;
	private JButton decrypterButton;

	final String SOURCE_JLABEL_TEXT = "NAME : ";
	final String DESTINATION_JLABEL_TEXT = "DESTINATION : ";
	final String GAP = "    ";

	final int COMPONENTS_HEIGHT = 25;
	final int COMPONENTS_LEFT_MARGIN = 5;
	final int BUTTONS_LEFT_MARGIN = 415;
	final int DECRYPT_BUTTON_HEIGHT = 50;

	final int LABEL_WIDTH = 400;
	final int JTEXTFIELD_WIDTH = 130;
	final int BUTTON_WIDTH = 155;
	final int DECRYPT_BUTTON_WIDTH = JTEXTFIELD_WIDTH;

	// Labels declaration
	JLabel nameOfSourceFileLabel;
	JLabel pathOfDirectory;
	JTextField finalFileName;
	JTextField lenghtOfKey;
	JTextField key;

	/** This constructor create a button into the panel and load an image into it */
	public DecryptPanel(Controller controller, Frame frame) {

		this.controller = controller;
		this.frame = frame;

		// Form
		Border lineBorder = BorderFactory.createLineBorder(Color.white, 1);
		Font font = new Font("Courier New", Font.ITALIC + Font.BOLD, 20);

		try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/lol.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setLayout(null);

		nameOfSourceFileLabel = initLabel(SOURCE_JLABEL_TEXT + "\" FILE \"", lineBorder, COMPONENTS_LEFT_MARGIN, 5);
		pathOfDirectory = initLabel(DESTINATION_JLABEL_TEXT + "\" PATH \"", lineBorder, COMPONENTS_LEFT_MARGIN, 45);

		finalFileName = initTextField(16, "Name of final file", "ENTER NAME OF DEST. FILE", COMPONENTS_LEFT_MARGIN, 85, JTEXTFIELD_WIDTH, 25);
		lenghtOfKey = initTextField(4, "Lenght of the key", "ENTER LENGHT OF KEY", COMPONENTS_LEFT_MARGIN + 217, 85, JTEXTFIELD_WIDTH, 25);
		key = initTextField(16, "Key part (optionnal)", "ENTER THE KEY", COMPONENTS_LEFT_MARGIN + 434, 85, JTEXTFIELD_WIDTH, 25);

		sourceButton = initButton("Search source file", BUTTONS_LEFT_MARGIN, 5);
		destinationButton = initButton("Destination directory", BUTTONS_LEFT_MARGIN, 45);
		decrypterButton = initButton("Decrypt", COMPONENTS_LEFT_MARGIN, 125, font);

		this.init(nameOfSourceFileLabel, pathOfDirectory, finalFileName, this, controller);

		this.add(nameOfSourceFileLabel);
		this.add(sourceButton);
		this.add(pathOfDirectory);
		this.add(destinationButton);
		this.add(finalFileName);
		this.add(decrypterButton);
		this.add(lenghtOfKey);
		this.add(key);

	}

	public void paintComponent(Graphics g) {

		g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);

	}

	public void init(JLabel nameOfSourceFileLabel, JLabel pathOfDirectoryLabel, JTextField finalNameOfFileJTextField,
			JPanel pan, Controller controller) {
		// Instantiate an NT security information object about the current user.
		com.sun.security.auth.module.NTSystem NTSystem = new com.sun.security.auth.module.NTSystem();

		// Stock the name of the current user.
		userName = NTSystem.getName();

		// Set the default path of the file research.
		sourceFileChooser.setCurrentDirectory(new java.io.File("C:/Users/" + userName + "/Desktop/"));
		destinationFileChooser.setCurrentDirectory(new java.io.File("C:/Users/" + userName + "/Desktop/"));

		sourceFileChooser.setDialogTitle("Choose the file witch needs to be decrypted.");
		destinationFileChooser.setDialogTitle("Choose the directory witch will contains the decrypted file.");

		sourceFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		destinationFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		sourceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sourceFileChooser.showOpenDialog(sourceButton) == JFileChooser.APPROVE_OPTION)
					if (sourceFileChooser.getSelectedFile() != null) {
						nameOfSourceFile = sourceFileChooser.getSelectedFile().getName();
						pathOfSourceFile = sourceFileChooser.getSelectedFile().getAbsolutePath();
						nameOfSourceFileLabel.setText(GAP + SOURCE_JLABEL_TEXT + nameOfSourceFile);

						pan.updateUI();
					}
			}
		});

		destinationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (destinationFileChooser.showOpenDialog(sourceButton) == JFileChooser.APPROVE_OPTION)
					if (destinationFileChooser.getSelectedFile() != null) {
						pathOfDestinationDirectory = destinationFileChooser.getSelectedFile().getAbsolutePath() + "\\";
						pathOfDirectoryLabel.setText(GAP + DESTINATION_JLABEL_TEXT + pathOfDestinationDirectory);
						pan.updateUI();
					}
			}
		});

		decrypterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
						
				if (nameOfSourceFile == null && pathOfDestinationDirectory == null) {
					JOptionPane.showMessageDialog(null, "Please select the source file & the destination folder.",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else if (nameOfSourceFile == null) {
					JOptionPane.showMessageDialog(null, "Please select the source file.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (pathOfDestinationDirectory == null) {
					JOptionPane.showMessageDialog(null, "Please select the destination folder.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (isNotInteger(lenghtOfKey.getText())) {
					JOptionPane.showMessageDialog(null, "\n" + "The lenght of the key must be a number.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					
					DecryptingThread decryptingThread = new DecryptingThread(new Frame(controller));
					decryptingThread.start();
					
					String keyFromJtext;

					if (key.getText().equals("")) {
						keyFromJtext = "";
					} else {
						keyFromJtext = key.getText();
					}

					controller.controllerDecrypt = new ControllerDecrypt(
							controller.model.modelGestionFichier.getData(pathOfSourceFile), controller.model,
							controller, keyFromJtext, Integer.parseInt(lenghtOfKey.getText()));

					String[] data = controller.controllerDecrypt.decryptage();

					if (data[0] != "" && data[1] != "") {

						try {
							if (finalNameOfFileJTextField.getText().length() >= 1)
								controller.model.modelGestionFichier.setData(data[1],
										pathOfDestinationDirectory + finalNameOfFileJTextField.getText() + ".txt");
							else
								controller.model.modelGestionFichier.setData(data[1],
										pathOfDestinationDirectory + nameOfSourceFile);

							System.out.println("File Created!");
						} catch (IOException e1) {
							System.out.println("A error failed!");
							e1.printStackTrace();
						}
						
						decryptingThread.isTrue = 0;
						decryptingThread.interrupt();
						
						JOptionPane.showMessageDialog(null, "File decrypted ! The key is : " + data[0], "WOW",
								JOptionPane.INFORMATION_MESSAGE);
						controller.model.cad.close();
						frame.dispose();
					}
					else {
						decryptingThread.isTrue = 0;
						decryptingThread.interrupt();
						
						JOptionPane.showMessageDialog(null,"Bad news, the decryption did not succeed", "Oh no",
								JOptionPane.ERROR_MESSAGE);
						controller.model.cad.close();
						frame.dispose();
					}
				}
			}
		});
	}

	private JLabel initLabel(String text, Border border, int x, int y) {

		JLabel label = new JLabel();

		label = new JLabel(GAP + text, SwingConstants.LEFT);
		label.setBorder(border);
		label.setForeground(Color.white);
		label.setBounds(x, y, LABEL_WIDTH, COMPONENTS_HEIGHT);

		return label;
	}

	private JButton initButton(String text, int x, int y) {
		JButton button = new JButton(text);
		button.setBounds(x, y, BUTTON_WIDTH, COMPONENTS_HEIGHT);

		return button;
	}

	private JButton initButton(String text, int x, int y, Font font) {
		JButton button = new JButton(text);
		button.setFont(font);
		button.setBounds(x, y, DECRYPT_BUTTON_WIDTH, DECRYPT_BUTTON_HEIGHT);

		return button;
	}

	private JTextField initTextField(int columns, String defaultValue, String toolTipText, int x, int y, int width, int height) {

		JTextField inputTextField = new JTextField(defaultValue, columns);

		inputTextField.setBorder(null);
		inputTextField.setBounds(x, y, width, height);
		inputTextField.setToolTipText(toolTipText);
		
		inputTextField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  inputTextField.setText("");
			  }});

		return inputTextField;
	}

	public static boolean isNotInteger(String str) {
		if (str == null) {
			return true;
		}
		int length = str.length();
		if (length == 0) {
			return true;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return true;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return true;
			}
		}
		return false;
	}

}