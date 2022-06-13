package Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DB.DB_Conn;

//1. 추가, 2. 수정, 3. 삭제, 4. 검색, 5. 전체목록, 6. 종료
public class MenuManage 
{
	//관리자 아이디
	private static String ADMIN_ID = "ADMIN";
	private static String ADMIN_PW = "ADMIN";
	
	public static void insert(int table, String name, int price) throws ClassNotFoundException, SQLException {
		//입력하는 메소드, table 1:다이닝, 2:드링크
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
	        System.out.println("처리 완료");
	    }
	        
	    if(pstmt != null) 
	    	pstmt.close();
	    if(conn != null) 
	    	conn.close();
	}
	 
 	public static void update(int table, String name, int price, String rename) throws ClassNotFoundException, SQLException {
        //입력하는 메소드, table 1:다이닝, 2:드링크
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
            System.out.println("처리 완료");
        }
        
        if(pstmt != null) 
			pstmt.close();
        if(conn != null) 
			conn.close();
    }
	 
	 public static void delete(int table, String name) throws ClassNotFoundException, SQLException {
	    //입력하는 메소드, table 1:다이닝, 2:드링크
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
		    System.out.println("처리 완료");
		    }
		    
		    if(pstmt != null) 
				pstmt.close();
		    if(conn != null) 
				conn.close();
	}
	 
	 public static void search(int table, String name) throws ClassNotFoundException, SQLException {
		    //입력하는 메소드, table 1:다이닝, 2:드링크
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
			System.out.println("메뉴이름 : " + rs.getString("name"));
			System.out.println("가격 : " + rs.getInt("price"));
			    
		    if(pstmt != null) 
				pstmt.close();
		    if(conn != null) 
				conn.close();
		}
	 public static void load(int table) throws ClassNotFoundException, SQLException {
		    //입력하는 메소드, table 1:다이닝, 2:드링크
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
				System.out.println("메뉴이름 : " + rs.getString("name"));
				System.out.println("가격 : " + rs.getInt("price"));
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
			System.out.println("1.추가, 2.수정, 3.삭제, 4.검색, 5.목록보기, 6.종료");
			int select = in.nextInt();
			String name;
			int price;
			
			switch (select)
			{
			case 1 : //메뉴 추가
				System.out.println("추가할 메뉴 입력 ");
				System.out.println("추가할 메뉴 종류 ");
				System.out.println("1: DiningMenu, 2: DrinkMenu");
				tablenum = in.nextInt();
				System.out.print("메뉴 이름 >> ");
				name = in.next();
				System.out.print("메뉴 가격 >> ");
				price = in.nextInt();
				insert(tablenum, name, price);
				
				break;
				
			case 2 : //메뉴 수정
				System.out.println("메뉴 수정");
				System.out.println("수정할 메뉴 종류 ");
				System.out.println("1: DiningMenu, 2: DrinkMenu");
				tablenum = in.nextInt();
				System.out.print("메뉴 이름 >> ");
				name = in.next();
				System.out.print("변경할 메뉴 이름 >> ");
				String updatename = in.next();
				System.out.print("변경할 메뉴 가격 >> ");
				price = in.nextInt();
				update(tablenum, name, price, updatename);
				break;
				
			case 3 : // 메뉴 삭제
				System.out.println("메뉴 삭제");
				System.out.println("삭제할 메뉴 종류 ");
				System.out.println("1: DiningMenu, 2: DrinkMenu");
				tablenum = in.nextInt();
				System.out.print("메뉴 이름 >> ");
				name = in.next();
				delete(tablenum, name);
				break;
			
			case 4 : // 메뉴 검색
				System.out.println("메뉴 검색");
				System.out.println("검색할 메뉴 종류 ");
				System.out.println("1: DiningMenu, 2: DrinkMenu");
				tablenum = in.nextInt();
				System.out.print("메뉴 이름 >> ");
				name = in.next();
				search(tablenum, name);
				break;
				
			case 5 : //전체 메뉴 로드
				System.out.println("메뉴 종류 ");
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
		
		System.out.print("관리자 ID 입력 >> ");
		String ID = in.next();
		System.out.print("관리자 PW 입력 >> ");
		String PW = in.next();
		
		if (ID.equals(ADMIN_ID) && PW.equals(ADMIN_PW))
		{
			managefunc();
		}
		else 
		{
			System.out.println("로그인 실패.");
			return;
		}
	}
	public static void main(String[] args)
	{
	}
}

