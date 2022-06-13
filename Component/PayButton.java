package Component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Kiosk.Main;

public class PayButton extends JButton
{
	public PayButton(JPanel panel)
	{
		this.setText("결제하기");
		this.setSize(170,50);
		this.setFont(new Font("SanSerif", Font.BOLD, 15));
		this.setLocation(170,550);
		this.addActionListener(new payClick());
		
		panel.add(this);
	}
	
	//결제하기 버튼
	public class payClick implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//주문중이던 내역 초기화
			OrderList.TotalPrice.setText("0");
			OrderList.orderHistory.clear();
			Main.newMP();
			
			JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.", "결제 정보", JOptionPane.INFORMATION_MESSAGE);
			
			/*JFrame finish = new JFrame();
			finish.setTitle("결제 정보");
			finish.setSize(300,100);
			JLabel finishLabel = new JLabel("결제가 완료되었습니다.");
			finishLabel.setHorizontalAlignment(JLabel.CENTER);
			finishLabel.setFont(new Font("SanSerif", Font.BOLD, 15));
			finish.add(finishLabel);
			finish.setVisible(true);*/
		}
	}
}
