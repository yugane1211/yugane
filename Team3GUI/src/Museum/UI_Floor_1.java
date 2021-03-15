package Museum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Museum.UI_Floor_2.TOP5;

public class UI_Floor_1 extends JFrame {
	protected String userid=Login.t.getText();
	private JPanel contentPane;
	
	class TOP5 extends Thread{
		JLabel t;
		String[] top555;
		TOP5(JLabel t, String[] top555){
			this.t=t;
			this.top555=top555;
		}
		public void run() {
			int n=0;			
			while(true) {
				t.setText(top555[n]);
				n++;
				if(n==4) {
					n=0;
				}
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
			}
					
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Floor_1 frame = new UI_Floor_1();
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
	public UI_Floor_1() {
		setTitle("1��");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 830);
		setLocationRelativeTo(null);// ����� ���. 
		setResizable(false);// âũ�� ���� �Ұ� 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("1��");
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
		for (int h=0;h<Data_in_DB.check1_1f().length;h++) {
			comboBox.addItem(Data_in_DB.check1_1f()[h]);
		}
		comboBox.setSelectedItem(null);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("����", Font.PLAIN, 15));
		comboBox_1.setBounds(511, 25, 204, 32);
		panel.add(comboBox_1);
		Data_in_DB.connect();//sql �̿��� ����(�ߺ� ����)�� �ҷ��ͼ� üũ�ڽ��� �߰�
		for (int h=0;h<Data_in_DB.check2_1f().length;h++) {
			comboBox_1.addItem(Data_in_DB.check2_1f()[h]);
		}
		comboBox_1.setSelectedItem(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uD654\uAC00 \uC774\uB984");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 25, 108, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uAD6D\uAC00");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("����", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(396, 25, 108, 32);
		panel.add(lblNewLabel_1_1);
		
		JButton sear = new JButton("\uAC80 \uC0C9");
		sear.setBounds(804, 28, 153, 32);
		panel.add(sear);
		JButton res = new JButton("�ʱ�ȭ");
		res.setBounds(983, 28, 153, 32);
		panel.add(res);
		
		
		JPanel panel_1 = new JPanel() {
			public void paintComponent(Graphics g){
				ImageIcon im1=new ImageIcon("C:\\Users\\82105\\git\\yugane\\Team3GUI\\Floor_1.png");
				Image im1f=im1.getImage();
	            g.drawImage(im1f,0,9,null);
	            setOpaque(false);
	            super.paintComponent(g);
	        }
		};
		
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 999, 787);
		contentPane.add(panel_1);
		
		JButton bt_p001 = new JButton("1");
		bt_p001.setBounds(86, 58, 50, 30);
		panel_1.add(bt_p001);
		bt_p001.setOpaque(true); 

		JButton bt_p002 = new JButton("2");
		bt_p002.setBounds(417, 81, 50, 30);
		panel_1.add(bt_p002);
		bt_p002.setOpaque(true);
		
		JButton bt_p003 = new JButton("3");
		bt_p003.setBounds(512, 81, 50, 30);
		panel_1.add(bt_p003);
		bt_p003.setOpaque(true);
		
		JButton bt_p004 = new JButton("4");
		bt_p004.setBounds(649, 81, 50, 30);
		panel_1.add(bt_p004);
		bt_p004.setOpaque(true);
		
		JButton bt_p005 = new JButton("5");
		bt_p005.setBounds(746, 81, 50, 30);
		panel_1.add(bt_p005);
		bt_p005.setOpaque(true); 
		
		JButton bt_p006 = new JButton("6");
		bt_p006.setBounds(855, 81, 50, 30);
		panel_1.add(bt_p006);
		bt_p006.setOpaque(true); 
		
		JButton bt_p007 = new JButton("7");
		bt_p007.setBounds(626, 48, 50, 30);
		panel_1.add(bt_p007);
		bt_p007.setOpaque(true); 
		
		JButton bt_p008 = new JButton("8");
		bt_p008.setBounds(178, 214, 50, 30);
		panel_1.add(bt_p008);
		bt_p008.setOpaque(true); 
		
		JButton bt_p009 = new JButton("9");
		bt_p009.setBounds(180, 347, 50, 30);
		panel_1.add(bt_p009);
		bt_p009.setOpaque(true); 
		
		JButton bt_p010 = new JButton("10");
		bt_p010.setBounds(84, 268, 50, 30);
		panel_1.add(bt_p010);
		bt_p010.setOpaque(true);
		
		
		JButton bt_p011 = new JButton("11");
		bt_p011.setBounds(420, 150, 50, 30);
		panel_1.add(bt_p011);
		bt_p011.setOpaque(true); 
		
		JButton bt_p012 = new JButton("12");
		bt_p012.setBounds(512, 150, 50, 30);
		panel_1.add(bt_p012);
		bt_p012.setOpaque(true); 
		
		JButton bt_p013 = new JButton("13");
		bt_p013.setBounds(646, 150, 50, 30);
		panel_1.add(bt_p013);
		bt_p013.setOpaque(true); 
		
		JButton bt_p014 = new JButton("14");
		bt_p014.setBounds(745, 150, 50, 30);
		panel_1.add(bt_p014);
		bt_p014.setOpaque(true); 
		
		JButton bt_p015 = new JButton("15");
		bt_p015.setBounds(857, 149, 50, 30);
		panel_1.add(bt_p015);
		bt_p015.setOpaque(true); 
		
		///////////////////////////////////////////////////////
		// �� ��ȣ�� ��ư�� ������ �ش� �׸��� �̹����� ������ ��� â�� ȣ��
		bt_p001.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p001.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p002.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p002.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p003.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p003.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p004.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p004.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p005.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p005.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p006.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p006.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p007.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p007.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p008.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p008.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p009.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p009.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p010.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p010.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p011.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p011.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p012.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p012.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p013.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p013.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p014.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p014.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		bt_p015.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no=Integer.parseInt(bt_p015.getText())-1;
				String tex=Museum.Data_Storage.loadTxt_1f(no);
				new Museum.Pic_Exp_1f(no,tex);
			}
		});
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Top 5");
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 661, 157, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel topc = new JLabel("New label");//������
		topc.setFont(new Font("����", Font.PLAIN, 17));
		topc.setBounds(151, 662, 775, 38);
		contentPane.add(topc);
		Data_in_DB.connect();
		String[] top555=Data_in_DB.top_five();
		TOP5 lkk=new TOP5(topc, top555);
		lkk.start();
		
		JButton btnNewButton_1 = new JButton("2������");
		btnNewButton_1.setBounds(919, 670, 117, 29);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UI_Floor_2 f2=new UI_Floor_2();
				f2.setVisible(true);				
			}
		});
		JButton btnNewButton_2 = new JButton("�κ�� ����");
		btnNewButton_2.setBounds(1048, 670, 117, 29);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Lobby();
			}
		});
		
		JButton[] btngp= {bt_p001,bt_p002,bt_p003,bt_p004,bt_p005,
				bt_p006,bt_p007,bt_p008,bt_p009,bt_p010,bt_p011,bt_p012,
				bt_p013,bt_p014,bt_p015};
		sear.addActionListener(new ActionListener() {//Ư�� ���ǿ� ������ �˻�
			public void actionPerformed(ActionEvent e) {				
				int i1=comboBox.getSelectedIndex();
				String text1=comboBox.getItemAt(i1);
				int i2=comboBox_1.getSelectedIndex();
				String text2=comboBox_1.getItemAt(i2);
				Data_in_DB.connect();
				int[] numpic=Data_in_DB.bling_1f(text1, text2);
				
				for(int j=0;j<numpic.length;j++) {
					for(int i=0;i<btngp.length;i++) {	
						if(numpic[j]==Integer.parseInt(btngp[i].getText())) {
							btngp[i].setBackground(Color.yellow);							
						}
						
					}
				}
			}
		});
		res.addActionListener(new ActionListener() {//�˻����� �ʱ�ȭ
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<btngp.length;i++) {
					btngp[i].setBackground(Color.white);
				}
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
			}
		});

			
		
	}
}
