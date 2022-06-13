package Kiosk;

import User.Login;

import java.sql.SQLException;
import java.util.ArrayList;

import DB.loadMenu;

public class Main 
{
	
	//관리자 아이디
	public static String ADMIN_ID = "ADMIN";
	public static String ADMIN_PW = "ADMIN";
		
	//메뉴가 저장될 리스트
	public static ArrayList<String> DiningMenu = new ArrayList<String>();
	public static ArrayList<String> DiningPrice = new ArrayList<String>();
		
	public static ArrayList<String> DrinkMenu = new ArrayList<String>();
	public static ArrayList<String> DrinkPrice = new ArrayList<String>();
	
	static MainPanel mp;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		loadMenu.DiningMenu();
		mp = new MainPanel();
		/*Login flag = new Login();
		
		if (flag == true)
		{
			new MainPanel();
		}*/
	}
	
	public static void newMP() {
		mp.dispose();
		mp = new MainPanel();
	}
}
