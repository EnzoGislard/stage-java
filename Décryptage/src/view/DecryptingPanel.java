package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DecryptingPanel extends JPanel {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public Frame frame;
	public Image img_one;
	public Image img_two;
	public Image img_three;
	
	public int compteur = 0;
	
	public DecryptingPanel(Frame frame) {
		this.frame = frame;
		
		frame.setTitle("Decrypting...");
		
		try {
			this.img_one = ImageIO.read(getClass().getResourceAsStream("/decrypting_1.png"));
			this.img_two = ImageIO.read(getClass().getResourceAsStream("/decrypting_2.png"));
			this.img_three = ImageIO.read(getClass().getResourceAsStream("/decrypting_3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setContentPane(this);
		System.out.println("TEST#5");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		System.out.println("TEST#6 (compteur : " + compteur);
		if(compteur == 0)
			g.drawImage(img_one, 0, 0, 583, 260, this);
		else if(compteur == 1)
			g.drawImage(img_two, 0, 0, 583, 260, this);
		else if(compteur == 2) {
			g.drawImage(img_three, 0, 0, 583, 260, this);
			compteur = -1;
		}
		
		compteur++;
	}
}
