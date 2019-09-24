package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ChooseFPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
//    JFileChooser chooser = new JFileChooser();
//    FileNameExtensionFilter filter = new FileNameExtensionFilter(
//        "JPG & GIF Images", "jpg", "gif");
//    chooser.setFileFilter(filter);
//    int returnVal = chooser.showOpenDialog(parent);
//    if(returnVal == JFileChooser.APPROVE_OPTION) {
//       System.out.println("You chose to open this file: " +
//            chooser.getSelectedFile().getName());
//    }
	
	
	// déclaration JP
	JLabel TitleLabel;
	JButton OpenButton;
	
	
	// Propriétés attributs

	TitleLabel = new JLabel("Choose File :", SwingConstants.CENTER);
	TitleLabel.setBorder(lineborder);
	TitleLabel.setForeground(Color.white);
	
	
	
	
	
	
}