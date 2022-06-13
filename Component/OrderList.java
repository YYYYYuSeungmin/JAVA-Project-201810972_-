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
	
	public static JLabel TotalPrice = new JLabel("0"); //총 주문 금액
	public static ArrayList<JPanel> orderHistory = new ArrayList<JPanel>();
	
	public OrderList(JFrame frame) 
	{
		this.setLayout(null);
		this.setOpaque(true);
		this.setBackground(Color.green);
		this.setLocation(450, 100);
		this.setSize(350, 600);
		
		//주문 내역 라벨
		JLabel OrderTitle = new JLabel("주 문 내 역");
		OrderTitle.setFont(new Font("SanSerif", Font.BOLD, 27));
		OrderTitle.setSize(350,30);
		OrderTitle.setLocation(0,10);
		this.add(OrderTitle);
		
		//총 금액
		JLabel price = new JLabel("주문 금액");
		price.setFont(new Font("SanSerif", Font.BOLD, 27));
		price.setSize(350, 30);
		price.setLocation(0, 480);
		this.add(price);
		
		//총 금액이 출력되는 라벨
		TotalPrice.setFont(new Font("SanSerif", Font.BOLD, 27));
		TotalPrice.setSize(350, 30);
		TotalPrice.setLocation(0, 510);
		this.add(TotalPrice);
		
		//취소하기 버튼 추가
		CancleButton cancle = new CancleButton(this);
		
		//결제하기 버튼 추가
		PayButton payButton = new PayButton(this);
		frame.add(this);
	}
	
	public void addList(String name)
	{
		//이미 같은 이름의 메뉴가 주문내역에 있는지 확인.
		for(int i = 0; i < OrderList.orderHistory.size(); i++) 
		{
			if (name.equals(OrderList.orderHistory.get(i).getName())) //이미 주문내역에 있는 메뉴 => 수량 추가
			{
				((AddOrderPanel) OrderList.orderHistory.get(i)).setCount(1);
				return; //수량 추가하고 함수 기능 끝.
			}
		}
		
		//여기까지 코드가 넘어오면 새로운 메뉴를 주문내역에 추가 => 주문내역 패널(라벨, 버튼) 추가
		orderHistory.add(new AddOrderPanel(this, name));
	}
}