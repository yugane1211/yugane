package Museum;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Pic_Exp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pic_Exp frame = new Pic_Exp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public Pic_Exp(int a, String b) {//a : 그림 번호, b : a 를 data_storage에 있는 파일입력을 이용해 불러온 설명
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Data_in_DB.connect();
		String titl=Data_in_DB.picture_head(a);
		JLabel pic_lab = new JLabel(titl);
		pic_lab.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		pic_lab.setBounds(12, 10, 604, 57);
		contentPane.add(pic_lab);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(38, 77, 400, 400);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon expimg=new ImageIcon(Museum.Data_Storage.imglist2[a]);
		Image img=expimg.getImage();
		Image changim=img.getScaledInstance(450, 450, Image.SCALE_SMOOTH);//이미지의 사이즈 재조정
		ImageIcon ultimate=new ImageIcon(changim);
		
		lblNewLabel_1.setIcon(ultimate);
		contentPane.add(lblNewLabel_1);//그림 이미지가 들어가는 자리
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(468, 77, 425, 407);
		contentPane.add(scrollPane);
		

		
		
		textArea.setText(b);//그림에 대한 설명 집어넣기
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
		btnNewButton_1.setBounds(12, 493, 119, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("    \uD55C\uC904\uD3C9");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 536, 167, 25);
		contentPane.add(lblNewLabel_2);
		setVisible(true);
		
	}
}
