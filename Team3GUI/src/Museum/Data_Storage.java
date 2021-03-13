package Museum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.DriverManager;

public class Data_Storage {
	static String[] imglist2= {"2floor_Spain_1924_Miro_016.jpg", "2floor_Spain_1941_Miro_017.jpg", "2floor_Spain_1931_Dali_018.jpg","2floor_Spain_1929_Dali_019.jpg", "2floor_Spain_1946_Dali_020.jpg", "2floor_Spain_1897_Picasso_021.jpg", "2floor_Spain_1903_Picasso_022.jpg", "2floor_Spain_1932_Picasso_023.jpg", "2floor_Spain_1907_Picasso_024.jpg", "2floor_Spain_1937_Picasso_025.jpg", "2floor_Netherlans_1889_Gogh_026.jpg", "2floor_Norway_1893_Munch_027.jpg", "2floor_Mexico_1944_Kahlo_028.jpg", "2floor_America_1948_Pollock_029.jpg", "2floor_France_1895_Cezanne_030.jpg"};
	static String[] explist2= {"2floor_Miro_016.txt", "2floor_Miro_017.txt", "2floor_Dail_018.txt", "2floor_Dail_019.txt", "2floor_Dail_020.txt", "2floor_Picasso_021.txt", "2floor_Picasso_022.txt", "2floor_Picasso_023.txt", "2floor_Picasso_024.txt", "2floor_Picasso_025.txt", "2floor_Gogh_026.txt", "2floor_Munch_027.txt", "2floor_Kahlo_028.txt", "2floor_Pollock_029.txt", "2floor_Cezanne_030.txt"};
	//�̹������ϰ� �ؽ�Ʈ������ ������� ��ȣ������� �迭�� ����(2��)
	//�Ʒ��� 1��
	static String[] imglist1 = {"1floor_Italy_1425_Angellico_001.jpg",
			"1floor_Italy_1485_Botticelli_002.jpg",
			"1floor_Italy_1503_Davinci._003.jpg",
			"1floor_Italy_1511_Raffaello_004.jpg",
			"1floor_Spain_1588_ElGreco_005.jpg",
			"1floor_Spain_1656_Velazquezs_006.jpg",
			"1floor_Spain_1819_Goya_007.jpg",
			"1floor_Spain_1910_Sorolla_008.jpg",
			"1floor_Germany_1507_Durer_009.jpg",
			"1floor_Italy_1500_Davinci_010.jpg",
			"1floor_Netherlands_1510_Bosch_011.jpg",
			"1floor_Spain_1628_Velazquezs_012.jpg",
			"1floor_Italy_1548_Tiziano_013.jpg",
			"1floor_Italy_1599_Caravaggio_014.jpg",
			"1floor_Germany_1639_Rubenz_015.jpg"};
	static String[] extlist1 = {"1floor_Angellico_001.txt",
			"1floor_Borricell_002.txt",
			"1floor_Davinci_003.txt",
			"1floor_Raffello_004.txt",
			"1floor_ElGreco_005.txt",
			"1floor_Velazquezs_006.txt",
			"1floor_Goya_007.txt",
			"1floor_Sorolla_008.txt",
			"1floor_Durrer_009.txt",
			"1floor_Davinci_010.txt",
			"1floor_Bosch_011.txt",
			"1floor_Velazquezs_012.txt",
			"1floor_Tiziano_013.txt",
			"1floor_Caravaggio_014.txt",
			"1floor_Rubenz_015.txt"};
	static String loadTxt(int a) {	//�ؽ�Ʈ ���Ϸ� �Ǿ��ִ� �׸� ������ ������������� �ҷ�����	
		String exp="";
		String bf="";
		FileReader fr=null;
		try {
			fr=new FileReader(explist2[a]);
			BufferedReader br=new BufferedReader(fr);
			while((bf=br.readLine())!=null) {
				exp+=bf+"\n";
			}
			br.close();
			fr.close();
		}catch(Exception e) {}
		return exp;
	}
	static String loadTxt_1f(int a) {
		String exp="";
		String bf="";
		FileReader fr=null;
		try {
			fr=new FileReader(extlist1[a]);
			BufferedReader br=new BufferedReader(fr);
			while((bf=br.readLine())!=null) {
				exp+=bf+"\n";
			}
			br.close();
			fr.close();
		}catch(Exception e) {}			
		return exp;
	}
	
	////////���⼭���ʹ� DB ���� �κ�
	public static Connection con;
	public static Connection get() {
		Connection conn=null;
		try {
			String id="DARKZERODX";
			String pw="Darkzero1463!!";
			String url="jdbc:oracle:thin:@localhost:1521/xepdb1";
			
			// jdbc driver loading
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ���ڿ��� �� Ŭ����/�������̽� �̸��� ��ü�� ����
			// ����̹����� ������ �ڵ����� ��ü�� �����ؼ� DriverManager�� ��ϵ�
			conn=DriverManager.getConnection(url, id, pw);
			// connection ��ü�� �����ϴ� ��
			
			System.out.println("DB �����");
		}catch(Exception e) {
			System.out.println("�ε� ����");
		}
		
		return conn;
	}

}
