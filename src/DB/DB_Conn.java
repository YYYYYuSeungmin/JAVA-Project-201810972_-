package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Conn
{
	public static Connection getConnection() throws ClassNotFoundException, SQLException  
	{
    String url = "jdbc:mysql://localhost:3306/Kiosk";
    String user = "root";
    String pwd = "1234";
    Connection conn = null;
    
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(url, user, pwd);
        
    return conn;
	}
}
