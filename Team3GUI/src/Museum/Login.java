package Museum;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	Login(){	      
	      super("�α��� â");
	      Container c=getContentPane();	      
	      JPanel p=new JPanel();	      
	      setLayout(null);
	      setBounds(90,90,400,450);
	      setLocationRelativeTo(null);
	      JLabel j1=new JLabel("3team");
	      j1.setFont(new Font("�ü�", Font.PLAIN, 30));
	      j1.setBounds(100, 0, 200, 200);
	      

	      JLabel j4=new JLabel("3team�� ���Ű� ȯ���մϴ�.");
	      j4.setFont(new Font("�������", Font.PLAIN, 15));
	      j4.setBounds(100, 40, 200, 200);
	      
	      
	      JTextField t=new JTextField(20);
	      t.setBounds(130, 180, 120, 20);
	      
	      JLabel j2=new JLabel("���̵�");
	      j2.setFont(new Font("�������", Font.PLAIN, 14));
	      j2.setBounds(70, 140 , 100, 100);
	      
	      JLabel j3=new JLabel("��й�ȣ");
	      j3.setFont(new Font("�������", Font.PLAIN, 14));
	      j3.setBounds(55, 180 , 100, 100);
	     
	      JPasswordField t1=new JPasswordField(20);
	      t1.setBounds(130, 223, 120, 20);
	      
	      JButton b=new JButton("ȸ������");
	      b.setFont(new Font("�������", Font.PLAIN, 10));
	      b.setBounds(70, 270 , 80, 20);
	      
	      
	      JButton bb=new JButton("�α���");
	      bb.setFont(new Font("�������", Font.PLAIN, 10));
	      bb.setBounds(180, 270 , 80, 20);
	   	      
	      bb.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {	             
	        	  int i=JOptionPane.showConfirmDialog(null,"�α��μ���","Ȯ��",JOptionPane.YES_OPTION);
	            
	         	  if(i==JOptionPane.YES_OPTION) {
	                setVisible(false);
	                new Lobby();
	             }
	          }
	       });
	      
	      c.add(j1);
	      c.add(j4);
	      c.add(t);
	      c.add(j2);
	      c.add(j3);
	      c.add(t1);
	      c.add(b);
	      c.add(bb);
	      
	          
	      setVisible(true);
	      
	      
	      
	      b.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {	            
	            Dia d=new Dia();
	            d.setVisible(true);
	            d.setSize(480,400);
	         }
	      });
      }
	   
	   class Dia extends JDialog{
	      
	      Dia(){
	         setTitle("ȸ������");
	         
	         Container c=getContentPane();
	         
	         c.setLayout(null);
	         
	         JLabel j=new JLabel("���̵�");
	         j.setBounds(100, 10, 160, 40);
	         j.setFont(new Font("�������", Font.BOLD, 15));
	         c.add(j);
	         
	         JButton jj2=new JButton("�ߺ�Ȯ��");
	         jj2.setBackground(Color.green);
	         jj2.setForeground(Color.WHITE);
	         jj2.setBounds(330, 19, 90,18);
	         
	         c.add(jj2);
	         
	         JTextField t=new JTextField(20);
	         t.setBounds(180,20, 120, 20);
	         c.add(t);
	         
	         JLabel j1=new JLabel("����/���ڷ� �Է��ϼ���");
	         j1.setBounds(180,48, 250, 20);
	         c.add(j1);
	         
	         JLabel j2=new JLabel("��й�ȣ");
	         j2.setBounds(90,90, 120, 20);
	         j2.setFont(new Font("�������", Font.BOLD, 15));
	         c.add(j2);
	         
	         
	         
	         JPasswordField p=new JPasswordField(20);
	         p.setBounds(180,90, 120, 20);
	         c.add(p);
	         
	         JLabel j3=new JLabel("����/����/Ư�����ڷ� �Է��ϼ���");
	         j3.setBounds(180,110, 190, 20);
	         c.add(j3);
	         
	         JLabel j4=new JLabel("��й�ȣ Ȯ��");
	         j4.setFont(new Font("�������", Font.BOLD, 15));
	         j4.setBounds(60,145, 120, 20);
	         c.add(j4);
	         
	         JPasswordField p1=new JPasswordField(20);
	         p1.setBounds(180,150, 120, 20);
	         c.add(p1);
	         
	         p1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            
	            if(p.getText().equals(p1.getText())) {
	                   j3.setText("��й�ȣ�� ��ġ�մϴ�");
	                }
	                else if(!p.getText().equals(p1.getText())) {
	                   j3.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
	                }

	            
	         }
	      });
	              
	         
	       
	         
	         JButton jj=new JButton("���");
	         jj.setBackground(Color.green);
	         jj.setForeground(Color.WHITE);
	         jj.setBounds(150,240, 90, 20);
	         c.add(jj);
	         
	         
	         
	         JButton jj1=new JButton("���");
	         jj1.setBounds(250,240, 90, 20);
	         c.add(jj1);
	         
	         jj1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            setVisible(false);
	            
	         }
	      });
	         
	      
	         jj.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               
	               
	            int r=JOptionPane.showConfirmDialog(null,"��ϵǾ����ϴ�","Ȯ��",JOptionPane.YES_OPTION);
	              
	               if(r==JOptionPane.YES_OPTION) {
	                  setVisible(false);
	               }
	         
	            }
	         });
	      
	      }
	      }

	public static void main(String[] args) {
		new Login();

	}

}
