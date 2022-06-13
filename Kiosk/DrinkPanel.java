package Kiosk;


import javax.swing.*;

import Component.OrderList;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;


public class DrinkPanel extends JPanel
{
	
	ArrayList<JButton> bt_list = new ArrayList<JButton>();
	
	public DrinkPanel()
	{
		this.setLayout(null);
		this.setSize(450,600);
		this.setVisible(true);
		
		for (int i = 0; i < Main.DrinkMenu.size(); i++) 
		{
			String name = Main.DrinkMenu.get(i);
			JButton bt = new JButton(name);
			bt.setSize(100,100);
			bt.setLocation(10 + (110 * (i % 4)), 10 + (120 * (i / 4)));
			bt.addActionListener(new clickDrinks());
			bt_list.add(bt); //���� ��ư �̺�Ʈ ó���� ���� ��ư ����
			
			//����ǥ �� ����
			String price = Main.DrinkPrice.get(i) + "��";
			JLabel lb = new JLabel(price);
			lb.setFont(new Font("SanSerif", Font.BOLD, 12));
			lb.setSize(100,10);
			lb.setLocation(10 + (110 * (i % 4)), 115 + (120 * (i / 4)));
			lb.setHorizontalAlignment(JLabel.CENTER);
			DrinkPanel.this.add(bt);
			DrinkPanel.this.add(lb);
		}
	}

	//�޴���ư �׼� ������
	public class clickDrinks implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			for (int i = 0; i < Main.DrinkMenu.size(); i++) 
			{ //Ŭ���� ��ư�� ���� ��ư ã��
				if (bt_list.get(i).equals(e.getSource())) 
				{
					((OrderList) MainPanel.orderList).addList(bt_list.get(i).getText());
					addPrice(i);
				}
			}
        }
		
		private void addPrice(int i) 
		{
			int price = Integer.parseInt(OrderList.TotalPrice.getText());
			price += Integer.parseInt(Main.DrinkPrice.get(i));
			OrderList.TotalPrice.setText(String.valueOf(price));
		}
    }
}