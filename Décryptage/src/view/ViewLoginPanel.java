package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import controller.Controller;

public class ViewLoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image img;

	private ViewFrame frame;

	private JTextField id;
	private JPasswordField password;

	private JButton authentify;
	private Boolean maskPassword = true;

	/** This constructor create a button into the panel and load an image into it */
	public ViewLoginPanel(Controller controller, ViewFrame frame) {

		this.setFrame(frame);

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
		loginLabel = new JLabel("Username:", SwingConstants.CENTER);
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
		passwordPasswordField.setHorizontalAlignment(JTextField.CENTER);
		;

		passwordGet = new JButton("Show password");

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

		loginButton = new JButton("Connection");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (loginTextField.getText().compareTo("") == 0) {
					JOptionPane.showMessageDialog(null, "Please enter a username", "Error", JOptionPane.ERROR_MESSAGE);
				}

				else if (passwordPasswordField.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Please enter a password", "Error", JOptionPane.ERROR_MESSAGE);
				}

				else {

					boolean contolCompteBool = controller.controllerGestionComptePersonne.testerCompte(
							loginTextField.getText(), String.valueOf(passwordPasswordField.getPassword()),
							controller.model.cad);

					if (contolCompteBool == true) {
						frame.remove(frame.getLoadPanel());
						frame.setContentPane(frame.getChooseFPanel());
						frame.repaint();
						frame.revalidate();
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password! ", "Oh no!",
								JOptionPane.INFORMATION_MESSAGE);
					}

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

	public ViewFrame getFrame() {
		return frame;
	}

	public void setFrame(ViewFrame frame) {
		this.frame = frame;
	}

	public JTextField getId() {
		return id;
	}

	public void setId(JTextField id) {
		this.id = id;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JButton getAuthentify() {
		return authentify;
	}

	public void setAuthentify(JButton authentify) {
		this.authentify = authentify;
	}
}
