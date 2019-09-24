package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Controller;

public class ChooseFPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	

	private Image img;
	
	public JTextField id; 
	
	public JButton authentify;
	
	
//  JFileChooser chooser = new JFileChooser();
//  FileNameExtensionFilter filter = new FileNameExtensionFilter(
//      "JPG & GIF Images", "jpg", "gif");
//  chooser.setFileFilter(filter);
//  int returnVal = chooser.showOpenDialog(parent);
//  if(returnVal == JFileChooser.APPROVE_OPTION) {
//     System.out.println("You chose to open this file: " +
//          chooser.getSelectedFile().getName());
//  }
	

	/** This constructor create a button into the panel and load an image into it */
	public ChooseFPanel(Controller controller) {

		
		
		// mise en forme
		Border lineborder = BorderFactory.createLineBorder(Color.white, 2); 
		
		Font font = new Font("Courier New", Font.ITALIC, 20);

		try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/Background.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
		

		this.setLayout(new GridLayout(3, 2, 60, 30));
        

	
	// déclaration JP
	JLabel TitleLabel;
	JButton OpenButton;
	
	
	// Propriétés attributs

	TitleLabel = new JLabel("Choose File :", SwingConstants.CENTER);
	TitleLabel.setBorder(lineborder);
	TitleLabel.setForeground(Color.white);
	
	OpenButton = new JButton("FileChooser");
	
	OpenButton.
	
	
	
	}
	
	
}