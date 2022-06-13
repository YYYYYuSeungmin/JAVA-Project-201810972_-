package Kiosk;

import javax.swing.*;
import Component.*;
import Component.Menu;
import DB.*;

import java.awt.*;
import java.util.ArrayList;


public class MainPanel extends JFrame
{	
	static Object orderList;
	public MainPanel() 
	{
		//���� ������ �Ǵ� ������ ����
		setTitle("201810972_Kiosk");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(800,839);
		setVisible(true);
		
		//Ű����ũ ��� ��� ����� �޴��� �� ����	
		Menu menu = new Menu(this);

		//ī�װ� ����
		Category category = new Category(this);
		
		//�ֹ� ���� ����
		orderList = (OrderList) new OrderList(this);

		//������ �޴� Ű����ũ �ϴ�
		Manage manage = new Manage(this);
	}
	
}