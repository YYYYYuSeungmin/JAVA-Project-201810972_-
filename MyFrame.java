package JV_PJ_3week;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
	public MyFrame() {
		this.setTitle("test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		
		JLabel Menu = new JLabel("¸Þ ´º ÆÇ");
		Menu.setSize(400,100);
		Menu.setOpaque(true);
		Menu.setBackground(Color.yellow);
		Menu.setFont(new Font("Serif", Font.BOLD, 30));
		Menu.setHorizontalAlignment(JLabel.CENTER);
		Menu.setLocation(0,0);
		pnl.add(Menu);
		
		JLabel Order_bg = new JLabel();
		Order_bg.setSize(130,400);
		Order_bg.setOpaque(true);
		Order_bg.setBackground(Color.gray);
		Order_bg.setHorizontalAlignment(JLabel.CENTER);
		Order_bg.setLocation(270,100);
		pnl.add(Order_bg);
		
		JButton porkcutlet = new JButton("prokcutlet");
		JButton cheese_porkcutlet = new JButton("cheese prokcutlet");
		JButton steak = new JButton("steak");
		JButton pasta = new JButton("pasta");
		
		porkcutlet.setSize(70,70);
		cheese_porkcutlet.setSize(70,70);
		steak.setSize(70,70);
		pasta.setSize(70,70);
		
		porkcutlet.setLocation(10,110);
		cheese_porkcutlet.setLocation(100, 110);
		steak.setLocation(190, 110);
		pasta.setLocation(10, 190);
		pnl.add(porkcutlet);
		pnl.add(cheese_porkcutlet);
		pnl.add(steak);
		pnl.add(pasta);
		
		this.add(pnl);
		this.setSize(400,500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}
}
