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
		setSize(700, 500);
		setLocationRelativeTo(null);
		c.setLayout(null);
		
		JButton f1st = new JButton("1st Floor");	
		f1st.setBounds(500, 150, 100, 30);
		f1st.setBackground(Color.white);
		f1st.setFocusable(false);
		f1st.addActionListener(new ActionListener() {//������ �κ�ȭ�� ������鼭 1�� ȭ������
			public void actionPerformed(ActionEvent e) {
				UI_Floor_1 FirstFloor = new UI_Floor_1();
				FirstFloor.setVisible(true);
				setVisible(false);				
			}
		});
		
		JButton f2nd = new JButton("2nd Floor");
		f2nd.setBounds(500, 200, 100, 30);
		f2nd.setBackground(Color.white);
		f2nd.setFocusable(false);
		f2nd.addActionListener(new ActionListener() {//������ �κ�ȭ�� ������鼭 2�� ȭ������
			public void actionPerformed(ActionEvent e) {
				UI_Floor_2 SecondFloor = new UI_Floor_2();
				SecondFloor.setVisible(true);
				setVisible(false);				
			}
		});
		
		JButton sto = new JButton("Storage");//��ǰ ������ Ű �޴� �� - ����
		sto.setBounds(500, 300, 100, 30);
		sto.setBackground(Color.white);
		sto.setFocusable(false);
		sto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Storage();				
				sto.setEnabled(false);
				sto.setBackground(Color.GRAY);
			}
		});
		
		JButton notice = new JButton("Notice");//�������� ���� ��ư
		notice.setBounds(500, 250, 100, 30);
		notice.setBackground(Color.white);
		notice.setFocusable(false);
		notice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Notice not = new Notice();
				not.setVisible(true);
			}
		});
		
		JButton logout = new JButton("Logout");//Logout
		logout.setBounds(500, 350, 100, 30);
		logout.setBackground(Color.white);
		logout.setFocusable(false);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r=JOptionPane.showConfirmDialog(null,"�α׾ƿ��Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_OPTION);	              
	            if(r==JOptionPane.YES_OPTION) {
	                	JOptionPane.showMessageDialog(null, "�α׾ƿ��߽��ϴ�.","",JOptionPane.INFORMATION_MESSAGE);
	                	setVisible(false);
                	 	new Login();
	                  }
			}			
		});
		Data_in_DB.connect();
		String mycomment=Data_in_DB.Mycomm(userid);
		String[] mycommspl=mycomment.split(",");
		int h=0;
		for(String j : mycommspl) {
			if(j!=null) {
				JLabel comment=new JLabel(j);
				comment.setForeground(Color.yellow);
				comment.setBounds(50,110+30*h,400,26);
				c.add(comment);
				h++;
			}
		}

		
		
		ImageIcon back = new ImageIcon("brooklyn-museum.jpg");
		Image img11 = back.getImage();
		Image size = img11.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
		ImageIcon back1 = new ImageIcon(size);
		JLabel back2 = new JLabel(back1);
		back2.setBounds(0, 0, 700, 500);
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yy�� MM�� dd��");
		Date date = new Date();
		JLabel cho=new JLabel("Date: "+dateformat.format(date));
		cho.setFont(new Font("SanSerif", Font.BOLD, 15));
		cho.setBounds(360,30, 150, 30);
		
		
		JLabel name = new JLabel("ID : "+userid);
		//jdbc �α����� ȸ�� ���̵� ��������
		name.setFont(new Font("SanSerif", Font.BOLD, 15));
		name.setBounds(530, 30, 150, 30);
		
		
		c.add(f1st);
		c.add(f2nd);
		c.add(sto);
		c.add(notice);
		
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
		
		JLabel bb = new JLabel("������ �繰�� ��ȣ��?");
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
