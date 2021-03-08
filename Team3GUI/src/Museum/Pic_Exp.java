package Museum;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Pic_Exp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pic_Exp frame = new Pic_Exp();
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
	public Pic_Exp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uADF8\uB9BC\uC758 \uC774\uB984, \uD654\uAC00 \uC774\uB984, \uC5F0\uB3C4");
		lblNewLabel.setBounds(12, 10, 604, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(12, 79, 355, 392);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\82105\\OneDrive\\\uBC14\uD0D5 \uD654\uBA74\\DarkzeroDX\\JAVA\\Group\\Data\\\uD68C\uD654 2\uCE35\\2floor_Spain_1932_Picasso_023.jpg"));
		contentPane.add(lblNewLabel_1);//그림 이미지가 들어가는 자리
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(358, 77, 425, 407);
		contentPane.add(scrollPane);

		String str=Museum.Data_Storage.loadTxt();//그림에 대한 설명을 파일입출력으로 불러오기
		//그림이 많아지면 배열 형태로 저장해서 불러올 예정(메소드 수정 필요)
		textArea.setText(str);//그림에 대한 설명 집어넣기
		textArea.setEditable(false);
	}
}
