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
		//가장 메인이 되는 프레임 생성
		setTitle("201810972_Kiosk");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(800,839);
		setVisible(true);
		
		//키오스크 상단 노란 배경의 메뉴판 라벨 생성	
		Menu menu = new Menu(this);

		//카테고리 생성
		Category category = new Category(this);
		
		//주문 내역 생성
		orderList = (OrderList) new OrderList(this);

		//관리자 메뉴 키오스크 하단
		Manage manage = new Manage(this);
	}
	
}