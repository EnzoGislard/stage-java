package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Controller;

public class ChooseFPanel extends JPanel {
	
    private JFileChooser fileChooser = new JFileChooser();
    
    private String userName;

	private Image img;
	
	private JButton openButton;
	
	/** This constructor create a button into the panel and load an image into it */
	public ChooseFPanel(Controller controller) {		
		
		//Form
		Border lineborder = BorderFactory.createLineBorder(Color.white, 2); 
		
		Font font = new Font("Courier New", Font.ITALIC, 20);
	
		/*try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/Background.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}	*/		

		this.setLayout(new GridLayout(3, 2, 60, 30));
		
		//declaration JP
		JLabel titleLabel;
		JLabel fileLabel;
		
		//Attributes properties 
	
		titleLabel = new JLabel("Choose File :", SwingConstants.CENTER);
		titleLabel.setBorder(lineborder);
		titleLabel.setForeground(Color.white);
		
		fileLabel = new JLabel("Nom du fichier", SwingConstants.CENTER);
		fileLabel.setBorder(lineborder);
		fileLabel.setForeground(Color.white);
		
		openButton = new JButton("FileChooser");	
	
		this.init();
		
		this.add(titleLabel);
		this.add(openButton);
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
        fileChooser.setCurrentDirectory(new java.io.File("C:/Users/" + userName + "/Desktop/"));
        
        fileChooser.setDialogTitle("Choose the file witch needs to be decrypted.");
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        openButton = new JButton("FileChooser");
        
		openButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
				if(fileChooser.showOpenDialog(openButton) == JFileChooser.APPROVE_OPTION);
				
				System.out.println("\n\nYou choose a file with the path : " + fileChooser.getSelectedFile().getAbsolutePath() + "\n");
				System.out.println("You choose a file with a space of : " + fileChooser.getSelectedFile().getTotalSpace() + "octets \n");
				System.out.println("You choose the file named : " + fileChooser.getSelectedFile().getName() + "\n");
		    }
		});
    }
}