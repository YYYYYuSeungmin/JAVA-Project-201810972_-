import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
	public MyFrame() {
		this.setTitle("201810972_Kiosk");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnl = new JPanel();
		pnl.setLayout(null); //null 배치관리자
		
		//키오스크 상단 노란 배경의 메뉴판 라벨 생성
		JLabel Menu = new JLabel("메 뉴 판");
		Menu.setSize(400,100);
		Menu.setOpaque(true);
		Menu.setBackground(Color.yellow);
		Menu.setFont(new Font("Serif", Font.BOLD, 30));
		Menu.setHorizontalAlignment(JLabel.CENTER);
		Menu.setLocation(0,0);
		pnl.add(Menu);
		
		//키오스크 우측에 주문 정보가 표시될 회색 배경의 라벨 생성
		JLabel Order_bg = new JLabel();
		Order_bg.setSize(130,400);
		Order_bg.setOpaque(true);
		Order_bg.setBackground(Color.lightGray);
		Order_bg.setHorizontalAlignment(JLabel.CENTER);
		Order_bg.setLocation(270,100);
		pnl.add(Order_bg);
		
		//키오스크 메인에 표시될 메뉴들.
		ImageIcon pcicon = new ImageIcon("images/porkcutlet.jpg");
		ImageIcon cheeseicon = new ImageIcon("images/cheese.jpg");
		ImageIcon steakicon = new ImageIcon("images/steak.jpg");
		ImageIcon pastaicon = new ImageIcon("images/creampasta.jpg");
		
		JButton porkcutlet = new JButton(pcicon);
		JLabel porkcutlet_name = new JLabel("돈까스");
		JButton cheese_porkcutlet = new JButton(cheeseicon);
		JLabel cheese_name = new JLabel("치즈돈까스");		
		JButton steak = new JButton(steakicon);
		JLabel steak_name = new JLabel("스테이크");		
		JButton pasta = new JButton(pastaicon);	
		JLabel pasta_name = new JLabel("크림파스타");
		
		//버튼 사이즈 지정
		porkcutlet.setSize(70, 70);
		porkcutlet_name.setSize(70,30);
		cheese_porkcutlet.setSize(70,70);
		cheese_name.setSize(70,30);
		steak.setSize(70,70);
		steak_name.setSize(70,30);
		pasta.setSize(70,70);
		pasta_name.setSize(70,30);
		
		//버튼 위치 지정
		porkcutlet.setLocation(10,110);
		porkcutlet_name.setLocation(10, 180);
		porkcutlet_name.setHorizontalAlignment(SwingConstants.CENTER);
		
		cheese_porkcutlet.setLocation(100, 110);
		cheese_name.setLocation(100, 180);
		cheese_name.setHorizontalAlignment(SwingConstants.CENTER);
		
		steak.setLocation(190, 110);
		steak_name.setLocation(190, 180);
		steak_name.setHorizontalAlignment(SwingConstants.CENTER);
		pasta.setLocation(10, 230);
		pasta_name.setLocation(10, 300);
		pasta_name.setHorizontalAlignment(SwingConstants.CENTER);
		
		//버튼을 패널에 부착
		pnl.add(porkcutlet);
		pnl.add(porkcutlet_name);
		pnl.add(cheese_porkcutlet);
		pnl.add(cheese_name);
		pnl.add(steak);
		pnl.add(steak_name);
		pnl.add(pasta);
		pnl.add(pasta_name);
		
		this.add(pnl);
		this.setSize(400,500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		System.out.println("안녕");
	}
}
