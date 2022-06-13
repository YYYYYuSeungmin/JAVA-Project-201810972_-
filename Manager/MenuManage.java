package Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DB.DB_Conn;

//1. �߰�, 2. ����, 3. ����, 4. �˻�, 5. ��ü���, 6. ����
public class MenuManage 
{
	//������ ���̵�
	private static String ADMIN_ID = "ADMIN";
	private static String ADMIN_PW = "ADMIN";
	
	public static void insert(int table, String name, int price) throws ClassNotFoundException, SQLException {
		//�Է��ϴ� �޼ҵ�, table 1:���̴�, 2:�帵ũ
	    Connection conn = DB_Conn.getConnection();
	    String sql;
	    if (table == 1)
	    {
	    	sql = "insert into diningmenu(name, price) values(?,?)";
	    }
	    else
	    {
	       sql ="insert into drinkmenu(name, price) values(?,?)";
	    }
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	        
	    pstmt.setString(1, name);
	    pstmt.setInt(2, price);
	        
	    int res = pstmt.executeUpdate();
	    if(res > 0){
	        System.out.println("ó�� �Ϸ�");
	    }
	        
	    if(pstmt != null) 
	    	pstmt.close();
	    if(conn != null) 
	    	conn.close();
	}
	 
 	public static void update(int table, String name, int price, String rename) throws ClassNotFoundException, SQLException {
        //�Է��ϴ� �޼ҵ�, table 1:���̴�, 2:�帵ũ
        Connection conn = DB_Conn.getConnection();
        String sql;
        if (table == 1)
        {
        	sql = "Update diningmenu SET name = ?, price = ? WHERE name = ?";
        }
        else
        {
        	sql ="Update drinkmenu SET name = ?, price = ? WHERE name = ?";
        }
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        pstmt.setString(1, rename);
        pstmt.setInt(2, price);
        pstmt.setString(3, name);
        
        int res = pstmt.executeUpdate();
        if(res > 0){
            System.out.println("ó�� �Ϸ�");
        }
        
        if(pstmt != null) 
			pstmt.close();
        if(conn != null) 
			conn.close();
    }
	 
	 public static void delete(int table, String name) throws ClassNotFoundException, SQLException {
	    //�Է��ϴ� �޼ҵ�, table 1:���̴�, 2:�帵ũ
		Connection conn = DB_Conn.getConnection();
		String sql;
		if (table == 1)
		{
			sql = "DELETE FROM diningmenu WHERE name = ?";
		}
		else
		{
			sql ="DELETE FROM drinkmenu WHERE name = ?";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, name);
		
		int res = pstmt.executeUpdate();
		if(res > 0){
		    System.out.println("ó�� �Ϸ�");
		    }
		    
		    if(pstmt != null) 
				pstmt.close();
		    if(conn != null) 
				conn.close();
	}
	 
	 public static void search(int table, String name) throws ClassNotFoundException, SQLException {
		    //�Է��ϴ� �޼ҵ�, table 1:���̴�, 2:�帵ũ
			Connection conn = DB_Conn.getConnection();
			String sql;
			if (table == 1)
			{
				sql = "SELECT * FROM diningmenu WHERE name = ?";
			}
			else
			{
				sql ="SELECT * FROM drinkmenu WHERE name = ?";
			}
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			System.out.println("�޴��̸� : " + rs.getString("name"));
			System.out.println("���� : " + rs.getInt("price"));
			    
		    if(pstmt != null) 
				pstmt.close();
		    if(conn != null) 
				conn.close();
		}
	 public static void load(int table) throws ClassNotFoundException, SQLException {
		    //�Է��ϴ� �޼ҵ�, table 1:���̴�, 2:�帵ũ
			Connection conn = DB_Conn.getConnection();
			String sql;
			if (table == 1)
			{
				sql = "SELECT * FROM diningmenu";
			}
			else
			{
				sql ="SELECT * FROM drinkmenu";
			}
			PreparedStatement pstmt = conn.prepareStatement(sql);

			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println("�޴��̸� : " + rs.getString("name"));
				System.out.println("���� : " + rs.getInt("price"));
				System.out.println("-------------------------------");
			}

			    
		    if(pstmt != null) 
				pstmt.close();
		    if(conn != null) 
				conn.close();
	 }
	public void managefunc() throws ClassNotFoundException, SQLException
	{
		MenuManage test = new MenuManage();
		ResultSet rs;
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		int tablenum = 0;
		
		while (flag == true)
		{
			System.out.println("1.�߰�, 2.����, 3.����, 4.�˻�, 5.��Ϻ���, 6.����");
			int select = in.nextInt();
			String name;
			int price;
			
			switch (select)
			{
			case 1 : //�޴� �߰�
				System.out.println("�߰��� �޴� �Է� ");
				System.out.println("�߰��� �޴� ���� ");
				System.out.println("1: DiningMenu, 2: DrinkMenu");
				tablenum = in.nextInt();
				System.out.print("�޴� �̸� >> ");
				name = in.next();
				System.out.print("�޴� ���� >> ");
				price = in.nextInt();
				insert(tablenum, name, price);
				
				break;
				
			case 2 : //�޴� ����
				System.out.println("�޴� ����");
				System.out.println("������ �޴� ���� ");
				System.out.println("1: DiningMenu, 2: DrinkMenu");
				tablenum = in.nextInt();
				System.out.print("�޴� �̸� >> ");
				name = in.next();
				System.out.print("������ �޴� �̸� >> ");
				String updatename = in.next();
				System.out.print("������ �޴� ���� >> ");
				price = in.nextInt();
				update(tablenum, name, price, updatename);
				break;
				
			case 3 : // �޴� ����
				System.out.println("�޴� ����");
				System.out.println("������ �޴� ���� ");
				System.out.println("1: DiningMenu, 2: DrinkMenu");
				tablenum = in.nextInt();
				System.out.print("�޴� �̸� >> ");
				name = in.next();
				delete(tablenum, name);
				break;
			
			case 4 : // �޴� �˻�
				System.out.println("�޴� �˻�");
				System.out.println("�˻��� �޴� ���� ");
				System.out.println("1: DiningMenu, 2: DrinkMenu");
				tablenum = in.nextInt();
				System.out.print("�޴� �̸� >> ");
				name = in.next();
				search(tablenum, name);
				break;
				
			case 5 : //��ü �޴� �ε�
				System.out.println("�޴� ���� ");
				System.out.println("1: DiningMenu, 2: DrinkMenu");
				tablenum = in.nextInt();
				load(tablenum);
				break;
				
			case 6 :
				flag = false;
				break;
			}
		}
	}
	public void checkMg() throws ClassNotFoundException, SQLException
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("������ ID �Է� >> ");
		String ID = in.next();
		System.out.print("������ PW �Է� >> ");
		String PW = in.next();
		
		if (ID.equals(ADMIN_ID) && PW.equals(ADMIN_PW))
		{
			managefunc();
		}
		else 
		{
			System.out.println("�α��� ����.");
			return;
		}
	}
	public static void main(String[] args)
	{
	}
}

