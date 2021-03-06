package Museum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class Pic_Exp extends JFrame {
	protected String userid=Login.t.getText();
	private JPanel contentPane;
	private JTextField textField;

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
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Data_in_DB.connect();
		String titl=Data_in_DB.picture_head(a);
		JLabel pic_lab = new JLabel(titl);
		pic_lab.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		pic_lab.setBounds(12, 10, 604, 57);
		contentPane.add(pic_lab);
		
		JLabel setIm = new JLabel("");
		setIm.setBounds(38, 77, 400, 400);
		setIm.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon expimg=new ImageIcon(Museum.Data_Storage.imglist2[a]);
		Image img=expimg.getImage();
		Image changim=img.getScaledInstance(350, 400, Image.SCALE_SMOOTH);//이미지의 사이즈 재조정
		ImageIcon ultimate=new ImageIcon(changim);
		
		setIm.setIcon(ultimate);
		contentPane.add(setIm);//그림 이미지가 들어가는 자리
		JTextArea ImExp = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(ImExp);
		scrollPane.setBounds(468, 77, 425, 407);
		contentPane.add(scrollPane);
		

		
		
		ImExp.setText(b);//그림에 대한 설명 집어넣기
		ImExp.setEditable(false);
		ImExp.setCaretPosition(0);
		JButton clo = new JButton("\uB2EB\uAE30");
		clo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		clo.setBounds(738, 20, 155, 35);
		contentPane.add(clo);
		
		JButton like = new JButton("\uC88B\uC544\uC694");
		like.setBounds(22, 530, 119, 35);
		contentPane.add(like);
		
		
		JLabel comm = new JLabel("    \uD55C\uC904\uD3C9");
		comm.setHorizontalAlignment(SwingConstants.CENTER);
		comm.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 16));
		comm.setBounds(12, 495, 139, 25);
		contentPane.add(comm);
		
		JPanel comm_in = new JPanel();//한줄평들을 나열해놓을 공간 - 나중에 수정할 수도 있음
		comm_in.setBounds(163, 490, 700, 120);
		comm_in.setBackground(Color.LIGHT_GRAY);
		comm_in.setLayout(null);
		contentPane.add(comm_in);
		
		Data_in_DB.connect();
		int countt=Data_in_DB.show_count(a+16);
		JLabel like_count = new JLabel(Integer.toString(countt));
		like_count.setForeground(Color.BLUE);
		like_count.setFont(new Font("굴림", Font.BOLD, 17));
		like_count.setHorizontalAlignment(SwingConstants.CENTER);
		like_count.setBounds(16, 575, 125, 32);
		contentPane.add(like_count);
		
		textField = new JTextField();
		textField.setBounds(163, 616, 590, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton up = new JButton("\uB4F1\uB85D");
		up.setBounds(772, 615, 91, 23);
		contentPane.add(up);
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "등록되었습니다.","",JOptionPane.INFORMATION_MESSAGE);
				String conte=textField.getText();
				Data_in_DB.connect();
				Data_in_DB.updatecomment((a+16),userid,conte);
				setVisible(false);
				new Pic_Exp(a, b);
			}
		});
		
		
		Data_in_DB.connect();
		String pic_com[]=Data_in_DB.comment(a+16);
		JLabel [] comd=new JLabel[pic_com.length];//각 그림들에 대한 한줄평들이 순서대로 띄워짐
		for(int i=0;i<pic_com.length;i++) {
			if(pic_com[i]!=null) {
				comd[i]=new JLabel(pic_com[i]);
				comd[i].setBounds(6, 20*i, 700, 20);
				comd[i].setBackground(Color.LIGHT_GRAY);
				comd[i].setFont(new Font("굴림",Font.BOLD,16));
				comd[i].setForeground(Color.blue);
				comm_in.add(comd[i]);
				comd[i].setOpaque(true);
				comd[i].setVisible(true);
			}
		}
		like.addActionListener(new ActionListener() {//좋아요 버튼 누르면 그림에 대한 좋아요 수 증가
			public void actionPerformed(ActionEvent e) {
				Data_in_DB.connect();
				Data_in_DB.lik_count(a+16);
				Data_in_DB.connect();
				int updatedup=Data_in_DB.show_count(a+16);
				like_count.setText(Integer.toString(updatedup));
				like.setEnabled(false);
			}
		});
		setVisible(true);
	}
}
