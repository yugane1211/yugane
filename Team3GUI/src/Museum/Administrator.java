package Museum;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Administrator extends JFrame {

	private JPanel contentPane;
	private JTable CustomerTable;
	private JTable ArtTable;
	private JTable MypageTable;
	String Attrib1[]= {"����ȣ","���̵�","��й�ȣ"};
	String Attrib2[]= {"�׸���ȣ","�׸��̸�","����","ȭ���̸�","����","����","�����̸�","���ƿ�"};
	String Attrib3[]= {"�Ϸù�ȣ","����ȣ","�׸���ȣ","������"};

	/**
	 * Create the frame.
	 */
	public Administrator() {
		setBounds(new Rectangle(0, 0, 800, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu total = new JMenu("\uBA54\uB274");
		menuBar.add(total);
		
		JMenuItem ret = new JMenuItem("\uCC98\uC74C\uC73C\uB85C");
		total.add(ret);
		
		
		JMenuItem backtoIntro = new JMenuItem("\uB85C\uADF8\uC778\uD654\uBA74");
		total.add(backtoIntro);
		
		JMenu customer = new JMenu("\uACE0\uAC1D");
		menuBar.add(customer);
		
		JMenuItem insert1 = new JMenuItem("\uC0BD\uC785");
		insert1.setEnabled(false);
		customer.add(insert1);
		
		JMenuItem update1 = new JMenuItem("\uC218\uC815");
		customer.add(update1);
		
		JMenuItem delete1 = new JMenuItem("\uC0AD\uC81C");
		customer.add(delete1);
		
		JMenu art = new JMenu("\uADF8\uB9BC");
		menuBar.add(art);
		
		JMenuItem insert2 = new JMenuItem("\uC0BD\uC785");
		art.add(insert2);
		
		JMenuItem update2 = new JMenuItem("\uC218\uC815");
		art.add(update2);
		
		JMenuItem delete2 = new JMenuItem("\uC0AD\uC81C");
		art.add(delete2);
		
		JMenu mypage = new JMenu("\uB9C8\uC774\uD398\uC774\uC9C0");
		menuBar.add(mypage);
		
		JMenuItem insert3 = new JMenuItem("\uC0BD\uC785");
		insert3.setEnabled(false);
		mypage.add(insert3);
		
		JMenuItem update3 = new JMenuItem("\uC218\uC815");
		update3.setEnabled(false);
		mypage.add(update3);
		
		JMenuItem delete3 = new JMenuItem("\uC0AD\uC81C");
		mypage.add(delete3);
		customer.setEnabled(false);
		art.setEnabled(false);
		mypage.setEnabled(false);
		
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 800, 800));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel IntroPanel = new JPanel();
		IntroPanel.setVisible(true);
		IntroPanel.setBounds(12, 145, 762, 353);
		contentPane.add(IntroPanel);
		IntroPanel.setLayout(null);
		
		JLabel DBM = new JLabel("\uB370\uC774\uD130\uBCA0\uC774\uC2A4 \uAD00\uB9AC");
		DBM.setFont(new Font("����", Font.BOLD, 30));
		DBM.setHorizontalAlignment(SwingConstants.CENTER);
		DBM.setBounds(149, 5, 450, 106);
		IntroPanel.add(DBM);
		
		JButton Customer = new JButton("Customer");
		Customer.setBackground(Color.DARK_GRAY);
		Customer.setForeground(Color.BLUE);
		Customer.setFont(new Font("����", Font.BOLD, 22));
		Customer.setBounds(46, 190, 176, 66);
		IntroPanel.add(Customer);
		
		
		JButton Art = new JButton("Art");
		Art.setForeground(Color.BLUE);
		Art.setFont(new Font("����", Font.BOLD, 22));
		Art.setBackground(Color.DARK_GRAY);
		Art.setBounds(294, 190, 176, 66);
		IntroPanel.add(Art);
		
		JButton Mypage = new JButton("Mypage");
		Mypage.setForeground(Color.BLUE);
		Mypage.setFont(new Font("����", Font.BOLD, 22));
		Mypage.setBackground(Color.DARK_GRAY);
		Mypage.setBounds(544, 190, 176, 66);
		IntroPanel.add(Mypage);
		
		JPanel CustomerTab = new JPanel();//�� ���̺�
		CustomerTab.setBounds(12, 25, 762, 650);
		contentPane.add(CustomerTab);
		CustomerTab.setLayout(null);
		
		
		String[][] domain1 =Data_in_DB.admincustomer();
		
		CustomerTable = new JTable(domain1,Attrib1);
		JScrollPane table1 = new JScrollPane(CustomerTable);
		table1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		table1.setBounds(12, 68, 738, 622);
		table1.setAlignmentX(Component.CENTER_ALIGNMENT);
		CustomerTab.add(table1);
		
		JLabel TableTitle1 = new JLabel("Customer Management");
		TableTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		TableTitle1.setForeground(new Color(107, 142, 35));
		TableTitle1.setFont(new Font("����", Font.BOLD, 17));
		TableTitle1.setBounds(12, 10, 225, 40);
		CustomerTab.add(TableTitle1);
		CustomerTab.setVisible(false);
		
		JPanel ArtTab = new JPanel();//�׸� ���̺�
		ArtTab.setBounds(12, 25, 762, 650);
		contentPane.add(ArtTab);
		ArtTab.setLayout(null);
		
		
		String[][] domain2 =Data_in_DB.adminart();
		
		ArtTable = new JTable(domain2,Attrib2);
		JScrollPane table2 = new JScrollPane(ArtTable);
		table2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		table2.setBounds(12, 68, 738, 622);
		table2.setAlignmentX(Component.CENTER_ALIGNMENT);
		ArtTab.add(table2);
		
		
		JLabel TableTitle2 = new JLabel("Art Management");
		TableTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		TableTitle2.setForeground(new Color(107, 142, 35));
		TableTitle2.setFont(new Font("����", Font.BOLD, 17));
		TableTitle2.setBounds(12, 10, 225, 40);
		ArtTab.add(TableTitle2);
		ArtTab.setVisible(false);
		
		JPanel MypageTab = new JPanel();//���������� ���̺�
		MypageTab.setBounds(12, 25, 762, 650);
		contentPane.add(MypageTab);
		MypageTab.setLayout(null);
		
		
		String[][] domain3 =Data_in_DB.adminmypage();
		
		
		DefaultTableModel mpt=new DefaultTableModel(domain3,Attrib3);
		MypageTable = new JTable(mpt);
		JScrollPane table3 = new JScrollPane(MypageTable);
		table3.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		table3.setBounds(12, 68, 738, 622);		
		MypageTab.add(table3);
		table3.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		
		JLabel TableTitle3 = new JLabel("Mypage Management");
		TableTitle3.setHorizontalAlignment(SwingConstants.CENTER);
		TableTitle3.setForeground(new Color(107, 142, 35));
		TableTitle3.setFont(new Font("����", Font.BOLD, 17));
		TableTitle3.setBounds(12, 10, 225, 40);
		MypageTab.add(TableTitle3);
		MypageTab.setVisible(false);
		
		Customer.addActionListener(new ActionListener() {//�� ó������ ù��° ��ư ������
			public void actionPerformed(ActionEvent e) {
				IntroPanel.setVisible(false);
				CustomerTab.setVisible(true);
				customer.setEnabled(true);
				art.setEnabled(false);
				mypage.setEnabled(false);
			}
		});
		Art.addActionListener(new ActionListener() {//�� ó������ �ι�° ��ư ������
			public void actionPerformed(ActionEvent e) {
				IntroPanel.setVisible(false);
				ArtTab.setVisible(true);
				customer.setEnabled(false);
				art.setEnabled(true);
				mypage.setEnabled(false);
			}
		});
		Mypage.addActionListener(new ActionListener() {//�� ó������ ����° ��ư ������
			public void actionPerformed(ActionEvent e) {
				IntroPanel.setVisible(false);
				MypageTab.setVisible(true);
				customer.setEnabled(false);
				art.setEnabled(false);
				mypage.setEnabled(true);
			}
		});
		//�޴� �����
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerTab.setVisible(false);
				ArtTab.setVisible(false);
				MypageTab.setVisible(false);
				IntroPanel.setVisible(true);
				customer.setEnabled(false);
				art.setEnabled(false);
				mypage.setEnabled(false);
			}
		});
		backtoIntro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r=JOptionPane.showConfirmDialog(null, "Are you sure to close?","Yes",JOptionPane.YES_NO_OPTION);
				if(r==JOptionPane.YES_OPTION) {
					setVisible(false);
					new Login();
				}
				
			}
		});

		//�� �޴� �����ۿ� �׼� �ֱ�
		delete2.addActionListener(new ActionListener() {//art delete
			public void actionPerformed(ActionEvent e) {
				int r=JOptionPane.showConfirmDialog(null,"�����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_OPTION);
				if(r==JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.","",JOptionPane.INFORMATION_MESSAGE);
					int a=ArtTable.getSelectedRow();
					int b=ArtTable.getSelectedColumn();
					Integer c=Integer.parseInt((String)ArtTable.getValueAt(a, b));
					String [][] d=Data_in_DB.artdel(c);
					DefaultTableModel nd=new DefaultTableModel(d,Attrib2);
					ArtTable.setModel(nd);
				}							
			}
		});
		delete1.addActionListener(new ActionListener() {//customer delete
			public void actionPerformed(ActionEvent e) {
				int r=JOptionPane.showConfirmDialog(null,"�����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_OPTION);
				if(r==JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.","",JOptionPane.INFORMATION_MESSAGE);
					int a=CustomerTable.getSelectedRow();
					int b=CustomerTable.getSelectedColumn();
					Integer c=Integer.parseInt((String)CustomerTable.getValueAt(a, b));
					String [][] d=Data_in_DB.cusdel(c);
					DefaultTableModel nd=new DefaultTableModel(d,Attrib1);
					CustomerTable.setModel(nd);	
				}						
			}
		});
		delete3.addActionListener(new ActionListener() {//mypage delete
			public void actionPerformed(ActionEvent e) {
				int r=JOptionPane.showConfirmDialog(null,"�����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_OPTION);
				if(r==JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.","",JOptionPane.INFORMATION_MESSAGE);
					int a=MypageTable.getSelectedRow();
					int b=MypageTable.getSelectedColumn();
					Integer c=Integer.parseInt((String)MypageTable.getValueAt(a, b));
					String [][] d=Data_in_DB.mypdel(c);
					DefaultTableModel nd=new DefaultTableModel(d,Attrib3);
					MypageTable.setModel(nd);	
				}						
			}
		});
		insert2.addActionListener(new ActionListener() {//art insert
			public void actionPerformed(ActionEvent e) {
				new Chanar("insert");
				
			}
		});
		update2.addActionListener(new ActionListener() {//art update
			public void actionPerformed(ActionEvent e) {
				new Chanar("update");
				
			}
		});
		update1.addActionListener(new ActionListener() {//customer update
			public void actionPerformed(ActionEvent e) {
				new Updcus();				
			}
		});
		
		
		
		setVisible(true);
	}
	class Chanar extends JDialog{
		int indexed=ArtTable.getSelectedRow();
		Chanar(String k){
			Container c=getContentPane();
			setSize(320,360);
			setLayout(null);
			setLocationRelativeTo(null);
			
			//����
			JLabel ano=new JLabel("�׸���ȣ�� �ý��ۿ� ���� �ڵ� �ο�");
			ano.setHorizontalAlignment(SwingConstants.CENTER);
			ano.setBounds(0,0,300,35);
			JLabel aname=new JLabel("�׸��̸�");
			aname.setHorizontalAlignment(SwingConstants.CENTER);
			aname.setBounds(0,35,100,35);
			JTextField anamec = new JTextField();
			anamec.setBounds(100,35,200,35);
			JLabel afloor=new JLabel("����");
			afloor.setHorizontalAlignment(SwingConstants.CENTER);
			afloor.setBounds(0,70,100,35);
			JTextField afloorc = new JTextField();
			afloorc.setBounds(100,70,200,35);
			JLabel aartist=new JLabel("�۰�");
			aartist.setHorizontalAlignment(SwingConstants.CENTER);
			aartist.setBounds(0,105,100,35);
			JTextField aartistc = new JTextField();
			aartistc.setBounds(100,105,200,35);
			JLabel ayear=new JLabel("����");
			ayear.setHorizontalAlignment(SwingConstants.CENTER);
			ayear.setBounds(0,140,100,35);
			JTextField ayearc = new JTextField();
			ayearc.setBounds(100,140,200,35);
			JLabel acountry=new JLabel("����");
			acountry.setHorizontalAlignment(SwingConstants.CENTER);
			acountry.setBounds(0,175,100,35);
			JTextField acountryc = new JTextField();
			acountryc.setBounds(100,175,200,35);
			JLabel aename=new JLabel("�����̸�");
			aename.setHorizontalAlignment(SwingConstants.CENTER);
			aename.setBounds(0,210,100,35);
			JTextField aenamec = new JTextField();
			aenamec.setBounds(100,210,200,35);
			JLabel afav=new JLabel("���ƿ�");
			afav.setHorizontalAlignment(SwingConstants.CENTER);
			afav.setBounds(0,245,100,35);
			JTextField afavc = new JTextField();
			afavc.setBounds(100,245,200,35);
			if(indexed!=-1) {
				anamec.setText((String)ArtTable.getValueAt(indexed, 1));
				afloorc.setText((String)ArtTable.getValueAt(indexed, 2));
				aartistc.setText((String)ArtTable.getValueAt(indexed, 3));
				ayearc.setText((String)ArtTable.getValueAt(indexed, 4));
				acountryc.setText((String)ArtTable.getValueAt(indexed, 5));
				aenamec.setText((String)ArtTable.getValueAt(indexed, 6));
				afavc.setText((String)ArtTable.getValueAt(indexed, 7));
				
			}
			JButton confirm=new JButton("�߰�/����");
			confirm.setBounds(50, 290, 90, 25);
			JButton cancel=new JButton("���");
			cancel.setBounds(160, 290, 90, 25);
			
			//�׼�
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);				
				}
			});
			confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String a1=anamec.getText();
					String a2=afloorc.getText();
					String a3=aartistc.getText();
					String a4=ayearc.getText();
					String a5=acountryc.getText();
					String a6=aenamec.getText();
					String a7=afavc.getText();
					String[] aart= {a1,a2,a3,a4,a5,a6,a7};
					switch(k) {
					case "insert":
						JOptionPane.showMessageDialog(null, "�߰� �Ϸ�","",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						String [][] d=Data_in_DB.artins(aart);
						DefaultTableModel nd=new DefaultTableModel(d,Attrib2);
						ArtTable.setModel(nd);
						break;
					case "update":
						JOptionPane.showMessageDialog(null, "���� �Ϸ�","",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						String [][] u=Data_in_DB.artupd(aart, Integer.parseInt((String)ArtTable.getValueAt(indexed, 0)));
						DefaultTableModel ud=new DefaultTableModel(u,Attrib2);
						ArtTable.setModel(ud);
						break;
					}		
				}
			});
			//�߰�
			c.add(ano);
			c.add(aname);
			c.add(anamec);
			c.add(afloor);
			c.add(afloorc);
			c.add(aartist);
			c.add(aartistc);
			c.add(ayear);
			c.add(ayearc);
			c.add(acountry);
			c.add(acountryc);
			c.add(aename);
			c.add(aenamec);
			c.add(afav);
			c.add(afavc);
			c.add(confirm);
			c.add(cancel);
			setVisible(true);
		}
}
	class Updcus extends JDialog{
		int indexed=CustomerTable.getSelectedRow();
		Updcus(){
			Container c=getContentPane();
			setSize(320,185);
			setLayout(null);
			setLocationRelativeTo(null);
			
			//����
			JLabel cno=new JLabel("����ȣ�� �ý��ۿ� ���� �ڵ� �ο�");
			cno.setHorizontalAlignment(SwingConstants.CENTER);
			cno.setBounds(0,0,300,35);
			JLabel cid=new JLabel("���̵�");
			cid.setHorizontalAlignment(SwingConstants.CENTER);
			cid.setBounds(0,35,100,35);
			JTextField cidc = new JTextField();
			cidc.setBounds(100,35,200,35);
			JLabel cpw=new JLabel("�н�����");
			cpw.setHorizontalAlignment(SwingConstants.CENTER);
			cpw.setBounds(0,70,100,35);
			JTextField cpwc = new JTextField();
			cpwc.setBounds(100,70,200,35);
			if(indexed!=-1) {
				cidc.setText((String)CustomerTable.getValueAt(indexed, 1));
				cpwc.setText((String)CustomerTable.getValueAt(indexed, 2));
			}
			JButton confirm=new JButton("����");
			confirm.setBounds(50, 115, 90, 25);
			JButton cancel=new JButton("���");
			cancel.setBounds(160, 115, 90, 25);
			
			//�׼�
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);				
				}
			});
			confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String c1=cidc.getText();
					String c2=cpwc.getText();
					JOptionPane.showMessageDialog(null, "���� �Ϸ�","",JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					String [][] u=Data_in_DB.cusupd(c1,c2, Integer.parseInt((String)CustomerTable.getValueAt(indexed, 0)));
					DefaultTableModel ud=new DefaultTableModel(u,Attrib1);
					CustomerTable.setModel(ud);	
				}
			});
			//�߰�
			c.add(cno);
			c.add(cid);
			c.add(cidc);
			c.add(cpw);
			c.add(cpwc);

			c.add(confirm);
			c.add(cancel);
			setVisible(true);
		}
}
}