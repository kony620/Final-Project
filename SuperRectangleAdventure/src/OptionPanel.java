import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class OptionPanel extends JPanel implements ActionListener {
	
	Main w;
	private BufferedImage img;
	
	public OptionPanel(Main w) {
		this.w = w;
		JButton startButton = new JButton();
		startButton.setIcon(new ImageIcon("startbutton.png"));
		startButton.addActionListener(this);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false); 
		startButton.setFocusPainted(false); 
		startButton.setOpaque(false);
		add(startButton);
		
		JButton exitButton = new JButton();
		exitButton.setIcon(new ImageIcon("exitbutton.png"));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false); 
		exitButton.setFocusPainted(false); 
		exitButton.setOpaque(false);
		add(exitButton);
		
		validate();
	}
	
	
	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);
	    try {
			img = ImageIO.read(new File("startPage.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    g.drawImage(img, 0, 0, null);


	  }
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel();
	}
	
}