package Museum;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Administrator extends JFrame {

	private JPanel contentPane;
	private JTable CustomerTable;
	private JTable ArtTable;
	private JTable MypageTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
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
		mypage.add(insert3);
		
		JMenuItem update3 = new JMenuItem("\uC218\uC815");
		mypage.add(update3);
		
		JMenuItem dalete3 = new JMenuItem("\uC0AD\uC81C");
		mypage.add(dalete3);
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
		DBM.setFont(new Font("굴림", Font.BOLD, 30));
		DBM.setHorizontalAlignment(SwingConstants.CENTER);
		DBM.setBounds(149, 5, 450, 106);
		IntroPanel.add(DBM);
		
		JButton Customer = new JButton("Customer");
		Customer.setBackground(Color.DARK_GRAY);
		Customer.setForeground(Color.BLUE);
		Customer.setFont(new Font("굴림", Font.BOLD, 22));
		Customer.setBounds(46, 190, 176, 66);
		IntroPanel.add(Customer);
		
		
		JButton Art = new JButton("Art");
		Art.setForeground(Color.BLUE);
		Art.setFont(new Font("굴림", Font.BOLD, 22));
		Art.setBackground(Color.DARK_GRAY);
		Art.setBounds(294, 190, 176, 66);
		IntroPanel.add(Art);
		
		JButton Mypage = new JButton("Mypage");
		Mypage.setForeground(Color.BLUE);
		Mypage.setFont(new Font("굴림", Font.BOLD, 22));
		Mypage.setBackground(Color.DARK_GRAY);
		Mypage.setBounds(544, 190, 176, 66);
		IntroPanel.add(Mypage);
		
		JPanel CustomerTab = new JPanel();//고객 테이블
		CustomerTab.setBounds(12, 25, 762, 650);
		contentPane.add(CustomerTab);
		CustomerTab.setLayout(null);
		
		String Attrib1[]= {"고객번호","아이디","비밀번호"};
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
		TableTitle1.setFont(new Font("굴림", Font.BOLD, 17));
		TableTitle1.setBounds(12, 10, 225, 40);
		CustomerTab.add(TableTitle1);
		CustomerTab.setVisible(false);
		
		JPanel ArtTab = new JPanel();//그림 테이블
		ArtTab.setBounds(12, 25, 762, 650);
		contentPane.add(ArtTab);
		ArtTab.setLayout(null);
		
		String Attrib2[]= {"그림번호","그림이름","층수","화가이름","연도","국가","영문이름","좋아요"};
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
		TableTitle2.setFont(new Font("굴림", Font.BOLD, 17));
		TableTitle2.setBounds(12, 10, 225, 40);
		ArtTab.add(TableTitle2);
		ArtTab.setVisible(false);
		
		JPanel MypageTab = new JPanel();//마이페이지 테이블
		MypageTab.setBounds(12, 25, 762, 650);
		contentPane.add(MypageTab);
		MypageTab.setLayout(null);
		
		String Attrib3[]= {"일련번호","고객번호","그림번호","한줄평"};
		String[][] domain3 =Data_in_DB.admimypage();
		
		MypageTable = new JTable(domain3,Attrib3);
		JScrollPane table3 = new JScrollPane(MypageTable);
		table3.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		table3.setBounds(12, 68, 738, 622);		
		MypageTab.add(table3);
		table3.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		
		JLabel TableTitle3 = new JLabel("Mypage Management");
		TableTitle3.setHorizontalAlignment(SwingConstants.CENTER);
		TableTitle3.setForeground(new Color(107, 142, 35));
		TableTitle3.setFont(new Font("굴림", Font.BOLD, 17));
		TableTitle3.setBounds(12, 10, 225, 40);
		MypageTab.add(TableTitle3);
		MypageTab.setVisible(false);
		
		Customer.addActionListener(new ActionListener() {//맨 처음에서 첫번째 버튼 누를시
			public void actionPerformed(ActionEvent e) {
				IntroPanel.setVisible(false);
				CustomerTab.setVisible(true);
			}
		});
		Art.addActionListener(new ActionListener() {//맨 처음에서 두번째 버튼 누를시
			public void actionPerformed(ActionEvent e) {
				IntroPanel.setVisible(false);
				ArtTab.setVisible(true);
			}
		});
		Mypage.addActionListener(new ActionListener() {//맨 처음에서 세번째 버튼 누를시
			public void actionPerformed(ActionEvent e) {
				IntroPanel.setVisible(false);
				MypageTab.setVisible(true);
			}
		});
		//메뉴 만들기
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerTab.setVisible(false);
				ArtTab.setVisible(false);
				MypageTab.setVisible(false);
				IntroPanel.setVisible(true);
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

		setVisible(true);
	}
}
