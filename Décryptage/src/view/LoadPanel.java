package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import controller.Controller;


public class LoadPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image img;
	
	public JTextField id; 
	public JPasswordField password;
	
	public JButton authentify;
	public Boolean maskPassword = true;
	

	/** This constructor create a button into the panel and load an image into it */
	public LoadPanel(Controller controller) {

		
		
		// mise en forme
		Border lineborder = BorderFactory.createLineBorder(Color.white, 2); 
		
		Font font = new Font("Courier New", Font.ITALIC, 20);

		try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/lol.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
		

		this.setLayout(new GridLayout(3, 2, 60, 30));
        
		
		// attributs
        JLabel loginLabel;
        JTextField loginTextField;
        
        JLabel passwordLabel;
        JPasswordField passwordPasswordField;
        
        JButton loginButton;
        JButton passwordGet;
        



		
		
		
		// Propriétés attributs
		loginLabel = new JLabel("User Name:", SwingConstants.CENTER);
	    loginLabel.setBorder(lineborder);
	    loginLabel.setForeground(Color.white);
	    loginLabel.setFont(font);
		
		loginTextField = new JTextField(20);
        loginLabel.setLabelFor(loginTextField);
        loginTextField.setOpaque(false);
        loginTextField.setBorder(lineborder);	
        loginTextField.setForeground(Color.white);
        loginTextField.setFont(font);
        loginTextField.setHorizontalAlignment(JTextField.CENTER);
        
        
        
        
        
        
        passwordLabel = new JLabel("Password:", SwingConstants.CENTER);
        passwordLabel.setBorder(lineborder);
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(font);
        
        passwordPasswordField = new JPasswordField(20);
        passwordLabel.setLabelFor(passwordPasswordField);
        passwordPasswordField.setOpaque(false);
        passwordPasswordField.setBorder(lineborder);
        passwordPasswordField.setForeground(Color.white);
        passwordPasswordField.setFont(font);
        passwordPasswordField.setHorizontalAlignment(JTextField.CENTER);;
        
        
        
        passwordGet = new JButton("Display Password");
        
        passwordGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if (maskPassword == false) {
	                	passwordPasswordField.setEchoChar('*');
	                	maskPassword = true;
	                } else {
	                	passwordPasswordField.setEchoChar((char) 0);
	                	maskPassword = false;
	                }
			}
        });
        
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (loginTextField.getText().compareTo("") == 0) {
					JOptionPane.showMessageDialog(null,
						    "Veuillez entrer un utilisateur",
						    "Erreur",
						    JOptionPane.ERROR_MESSAGE);
	            } 
				
				else if (passwordPasswordField.getPassword().length == 0)  {
					JOptionPane.showMessageDialog(null,
						    "Veuillez entrer un mot de passe",
						    "Erreur",
						    JOptionPane.ERROR_MESSAGE);
	            } 
				
				
				else {
					System.out.print("");
					boolean contolCompteBool = controller.ControllerCompte.pcs_authentifier(loginTextField.getText(), String.valueOf(passwordPasswordField.getPassword()));
					System.out.print(contolCompteBool);
	            }
			}
       });

        
        
        this.add(loginLabel);
        this.add(loginTextField);
        this.add(passwordLabel);
        this.add(passwordPasswordField);
        this.add(loginButton);
        this.add(passwordGet);
 
	}
	
	public void paintComponent(Graphics g) {

		g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);

	}
}
