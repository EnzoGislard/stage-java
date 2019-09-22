package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import model.Model;

public class LoadPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Model model;
	private Image img;
	
	
	public JTextField id; 
	public JPasswordField password;
	
	public JButton authentify;
	

	/** This constructor create a button into the panel and load an image into it */
	public LoadPanel(Model model) {

		this.setModel(model);

        //this.setLayout(new SpringLayout());
		this.setLayout(new GridLayout(3, 2, 60, 30));
        
        JLabel loginLabel;
        JTextField loginTextField;
        
        JLabel passwordLabel;
        JPasswordField passwordPasswordField;
        
        JButton loginButton;
        JButton passwordGet;
        
		Border lineborder = BorderFactory.createLineBorder(Color.white, 2); 
		
		Font font = new Font("Courier New", Font.ITALIC, 20);

		try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/lol.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		;


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
//        passwordGet.addActionListener(
//                new ActionListener() {
// 
//                    public void actionPerformed(ActionEvent e) {
//                        String password = new String(pfPassword.getPassword());
//                        JOptionPane.showMessageDialog(frame,
//                                "Password is " + password);
//                    }
//                });
        
        
        

        loginButton = new JButton("Login");

 
        
        
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

	public Model getModel() {
		return model;
	}

	public void setModel(Model model2) {
		this.model = model2;
	}
}
