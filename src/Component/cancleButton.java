package Component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Kiosk.Main;

public class cancleButton extends JButton
{
	public cancleButton(JPanel panel)
	{
		this.setText("����ϱ�");
		this.setSize(170,50);
		this.setFont(new Font("SanSerif", Font.BOLD, 15));
		this.setLocation(0,550);
		this.addActionListener(new cancle());
		
		panel.add(this);
	}
	//��� ��ư
	public class cancle implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			OrderList.TotalPrice.setText("0");
			OrderList.orderHistory.clear();
			Main.newMP();
		}
	}
}
