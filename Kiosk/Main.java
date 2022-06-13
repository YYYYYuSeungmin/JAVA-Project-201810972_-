package Kiosk;

import java.sql.SQLException;
import java.util.ArrayList;

import DB.LoadMenu;

public class Main 
{
	//메뉴가 저장될 리스트
	public static ArrayList<String> DiningMenu = new ArrayList<String>();
	public static ArrayList<String> DiningPrice = new ArrayList<String>();
		
	public static ArrayList<String> DrinkMenu = new ArrayList<String>();
	public static ArrayList<String> DrinkPrice = new ArrayList<String>();
	
	static MainPanel mp;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		LoadMenu.DiningMenu();
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
