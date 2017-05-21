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
		add(startButton);
		
		JButton quitButton = new JButton();
		quitButton.setIcon(new ImageIcon("exitbutton.png"));
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitButton.setBorderPainted(false);
		add(quitButton);
		
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