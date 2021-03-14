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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
public class Pic_Exp_1f extends JFrame{
	protected String userid=Login.t.getText();
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
		
		JButton btnNewButton = new JButton("\uB2EB\uAE30");//닫기
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(738, 20, 155, 35);
		contentPane.add(btnNewButton);
		
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
		comm_in.setLayout(null);
		contentPane.add(comm_in);
		setVisible(true);
		//한줄평 추가해보기!
		Data_in_DB.connect();
		String pic_com[]=Data_in_DB.comment(a+1);
		JLabel [] comd=new JLabel[pic_com.length];
		for(int i=0;i<pic_com.length;i++) {
			if(pic_com[i]!=null) {
				comd[i]=new JLabel(pic_com[i]);
				comd[i].setBounds(0, 20*i, 700, 20);
				comm_in.add(comd[i]);
				comd[i].setOpaque(true);
				comd[i].setVisible(true);
			}
		}
		
		Data_in_DB.connect();
		int countt=Data_in_DB.show_count(a+1);
		JLabel like_count = new JLabel(Integer.toString(countt));
		like_count.setBounds(16, 575, 125, 32);
		contentPane.add(like_count);
		
		JTextField textField = new JTextField();
		textField.setBounds(163, 616, 590, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton up = new JButton("\uB4F1\uB85D");
		up.setBounds(772, 615, 91, 23);
		contentPane.add(up);
		up.addActionListener(new ActionListener() {//한줄평 등록
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "등록되었습니다.","",JOptionPane.INFORMATION_MESSAGE);
				String conte=textField.getText();
				Data_in_DB.connect();
				Data_in_DB.updatecomment((a+1),userid,conte);
				setVisible(false);
				new Pic_Exp_1f(a, b);
			}
		});
		like.addActionListener(new ActionListener() {//좋아요 버튼 누르면 그림에 대한 좋아요 수 증가
			public void actionPerformed(ActionEvent e) {
				Data_in_DB.connect();
				Data_in_DB.lik_count(a+1);
				Data_in_DB.connect();
				int updatedup=Data_in_DB.show_count(a+1);
				like_count.setText(Integer.toString(updatedup));
			}
		});
	}
}
