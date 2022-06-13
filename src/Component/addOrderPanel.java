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
		
		//메뉴 이름 (x좌표 : 10 ~ 110)
		menuName.setText(name);
		menuName.setSize(100, 40);
		menuName.setLocation(10,5);
		menuName.setFont(new Font("SanSerif", Font.BOLD, 15));
		this.add(menuName);
		
		//플러스 버튼
		plus.setSize(45, 40);
		plus.setLocation(200, 5);
		//액션 리스너 추가
		plus.addActionListener(new MyActionListener());
		this.add(plus);
		
		//마이너스 버튼
		minus.setSize(45, 40);
		minus.setLocation(285, 5);
		//액션 리스너 추가
		minus.addActionListener(new MyActionListener());
		this.add(minus);
		
		//갯수 라벨
		count.setHorizontalAlignment(JLabel.CENTER);
		count.setSize(40,40);
		count.setLocation(245, 5);
		this.add(count);
		
		Panel.add(this);
		Panel.repaint();
	}
	
	//해당 패널의 메뉴 이름 리턴
	public String getName()
	{
		return menuName.getText();
	}
	
	//count 텍스트값 변경
	public void setCount(int i)
	{
		int num = Integer.parseInt(count.getText()) + i;
		count.setText(Integer.toString(num));
	}
	
	//플러스 마이너스 버튼 액션 리스너
	public class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			boolean flag = false; //식사류, 음료류를 구분하기 위한 플래그
			if (e.getSource() == plus)
			{
				setCount(1);
				flag = true;
			}
			else if (e.getSource() == minus)
			{
				int num = Integer.parseInt(count.getText());
				if (num < 1) //메뉴가 -개가 되는걸 방지함.
				{
					return;
				}
				setCount(-1);
				flag = false;
			}
			
			//메뉴 이름 받아오기
			String menu = menuName.getText();
			
			ArrayList<String> menuList = (ArrayList<String>) Main.DiningMenu.clone();
			ArrayList<String> priceList = (ArrayList<String>) Main.DiningPrice.clone();
			//메뉴 가격이 저장된 인덱스 찾기
			int i = menuList.indexOf(menu);
			
			if (i == -1) //다이닝 메뉴에서 찾을 수 없는 이름일 경우.
			{
				 menuList = (ArrayList<String>) Main.DrinkMenu.clone();
				 priceList = (ArrayList<String>) Main.DrinkPrice.clone();
				 
				 i = menuList.indexOf(menu);
			}
			
			//총 가격 수정하기.
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
