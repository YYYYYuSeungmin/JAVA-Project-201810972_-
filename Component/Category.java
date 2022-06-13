package Component;

import javax.swing.*;

import Kiosk.DiningPanel;
import Kiosk.DrinkPanel;

public class Category extends JTabbedPane
{
	public Category(JFrame frame) 
	{
		this.addTab("�Ļ� ��", new DiningPanel());
		this.addTab("���� ��", new DrinkPanel());
		this.setLocation(0, 100);
		this.setSize(450,600);
		
		frame.add(this);
	}
}
