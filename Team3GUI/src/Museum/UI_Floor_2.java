package Museum;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Point;

public class UI_Floor_2 extends JFrame {
	protected String userid=Login.t.getText();
	private JPanel contentPane;
	ImageIcon im2=new ImageIcon("C:\\Users\\82105\\git\\yugane\\Team3GUI\\Floor_2.png");
	Image im2f=im2.getImage();
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
	 * Create the frame.
	 */
	public UI_Floor_2() {
		setTitle("2층");
		setLocation(new Point(0, 0));
		setBackground(Color.white);
		setBounds(100, 100, 1015, 830);
		setLocationRelativeTo(null);
		contentPane = new JPanel();//전체 창
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JPanel panel_1 = new JPanel() {
			public void paintComponent(Graphics g){	            
	            g.drawImage(im2f,0,9,null);
	            setOpaque(false);
	            super.paintComponent(g);
	        }
		};
		
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 999, 787);
		contentPane.add(panel_1);
		
		//but1~15 : 클릭시 각 그림의 이미지와 설명이 담긴 패널이 나옴
		JButton but1 = new JButton("016");
		but1.setBounds(598, 455, 53, 41);
		panel_1.add(but1);
		but1.setOpaque(true);
		
		
		JButton but2 = new JButton("017");
		but2.setBounds(652, 455, 53, 41);
		panel_1.add(but2);

		
		JButton but3 = new JButton("018");
		but3.setBounds(553, 502, 53, 41);
		panel_1.add(but3);
		
		JButton but4 = new JButton("019");
		but4.setBounds(606, 502, 53, 41);
		panel_1.add(but4);
		
		JButton but5 = new JButton("020");
		but5.setBounds(659, 502, 53, 41);
		panel_1.add(but5);
		
		JButton but6 = new JButton("021");
		but6.setBounds(252, 453, 71, 43);
		panel_1.add(but6);
		
		JButton but7 = new JButton("022");
		but7.setBounds(326, 453, 71, 43);
		panel_1.add(but7);
		
		JButton but8 = new JButton("023");
		but8.setBounds(252, 502, 71, 43);
		panel_1.add(but8);
		
		JButton but9 = new JButton("024");
		but9.setBounds(326, 502, 71, 43);
		panel_1.add(but9);
		
		JButton but10 = new JButton("025");
		but10.setBounds(290, 551, 67, 43);
		panel_1.add(but10);
		
		JButton but11 = new JButton("026");
		but11.setBounds(365, 551, 63, 43);
		panel_1.add(but11);
		
		JButton but12 = new JButton("027");
		but12.setBounds(708, 502, 70, 41);
		panel_1.add(but12);
		
		JButton but13 = new JButton("028");
		but13.setBounds(707, 455, 71, 41);
		panel_1.add(but13);
		
		JButton but14 = new JButton("029");
		but14.setBounds(778, 681, 81, 46);
		panel_1.add(but14);
		
		JButton but15 = new JButton("030");
		but15.setBounds(860, 681, 74, 46);
		panel_1.add(but15);
		
		JComboBox<String> anames = new JComboBox<String>();
		anames.setBounds(736, 74, 204, 32);
		panel_1.add(anames);
		anames.setFont(new Font("굴림", Font.PLAIN, 15));
		Data_in_DB.connect();//sql을 이용해 화가 이름(중복 제거)을 불러와서 체크박스에 추가
		for (int h=0;h<Data_in_DB.check1().length;h++) {
			anames.addItem(Data_in_DB.check1()[h]);
		}
		anames.setSelectedItem(null);//초기에 설정된 항목이 없게 만드는 명령
		
		JLabel acounLabel = new JLabel("\uAD6D\uAC00");
		acounLabel.setBounds(625, 116, 108, 32);
		panel_1.add(acounLabel);
		acounLabel.setHorizontalAlignment(SwingConstants.CENTER);
		acounLabel.setFont(new Font("굴림", Font.ITALIC, 16));
		
		JComboBox<String> coun = new JComboBox<String>();
		coun.setBounds(736, 116, 204, 32);
		panel_1.add(coun);
		coun.setFont(new Font("굴림", Font.PLAIN, 15));
		Data_in_DB.connect();//sql 이용해 국가(중복 제거)를 불러와서 체크박스에 추가
		for (int h=0;h<Data_in_DB.check2().length;h++) {
			coun.addItem(Data_in_DB.check2()[h]);
		}
		coun.setSelectedItem(null);
		
		JButton SEAR = new JButton("\uAC80 \uC0C9");
		SEAR.setBounds(635, 158, 153, 32);
		panel_1.add(SEAR);
		
		JButton RESET = new JButton("\uCD08\uAE30\uD654");
		RESET.setBounds(796, 158, 144, 32);
		panel_1.add(RESET);
		
		
		
		JLabel anameLabel = new JLabel("\uD654\uAC00 \uC774\uB984");
		anameLabel.setBounds(625, 74, 108, 32);
		panel_1.add(anameLabel);
		anameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		anameLabel.setFont(new Font("굴림", Font.ITALIC, 16));
		
		JLabel lblNewLabel = new JLabel("Floor 2");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(37, 17, 157, 43);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 23));
		
		JButton GoToFirst = new JButton("1\uCE35\uC73C\uB85C");//1층 화면으로 전환
		GoToFirst.setBounds(675, 745, 136, 30);
		panel_1.add(GoToFirst);
		GoToFirst.setBackground(new Color(255, 255, 204));
		GoToFirst.setFont(new Font("새굴림", Font.BOLD, 17));
		
			
		JButton LobbyBut = new JButton("\uB85C\uBE44\uB85C \uB098\uAC00\uAE30");//로비로 나가기
		LobbyBut.setBounds(823, 745, 164, 30);
		panel_1.add(LobbyBut);
		LobbyBut.setBackground(new Color(255, 255, 204));
		LobbyBut.setFont(new Font("새굴림", Font.BOLD, 17));			
			
		JLabel lblNewLabel_2 = new JLabel("Top 5");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(12, 740, 100, 38);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			
		JLabel topc = new JLabel();//탑 5 그림의 제목, 화가가 표출될 예정(스레드 이용)
		topc.setForeground(Color.BLUE);
		topc.setBounds(115, 740, 403, 38);
		panel_1.add(topc);
		topc.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 21));
			
		Data_in_DB.connect();
		String[] top555=Data_in_DB.top_five();
		TOP5 lkk=new TOP5(topc, top555);
		lkk.start();
		
		LobbyBut.addActionListener(new ActionListener() {//누르면 로비로 돌아가기
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Lobby();
			}
		});
		GoToFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UI_Floor_1 f1=new UI_Floor_1();
				f1.setVisible(true);				
			}
		});
		JButton[] btngp= {but1,but2,but3,but4,but5,but6,but7,but8,but9,but10,but11,but12,but13,but14,but15};
		for(int i=0;i<15;i++) {
			btngp[i].setBackground(new Color(108,54,77));
			btngp[i].setForeground(Color.yellow);
		}
		RESET.addActionListener(new ActionListener() {//검색조건 초기화
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<btngp.length;i++) {
					btngp[i].setBackground(new Color(108,54,77));
					btngp[i].setForeground(Color.yellow);
				}
				anames.setSelectedItem(null);
				coun.setSelectedItem(null);
			}
		});
		SEAR.addActionListener(new ActionListener() {//특정 조건에 맞으면 검색
			public void actionPerformed(ActionEvent e) {				
				int i1=anames.getSelectedIndex();
				String text1=anames.getItemAt(i1);
				int i2=coun.getSelectedIndex();
				String text2=coun.getItemAt(i2);
				Data_in_DB.connect();
				int[] numpic=Data_in_DB.bling(text1, text2);
				
				for(int j=0;j<numpic.length;j++) {
					for(int i=0;i<btngp.length;i++) {	
						if(numpic[j]==Integer.parseInt(btngp[i].getText())) {
							btngp[i].setBackground(Color.yellow);
							btngp[i].setForeground(Color.gray);
						}
						
					}
				}
			}
		});
		
		
		
		
		//각 버튼의 값을 이용해서 해당하는 그림번호의 그림이 설명되어있는 Pic_Exp 프레임 소환
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
