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
		this.setText("�����ϱ�");
		this.setSize(170,50);
		this.setFont(new Font("SanSerif", Font.BOLD, 15));
		this.setLocation(170,550);
		this.addActionListener(new payClick());
		
		panel.add(this);
	}
	
	//�����ϱ� ��ư
	public class payClick implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//�ֹ����̴� ���� �ʱ�ȭ
			OrderList.TotalPrice.setText("0");
			OrderList.orderHistory.clear();
			Main.newMP();
			
			JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "���� ����", JOptionPane.INFORMATION_MESSAGE);
			
			/*JFrame finish = new JFrame();
			finish.setTitle("���� ����");
			finish.setSize(300,100);
			JLabel finishLabel = new JLabel("������ �Ϸ�Ǿ����ϴ�.");
			finishLabel.setHorizontalAlignment(JLabel.CENTER);
			finishLabel.setFont(new Font("SanSerif", Font.BOLD, 15));
			finish.add(finishLabel);
			finish.setVisible(true);*/
		}
	}
}
