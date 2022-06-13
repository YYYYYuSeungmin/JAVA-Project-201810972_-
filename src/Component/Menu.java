package Component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Menu extends JLabel
{
	public Menu(JFrame frame) 
	{
		this.setText("¸Þ ´º ÆÇ");
		this.setSize(800,100);
		this.setOpaque(true);
		this.setBackground(Color.yellow);
		this.setFont(new Font("SanSerif", Font.BOLD, 40));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setLocation(0,0);
		
		frame.add(this);	
	}
}
