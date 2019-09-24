package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class ChooseFPanel extends JPanel {	
	
	public Controller controller;
	
	public String nameOfSourceFile;
	public String pathOfSourceFile;
	public String pathOfDirectory;
	
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
	
	/** This constructor create a button into the panel and load an image into it */
	public ChooseFPanel(Controller controller) {		
		
		this.controller = controller;
		
		
		//Form
		Border lineBorder = BorderFactory.createLineBorder(Color.white, 1); 
		Font font = new Font("Courier New", Font.ITALIC + Font.BOLD, 20);
	
		//Labels declaration
		JLabel nameOfSourceFile;
		JLabel pathOfDirectory;
		JTextField finalFileName;
		
		try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/lol.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setLayout(null);
	
		nameOfSourceFile = initLabel(SOURCE_JLABEL_TEXT + "\" FILE \"", lineBorder, COMPONENTS_LEFT_MARGIN, 5);
		pathOfDirectory = initLabel(DESTINATION_JLABEL_TEXT + "\" PATH \"", lineBorder, COMPONENTS_LEFT_MARGIN, 45);
		
		finalFileName = new JTextField(16);
		finalFileName.setBorder(null);
		finalFileName.setBounds(COMPONENTS_LEFT_MARGIN, 85, JTEXTFIELD_WIDTH, 25);
		finalFileName.setToolTipText("ENTER NAME OF DEST. FILE");
		
		sourceButton = initButton("Search source file", BUTTONS_LEFT_MARGIN, 5);
		destinationButton = initButton("Destination directory", BUTTONS_LEFT_MARGIN, 45);
		decrypterButton = initButton("Decrypt", COMPONENTS_LEFT_MARGIN, 125, font);
	
		this.init(nameOfSourceFile, pathOfDirectory, finalFileName, this);
		
		this.add(nameOfSourceFile);
		this.add(sourceButton);
		this.add(pathOfDirectory);
		this.add(destinationButton);
		this.add(finalFileName);
		this.add(decrypterButton);		
		
		//this.controller.model.modelGestionFichier.getData(pathOfSourceFile);
	}
	
	public void paintComponent(Graphics g) {

		g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);

	}
	
    public void init(JLabel nameOfSourceFileLabel, JLabel pathOfDirectoryLabel, JTextField finalNameOfFileJTextField, JPanel pan) {
    	//Instantiate an NT security information object about the current user.
        com.sun.security.auth.module.NTSystem NTSystem = new
                com.sun.security.auth.module.NTSystem();
        
        //Stock the name of the current user.
        userName = NTSystem.getName();
        
        //Set the default path of the file research.
        sourceFileChooser.setCurrentDirectory(new java.io.File("C:/Users/" + userName + "/Desktop/"));
        destinationFileChooser.setCurrentDirectory(new java.io.File("C:/Users/" + userName + "/Desktop/"));
        
        sourceFileChooser.setDialogTitle("Choose the file witch needs to be decrypted.");
        destinationFileChooser.setDialogTitle("Choose the directory witch will contains the decrypted file.");
        
        sourceFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        destinationFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
		sourceButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
				if(sourceFileChooser.showOpenDialog(sourceButton) == JFileChooser.APPROVE_OPTION)
					if(sourceFileChooser.getSelectedFile() != null) {			
						nameOfSourceFile = sourceFileChooser.getSelectedFile().getName();
						pathOfSourceFile = sourceFileChooser.getSelectedFile().getAbsolutePath();
						nameOfSourceFileLabel.setText(GAP + SOURCE_JLABEL_TEXT + nameOfSourceFile);
						
						pan.updateUI();
					} 
		    }
		});
		
		destinationButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
				if(destinationFileChooser.showOpenDialog(sourceButton) == JFileChooser.APPROVE_OPTION)
					if(destinationFileChooser.getSelectedFile() != null) {
						pathOfDirectory = destinationFileChooser.getSelectedFile().getAbsolutePath()+"\\";
						pathOfDirectoryLabel.setText(GAP + DESTINATION_JLABEL_TEXT + pathOfDirectory);
						pan.updateUI();
					}
		    }
		});
		
		decrypterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nameOfSourceFile == null && pathOfDirectory == null) {
					JOptionPane.showMessageDialog(null,
						    "Please select the source file & the destination folder.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else if(nameOfSourceFile == null) {
					JOptionPane.showMessageDialog(null,
						    "Please select the source file.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else if(pathOfDirectory == null) {
					JOptionPane.showMessageDialog(null,
						    "Please select the destination folder.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,
						    "Everything is OK (exept for the final name of the file.. But we'll see later).",
						    "OK",
						    JOptionPane.INFORMATION_MESSAGE);
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
    
}