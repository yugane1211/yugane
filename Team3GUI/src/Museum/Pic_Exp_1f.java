package Museum;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
public class Pic_Exp_1f extends JFrame{
	private JPanel contentPane;
	public Pic_Exp_1f(int a, String b) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Data_in_DB.connect();
		String titl=Data_in_DB.picture_head_1f(a);//그림이름,작가,국가가 왼쪽 상단에
		JLabel lblNewLabel = new JLabel(titl);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(12, 10, 604, 57);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(38, 77, 400, 400);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon expimg = new ImageIcon(Museum.Data_Storage.imglist1[a]);
		Image img = expimg.getImage();
		Image changim = img.getScaledInstance(350, 400, Image.SCALE_SMOOTH);
		ImageIcon ultimate = new ImageIcon(changim);
		
		lblNewLabel_1.setIcon(ultimate);
		contentPane.add(lblNewLabel_1);
	
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(468, 77, 425, 407);
		contentPane.add(scrollPane);
		

		
		
		textArea.setText(b);
		textArea.setEditable(false);
		textArea.setCaretPosition(0);
		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(738, 20, 155, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC88B\uC544\uC694");
		btnNewButton_1.setBounds(738, 20, 155, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uD55C\uC904\uD3C9");
		lblNewLabel_2.setBounds(738, 20, 155, 35);
		contentPane.add(lblNewLabel_2);
		setVisible(true);
	}
}
