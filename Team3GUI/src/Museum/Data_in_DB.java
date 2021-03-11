package Museum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data_in_DB {
		static Connection conn=null; // DB�� �����ϴ� �������̽�
		static PreparedStatement pstm=null; // sql�� ��ü -> �־�� sql�� ����
		static ResultSet r=null; // sql�� ���� ��ȯ
		
		static void connect() {
			try {
				conn=Museum.Data_Storage.get();
			}catch(Exception e) {}
		}
		static String artist_name[]=new String[22];
		static String country[]=new String[8];
		static String[] check1() {//�׸��� �׸� ȭ������ ������ ���ڿ� �迭�� ����
			try {
				String que="select distinct a_artist from art";
				pstm=conn.prepareStatement(que);
				r=pstm.executeQuery();
				int n=0;
				while(r.next()) {
					String a_name=r.getString(1);
					artist_name[n]=a_name;
					n++;
				}
				r.close();
				pstm.close();
				conn.close();
			}catch(Exception e) {e.getStackTrace();}
			return artist_name;
		}
		static String[] check2() {//ȭ������ ��� �������� ���ڿ� �迭�� ����
			try {
				String que="select distinct a_country from art";
				pstm=conn.prepareStatement(que);
				r=pstm.executeQuery();
				int n=0;
				while(r.next()) {
					String a_coun=r.getString(1);
					country[n]=a_coun;
					n++;
				}
				r.close();
				pstm.close();
				conn.close();
			}catch(Exception e) {e.getStackTrace();}
			return country;
		}
		/*select a_name, a_artist
		from (select * from art order by a_fav desc)
		where rownum<=5;*/ //top 5 �׸��� �̸�, ȭ���̸� �ҷ�����
		
		static String picture_head(int a) {//�� �׸��� ������ Ÿ��Ʋ �ҷ�����
			String tit="";
			try {
				String que="select a_name, a_artist, a_year from art where a_no=?";
				pstm=conn.prepareStatement(que);
				pstm.setString(1, Integer.toString(a+16));
				r=pstm.executeQuery();
				while(r.next()) {
					String a_name=r.getString(1);
					String a_artist=r.getString(2);
					String a_year=r.getString(3);
					tit=a_name+" / "+a_artist+" / "+a_year;
				}
				r.close();
				pstm.close();
				conn.close();
			}catch(Exception e) {}
			return tit;
		}
	/*public static void main(String[] args) throws SQLException{
		
		try {
			conn=Museum.Data_Storage.get();
			String que="select distinct a_artist from art";
			pstm=conn.prepareStatement(que);
			r=pstm.executeQuery();
			int n=0;
			while(r.next()) {
				String a_name=r.getString(1);
				artist_name[n]=a_name;
				n++;
				System.out.println(a_name);
			}
			r.close();
			pstm.close();
			conn.close();
		}catch(Exception e) {e.getStackTrace();}
		r.close();
		pstm.close();
		conn.close();

	}*/

}
