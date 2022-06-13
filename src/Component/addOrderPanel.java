package Component;

import javax.swing.*;

import Kiosk.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class addOrderPanel extends JPanel
{
	JLabel menuName = new JLabel();
	JLabel count = new JLabel("1");
	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	
	public addOrderPanel(JPanel Panel, String name)
	{
		this.setSize(350, 50);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(true);
		this.setBackground(Color.green);
		this.setLocation(0, 45 + (40 * OrderList.orderHistory.size()));
		
		//�޴� �̸� (x��ǥ : 10 ~ 110)
		menuName.setText(name);
		menuName.setSize(100, 40);
		menuName.setLocation(10,5);
		menuName.setFont(new Font("SanSerif", Font.BOLD, 15));
		this.add(menuName);
		
		//�÷��� ��ư
		plus.setSize(45, 40);
		plus.setLocation(200, 5);
		//�׼� ������ �߰�
		plus.addActionListener(new MyActionListener());
		this.add(plus);
		
		//���̳ʽ� ��ư
		minus.setSize(45, 40);
		minus.setLocation(285, 5);
		//�׼� ������ �߰�
		minus.addActionListener(new MyActionListener());
		this.add(minus);
		
		//���� ��
		count.setHorizontalAlignment(JLabel.CENTER);
		count.setSize(40,40);
		count.setLocation(245, 5);
		this.add(count);
		
		Panel.add(this);
		Panel.repaint();
	}
	
	//�ش� �г��� �޴� �̸� ����
	public String getName()
	{
		return menuName.getText();
	}
	
	//count �ؽ�Ʈ�� ����
	public void setCount(int i)
	{
		int num = Integer.parseInt(count.getText()) + i;
		count.setText(Integer.toString(num));
	}
	
	//�÷��� ���̳ʽ� ��ư �׼� ������
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			boolean flag = false; //�Ļ��, ������� �����ϱ� ���� �÷���
			if (e.getSource() == plus)
			{
				setCount(1);
				flag = true;
			}
			else if (e.getSource() == minus)
			{
				int num = Integer.parseInt(count.getText());
				if (num < 1) //�޴��� -���� �Ǵ°� ������.
				{
					return;
				}
				setCount(-1);
				flag = false;
			}
			
			//�޴� �̸� �޾ƿ���
			String menu = menuName.getText();
			
			ArrayList<String> menuList = (ArrayList<String>) Main.DiningMenu.clone();
			ArrayList<String> priceList = (ArrayList<String>) Main.DiningPrice.clone();
			//�޴� ������ ����� �ε��� ã��
			int i = menuList.indexOf(menu);
			
			if (i == -1) //���̴� �޴����� ã�� �� ���� �̸��� ���.
			{
				 menuList = (ArrayList<String>) Main.DrinkMenu.clone();
				 priceList = (ArrayList<String>) Main.DrinkPrice.clone();
				 
				 i = menuList.indexOf(menu);
			}
			
			//�� ���� �����ϱ�.
			int price = Integer.parseInt(OrderList.TotalPrice.getText());
			if (flag == true)
			{
				price += Integer.parseInt(priceList.get(i));
			}
			else
			{
				price -= Integer.parseInt(priceList.get(i));
			}
			
			OrderList.TotalPrice.setText(String.valueOf(price));
	    }
	}
}
