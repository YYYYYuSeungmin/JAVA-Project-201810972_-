package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Kiosk.Main;

public class LoadMenu
{
	public static void DiningMenu() throws ClassNotFoundException, SQLException
	{
		Connection conn = DB_Conn.getConnection();
		
		String sql = "SELECT * FROM diningMenu";
	    ResultSet rs = null;
	    Statement stmt = null;
	       
	    stmt = conn.createStatement();
	    rs = stmt.executeQuery(sql);
	    
	    //���̴� �޴� �ε�
	    while(rs.next()) 
	    {
	    	Main.DiningMenu.add(rs.getString("name"));
	    	Main.DiningPrice.add(rs.getString("price"));
	    }
	    
	    sql = "SELECT * FROM drinkMenu";
	    rs = stmt.executeQuery(sql);
	    
	    //���� �޴� �ε�
	    while(rs.next()) 
	    {
	    	Main.DrinkMenu.add(rs.getString("name"));
	    	Main.DrinkPrice.add(rs.getString("price"));
	    }
	    
	    rs.close();
	    conn.close();
	}
}
