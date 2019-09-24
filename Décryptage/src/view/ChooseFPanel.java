package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import controller.Controller;

public class ChooseFPanel extends JPanel {
	
    private JFileChooser sourceFileChooser = new JFileChooser();
    private JFileChooser destinationFileChooser = new JFileChooser();
    
    private String userName;

	private Image img;
	
	private JButton sourceButton;
	private JButton destinationButton;
	
	/** This constructor create a button into the panel and load an image into it */
	public ChooseFPanel(Controller controller) {		
		
		//Form
		Border lineborder = BorderFactory.createLineBorder(Color.white, 2); 
		Font font = new Font("Courier New", Font.ITALIC, 20);
	
		//Labels declaration
		JLabel titleLabel;
		JLabel fileLabel;
		
		/*try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/Background.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}	*/		

		this.setLayout(new GridLayout(3, 2, 60, 30));
		
		//Attributes properties 
	
		titleLabel = new JLabel("Choose File :", SwingConstants.CENTER);
		titleLabel.setBorder(lineborder);
		titleLabel.setForeground(Color.white);
		
		fileLabel = new JLabel("Nom du fichier", SwingConstants.CENTER);
		fileLabel.setBorder(lineborder);
		fileLabel.setForeground(Color.white);
		
		sourceButton = new JButton("Source file chooser");	
		destinationButton = new JButton("Destination directory chooser");	
	
		this.init();
		
		this.add(titleLabel);
		this.add(sourceButton);
		this.add(destinationButton);
		this.add(fileLabel);
	}
	
	public void paintComponent(Graphics g) {

		g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);

	}
	
    public void init() {
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
						System.out.println("\n\nYou choose a file with the path : " + sourceFileChooser.getSelectedFile().getAbsolutePath() + "\n");
						System.out.println("You choose a file with a space of : " + sourceFileChooser.getSelectedFile().getTotalSpace() + " octets \n");
						System.out.println("You choose the file named : " + sourceFileChooser.getSelectedFile().getName() + "\n");
					} 
		    }
		});
		
		destinationButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
				if(destinationFileChooser.showOpenDialog(sourceButton) == JFileChooser.APPROVE_OPTION)
					if(destinationFileChooser.getSelectedFile() != null) {
						
					}
		    }
		});
    }
}