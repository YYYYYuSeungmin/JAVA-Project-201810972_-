package Component;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Kiosk.Main;
import Kiosk.MainPanel;

public class Manage extends JLabel
{
	public Manage(JFrame frame) 
	{
		this.setLayout(null);
		this.setOpaque(true);
		this.setBackground(Color.gray);
		this.setLocation(0, 700);
		this.setSize(800, 100);
		
		ImageIcon img = new ImageIcon("C:\\Users\\reape\\eclipse-workspace\\TEST\\src\\image\\ManageButton.png");
		JButton mgB = new JButton(img);
		mgB.setSize(50,50);
		mgB.setLocation(700,25);
		this.add(mgB);
		
		frame.add(this);
		this.repaint();
	}
	
	/*public class clickManage implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			
		}
    }*/
}
