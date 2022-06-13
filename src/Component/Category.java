package Component;

import javax.swing.*;

import Kiosk.DiningPanel;
import Kiosk.DrinkPanel;

public class Category extends JTabbedPane
{
	public Category(JFrame frame) 
	{
		this.addTab("식사 류", new DiningPanel());
		this.addTab("음료 류", new DrinkPanel());
		this.setLocation(0, 100);
		this.setSize(450,600);
		
		frame.add(this);
	}
}
