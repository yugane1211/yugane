package Museum;

import java.awt.BorderLayout;
import java.awt.Color;
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
	public Pic_Exp(int a, String b) {//a : �׸� ��ȣ, b : a �� data_storage�� �ִ� �����Է��� �̿��� �ҷ��� ����
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Data_in_DB.connect();
		String titl=Data_in_DB.picture_head(a);
		JLabel pic_lab = new JLabel(titl);
		pic_lab.setFont(new Font("����", Font.BOLD | Font.ITALIC, 15));
		pic_lab.setBounds(12, 10, 604, 57);
		contentPane.add(pic_lab);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(38, 77, 400, 400);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon expimg=new ImageIcon(Museum.Data_Storage.imglist2[a]);
		Image img=expimg.getImage();
		Image changim=img.getScaledInstance(450, 450, Image.SCALE_SMOOTH);//�̹����� ������ ������
		ImageIcon ultimate=new ImageIcon(changim);
		
		lblNewLabel_1.setIcon(ultimate);
		contentPane.add(lblNewLabel_1);//�׸� �̹����� ���� �ڸ�
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(468, 77, 425, 407);
		contentPane.add(scrollPane);
		

		
		
		textArea.setText(b);//�׸��� ���� ���� ����ֱ�
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
		btnNewButton_1.setBounds(22, 530, 119, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel comm = new JLabel("    \uD55C\uC904\uD3C9");
		comm.setHorizontalAlignment(SwingConstants.CENTER);
		comm.setFont(new Font("���� ���", Font.BOLD | Font.ITALIC, 16));
		comm.setBounds(12, 495, 139, 25);
		contentPane.add(comm);
		
		JPanel panel = new JPanel();//��������� �����س��� ���� - ���߿� ������ ���� ����
		panel.setBounds(163, 490, 700, 120);
		contentPane.add(panel);
		setVisible(true);
		//������ �߰��غ���!
		Data_in_DB.connect();
		String pic_com[]=Data_in_DB.comment(a);
		for(int i=0;i<pic_com.length;i++) {
			if(pic_com[i]!=null) {
			JLabel co=new JLabel(pic_com[i]);
			co.setBounds(0, 20*i, 700, 20);
			co.setForeground(Color.blue);
			panel.add(co);			
			}
		}
		
	}
}
