package Component;

import javax.swing.*;

import Kiosk.Main;
import Kiosk.MainPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderList extends JPanel
{
	
	public static JLabel TotalPrice = new JLabel("0"); //�� �ֹ� �ݾ�
	public static ArrayList<JPanel> orderHistory = new ArrayList<JPanel>();
	
	public OrderList(JFrame frame) 
	{
		this.setLayout(null);
		this.setOpaque(true);
		this.setBackground(Color.green);
		this.setLocation(450, 100);
		this.setSize(350, 600);
		
		//�ֹ� ���� ��
		JLabel OrderTitle = new JLabel("�� �� �� ��");
		OrderTitle.setFont(new Font("SanSerif", Font.BOLD, 27));
		OrderTitle.setSize(350,30);
		OrderTitle.setLocation(0,10);
		this.add(OrderTitle);
		
		//�� �ݾ�
		JLabel price = new JLabel("�ֹ� �ݾ�");
		price.setFont(new Font("SanSerif", Font.BOLD, 27));
		price.setSize(350, 30);
		price.setLocation(0, 480);
		this.add(price);
		
		//�� �ݾ��� ��µǴ� ��
		TotalPrice.setFont(new Font("SanSerif", Font.BOLD, 27));
		TotalPrice.setSize(350, 30);
		TotalPrice.setLocation(0, 510);
		this.add(TotalPrice);
		
		//����ϱ� ��ư �߰�
		CancleButton cancle = new CancleButton(this);
		
		//�����ϱ� ��ư �߰�
		PayButton payButton = new PayButton(this);
		frame.add(this);
	}
	
	public void addList(String name)
	{
		//�̹� ���� �̸��� �޴��� �ֹ������� �ִ��� Ȯ��.
		for(int i = 0; i < OrderList.orderHistory.size(); i++) 
		{
			if (name.equals(OrderList.orderHistory.get(i).getName())) //�̹� �ֹ������� �ִ� �޴� => ���� �߰�
			{
				((AddOrderPanel) OrderList.orderHistory.get(i)).setCount(1);
				return; //���� �߰��ϰ� �Լ� ��� ��.
			}
		}
		
		//������� �ڵ尡 �Ѿ���� ���ο� �޴��� �ֹ������� �߰� => �ֹ����� �г�(��, ��ư) �߰�
		orderHistory.add(new AddOrderPanel(this, name));
	}
}