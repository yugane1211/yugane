package Museum;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class UI_Floor_2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Floor_2 frame = new UI_Floor_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_Floor_2() {
		
		setBounds(100, 100, 1191, 746);
		contentPane = new JPanel();//��ü â
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("2\uCE35");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 10, 157, 43);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 49, 1153, 87);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("����", Font.PLAIN, 15));
		comboBox.setBounds(127, 25, 204, 32);
		panel.add(comboBox);
		Data_in_DB.connect();//sql�� �̿��� ȭ�� �̸�(�ߺ� ����)�� �ҷ��ͼ� üũ�ڽ��� �߰�
		for (int h=0;h<Data_in_DB.check1().length;h++) {
			comboBox.addItem(Data_in_DB.check1()[h]);
		}
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("����", Font.PLAIN, 15));
		comboBox_1.setBounds(624, 25, 204, 32);
		panel.add(comboBox_1);
		Data_in_DB.connect();//sql �̿��� ����(�ߺ� ����)�� �ҷ��ͼ� üũ�ڽ��� �߰�
		for (int h=0;h<Data_in_DB.check2().length;h++) {
			comboBox_1.addItem(Data_in_DB.check2()[h]);
		}
		
		JLabel lblNewLabel_1 = new JLabel("\uD654\uAC00 \uC774\uB984");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 25, 108, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uAD6D\uAC00");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(511, 25, 108, 32);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("\uAC80 \uC0C9");
		btnNewButton.setBounds(954, 25, 153, 32);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setLayout(null);
		JLabel image2=new JLabel(new ImageIcon("C:\\Users\\82105\\git\\yugane\\Team3GUI\\Floor2.jpg"));
		image2.setOpaque(true);
		panel_1.add(image2);
		panel_1.setBounds(12, 136, 1153, 504);
		image2.setBounds(0, 0, 1153, 504);
		contentPane.add(panel_1);
		
		//but1~15 : Ŭ���� �� �׸��� �̹����� ������ ��� �г��� ����
		JButton but1 = new JButton("016");
		but1.setBackground(Color.WHITE);
		but1.setBounds(337, 109, 93, 52);
		panel_1.add(but1);
		but1.setOpaque(true);
		
		
		JButton but2 = new JButton("017");
		but2.setBounds(433, 109, 93, 52);
		panel_1.add(but2);
		but2.setBackground(Color.WHITE);
		
		JButton but3 = new JButton("018");
		but3.setBackground(Color.WHITE);
		but3.setBounds(529, 109, 93, 52);
		panel_1.add(but3);
		
		JButton but4 = new JButton("019");
		but4.setBackground(Color.WHITE);
		but4.setBounds(722, 109, 93, 52);
		panel_1.add(but4);
		
		JButton but5 = new JButton("020");
		but5.setBackground(Color.WHITE);
		but5.setBounds(819, 109, 93, 52);
		panel_1.add(but5);
		
		JButton but6 = new JButton("021");
		but6.setBackground(Color.WHITE);
		but6.setBounds(912, 109, 93, 52);
		panel_1.add(but6);
		
		JButton but7 = new JButton("022");
		but7.setBackground(Color.WHITE);
		but7.setBounds(337, 10, 93, 52);
		panel_1.add(but7);
		
		JButton but8 = new JButton("023");
		but8.setBackground(Color.WHITE);
		but8.setBounds(433, 10, 93, 52);
		panel_1.add(but8);
		
		JButton but9 = new JButton("024");
		but9.setBackground(Color.WHITE);
		but9.setBounds(529, 10, 93, 52);
		panel_1.add(but9);
		
		JButton but10 = new JButton("025");
		but10.setBackground(Color.WHITE);
		but10.setBounds(722, 10, 93, 52);
		panel_1.add(but10);
		
		JButton but11 = new JButton("026");
		but11.setBackground(Color.WHITE);
		but11.setBounds(819, 10, 93, 52);
		panel_1.add(but11);
		
		JButton but12 = new JButton("027");
		but12.setBackground(Color.WHITE);
		but12.setBounds(912, 10, 93, 52);
		panel_1.add(but12);
		
		JButton but13 = new JButton("028");
		but13.setBackground(Color.WHITE);
		but13.setBounds(819, 442, 93, 52);
		panel_1.add(but13);
		
		JButton but14 = new JButton("029");
		but14.setBackground(Color.WHITE);
		but14.setBounds(930, 442, 93, 52);
		panel_1.add(but14);
		
		JButton but15 = new JButton("030");
		but15.setBackground(Color.WHITE);
		but15.setBounds(1048, 442, 93, 52);
		panel_1.add(but15);
		
		JLabel lblNewLabel_2 = new JLabel("Top 5");
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 661, 157, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel topc = new JLabel("New label");//ž 5 �׸��� ����, ȭ���� ǥ��� ����(������ �̿�)
		topc.setFont(new Font("����", Font.PLAIN, 17));
		topc.setBounds(151, 662, 775, 38);
		contentPane.add(topc);
		
		JButton btnNewButton_1 = new JButton("\uB85C\uBE44\uB85C \uB098\uAC00\uAE30");//�κ�� ������
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.setFont(new Font("HY������M", Font.BOLD, 17));
		btnNewButton_1.setBounds(977, 656, 188, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("1\uCE35\uC73C\uB85C");//1�� ȭ������ ��ȯ
		btnNewButton_2.setBackground(new Color(255, 255, 204));
		btnNewButton_2.setFont(new Font("HY������M", Font.BOLD, 17));
		btnNewButton_2.setBounds(777, 656, 188, 43);
		contentPane.add(btnNewButton_2);
		
		//�� ��ư�� ���� �̿��ؼ� �ش��ϴ� �׸���ȣ�� �׸��� ����Ǿ��ִ� Pic_Exp ������ ��ȯ
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but1.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but2.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but3.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);		
			}
		});
		but4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but4.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but5.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but6.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but7.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but8.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but9.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but10.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but11.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but12.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but13.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but14.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
		but15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(but15.getText())-16;
				String tex=Museum.Data_Storage.loadTxt(no);
				new Museum.Pic_Exp(no,tex);
			}
		});
	}
}
