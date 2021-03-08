package Museum;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1191, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("2\uCE35");
		lblNewLabel.setFont(new Font("±º∏≤", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 10, 157, 43);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 49, 1153, 87);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		comboBox.setBounds(127, 25, 204, 32);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		comboBox_1.setBounds(624, 25, 204, 32);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uD654\uAC00 \uC774\uB984");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 25, 108, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uAD6D\uAC00");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("±º∏≤", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(511, 25, 108, 32);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("\uAC80 \uC0C9");
		btnNewButton.setBounds(954, 25, 153, 32);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		ImageIcon img2=new ImageIcon("Floor2.jpg");
		panel_1.setLayout(null);
		JLabel image2=new JLabel(new ImageIcon("C:\\Users\\82105\\eclipse-workspace\\Team3GUI\\Floor2.jpg"));
		image2.setOpaque(true);
		panel_1.add(image2);
		panel_1.setBounds(12, 136, 1153, 504);
		image2.setBounds(0, 0, 1153, 504);
		contentPane.add(panel_1);
		
		JButton btnNewButton_3 = new JButton("016");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(337, 109, 93, 52);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("017");
		btnNewButton_3_1.setBounds(433, 109, 93, 52);
		panel_1.add(btnNewButton_3_1);
		btnNewButton_3_1.setBackground(Color.WHITE);
		
		JButton btnNewButton_3_1_1 = new JButton("018");
		btnNewButton_3_1_1.setBackground(Color.WHITE);
		btnNewButton_3_1_1.setBounds(529, 109, 93, 52);
		panel_1.add(btnNewButton_3_1_1);
		
		JButton btnNewButton_3_1_2 = new JButton("019");
		btnNewButton_3_1_2.setBackground(Color.WHITE);
		btnNewButton_3_1_2.setBounds(722, 109, 93, 52);
		panel_1.add(btnNewButton_3_1_2);
		
		JButton btnNewButton_3_1_3 = new JButton("020");
		btnNewButton_3_1_3.setBackground(Color.WHITE);
		btnNewButton_3_1_3.setBounds(819, 109, 93, 52);
		panel_1.add(btnNewButton_3_1_3);
		
		JButton btnNewButton_3_1_4 = new JButton("021");
		btnNewButton_3_1_4.setBackground(Color.WHITE);
		btnNewButton_3_1_4.setBounds(912, 109, 93, 52);
		panel_1.add(btnNewButton_3_1_4);
		
		JButton btnNewButton_3_1_5 = new JButton("022");
		btnNewButton_3_1_5.setBackground(Color.WHITE);
		btnNewButton_3_1_5.setBounds(337, 10, 93, 52);
		panel_1.add(btnNewButton_3_1_5);
		
		JButton btnNewButton_3_1_6 = new JButton("023");
		btnNewButton_3_1_6.setBackground(Color.WHITE);
		btnNewButton_3_1_6.setBounds(433, 10, 93, 52);
		panel_1.add(btnNewButton_3_1_6);
		
		JButton btnNewButton_3_1_7 = new JButton("024");
		btnNewButton_3_1_7.setBackground(Color.WHITE);
		btnNewButton_3_1_7.setBounds(529, 10, 93, 52);
		panel_1.add(btnNewButton_3_1_7);
		
		JButton btnNewButton_3_1_8 = new JButton("025");
		btnNewButton_3_1_8.setBackground(Color.WHITE);
		btnNewButton_3_1_8.setBounds(722, 10, 93, 52);
		panel_1.add(btnNewButton_3_1_8);
		
		JButton btnNewButton_3_1_9 = new JButton("026");
		btnNewButton_3_1_9.setBackground(Color.WHITE);
		btnNewButton_3_1_9.setBounds(819, 10, 93, 52);
		panel_1.add(btnNewButton_3_1_9);
		
		JButton btnNewButton_3_1_10 = new JButton("027");
		btnNewButton_3_1_10.setBackground(Color.WHITE);
		btnNewButton_3_1_10.setBounds(912, 10, 93, 52);
		panel_1.add(btnNewButton_3_1_10);
		
		JLabel lblNewLabel_2 = new JLabel("Top 5");
		lblNewLabel_2.setFont(new Font("±º∏≤", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 661, 157, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel topc = new JLabel("New label");
		topc.setFont(new Font("±º∏≤", Font.PLAIN, 17));
		topc.setBounds(151, 662, 775, 38);
		contentPane.add(topc);
		
		JButton btnNewButton_1 = new JButton("\uB85C\uBE44\uB85C \uB098\uAC00\uAE30");
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.setFont(new Font("HY«ÏµÂ∂Û¿ŒM", Font.BOLD, 17));
		btnNewButton_1.setBounds(977, 656, 188, 43);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("New button");
		button.setBounds(914, 676, -163, -14);
		contentPane.add(button);
		
		JButton btnNewButton_2 = new JButton("1\uCE35\uC73C\uB85C");
		btnNewButton_2.setBackground(new Color(255, 255, 204));
		btnNewButton_2.setFont(new Font("HY«ÏµÂ∂Û¿ŒM", Font.BOLD, 17));
		btnNewButton_2.setBounds(777, 656, 188, 43);
		contentPane.add(btnNewButton_2);
	}
}
