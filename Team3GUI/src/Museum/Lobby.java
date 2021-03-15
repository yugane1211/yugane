package Museum;


import java.awt.*;

import java.awt.List;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class Lobby extends JFrame{
	protected String userid=Login.t.getText();
	Lobby(){
		new Notice();
		Container c = getContentPane();
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lobby");
		setSize(980,713);
		setLocationRelativeTo(null);
		c.setLayout(null);
		
		JButton f1st = new JButton("1st Floor");	
		f1st.setBounds(750, 150, 100, 30);
		f1st.setBackground(Color.white);
		f1st.setFocusable(false);
		f1st.addActionListener(new ActionListener() {//누르면 로비화면 사라지면서 1층 화면으로
			public void actionPerformed(ActionEvent e) {
				UI_Floor_1 FirstFloor = new UI_Floor_1();
				FirstFloor.setVisible(true);
				setVisible(false);				
			}
		});
		
		JButton f2nd = new JButton("2nd Floor");
		f2nd.setBounds(750, 200, 100, 30);
		f2nd.setBackground(Color.white);
		f2nd.setFocusable(false);
		f2nd.addActionListener(new ActionListener() {//누르면 로비화면 사라지면서 2층 화면으로
			public void actionPerformed(ActionEvent e) {
				UI_Floor_2 SecondFloor = new UI_Floor_2();
				SecondFloor.setVisible(true);
				setVisible(false);				
			}
		});
		
		JButton sto = new JButton("Storage");//물품 보관함 키 받는 곳 - 랜덤
		sto.setBounds(750, 300, 100, 30);
		sto.setBackground(Color.white);
		sto.setFocusable(false);
		sto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Storage();				
				sto.setEnabled(false);
				sto.setBackground(Color.GRAY);
			}
		});
		
		JButton notice = new JButton("Notice");//공지사항 띄우는 버튼
		notice.setBounds(750, 250, 100, 30);
		notice.setBackground(Color.white);
		notice.setFocusable(false);
		notice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notice not = new Notice();
				not.setVisible(true);
			}
		});
		
		JButton logout = new JButton("Logout");//Logout
		logout.setBounds(750, 350, 100, 30);
		logout.setBackground(Color.white);
		logout.setFocusable(false);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r=JOptionPane.showConfirmDialog(null,"로그아웃하시겠습니까?","확인",JOptionPane.YES_OPTION);	              
	            if(r==JOptionPane.YES_OPTION) {
	                	JOptionPane.showMessageDialog(null, "로그아웃했습니다.","",JOptionPane.INFORMATION_MESSAGE);
	                	setVisible(false);
                	 	new Login();
	                  }
			}			
		});
		Data_in_DB.connect();
		String mycomment=Data_in_DB.Mycomm(userid);
		String[] mycommspl=mycomment.split(",");
		JTextArea comms=new JTextArea();
		JScrollPane scr=new JScrollPane(comms);
		scr.setBounds(50, 500,850,100);
		comms.setFont(new Font("굴림",Font.BOLD,20));
		comms.setForeground(Color.blue);
		int h=0;
		String str="";
		comms.setText(str);
		for(String j : mycommspl) {
			if(j!=null) {
				comms.append(j+"\n");
				h++;
			}
		}
		comms.setCaretPosition(0);
		comms.setEditable(false);
		
		
		ImageIcon back = new ImageIcon("C:\\Users\\82105\\git\\yugane\\Team3GUI\\Lobby.jpg");
		Image img11 = back.getImage();
		Image size = img11.getScaledInstance(980, 713, Image.SCALE_SMOOTH);
		ImageIcon back1 = new ImageIcon(size);
		JLabel back2 = new JLabel(back1);
		back2.setBounds(0, 0, 980, 713);
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yy년 MM월 dd일");
		Date date = new Date();
		JLabel cho=new JLabel("Date: "+dateformat.format(date));
		cho.setFont(new Font("SanSerif", Font.BOLD, 15));
		cho.setBounds(300,30, 200, 30);
		
		
		JLabel name = new JLabel("ID : "+userid);
		//jdbc 로그인한 회원 아이디 가져오기
		name.setFont(new Font("SanSerif", Font.BOLD, 15));
		name.setBounds(530, 30, 150, 30);
		
		
		c.add(f1st);
		c.add(f2nd);
		c.add(sto);
		c.add(notice);
		c.add(scr);
		c.add(name);
		c.add(cho);
		c.add(logout);
		c.add(back2);
		
		
		setVisible(true);	
	
	}
	
	class Notice extends JFrame{
		Notice(){
			Container c=getContentPane();
			setTitle("Notice");
			setSize(300,300);
			c.setLayout(null);
			
			String ext="";
			String brr="";
			
			try {
				FileReader in=new FileReader("notice1.txt");
				BufferedReader br = new BufferedReader(in);
				while((brr=br.readLine())!=null) {
					ext+=brr+"\n";
				}
				
				br.close();
				in.close();
		
			}catch (IOException e) {}
			
			TextArea notice = new TextArea();
			notice.setText(ext);
			notice.setBounds(0, 0, 300, 300);
			
			setLocationRelativeTo(null);
			
			c.add(notice, BorderLayout.CENTER);
			
			
		}
	}
	
class Storage extends JDialog{
	Storage(){
		Container c=getContentPane();
		setSize(300,150);
		setTitle("Storage");
		c.setLayout(null);
		
		ImageIcon lock = new ImageIcon("baggage-lockers.png");
		Image lock1 = lock.getImage();
		Image size = lock1.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		ImageIcon back1 = new ImageIcon(size);
		JLabel back2 = new JLabel(back1);
		back2.setBounds(15, 15, 70, 70);
		
		JLabel bb = new JLabel("고객님의 사물함 번호는?");
		bb.setBounds(100,20, 200, 30);
		
		int a= ((int)(Math.random()*99)+1);
		JLabel aa = new JLabel(String.valueOf(a));
		aa.setFont(new Font("SanSerif", Font.BOLD, 15));
		aa.setBounds(150, 40, 100, 50);
		
		setLocationRelativeTo(null);
		
		c.add(aa);
		c.add(bb);
		c.add(back2);
		setVisible(true);
		}
	}
		
	public static void main(String[] args) {
		
		new Lobby(); 
	}
}
