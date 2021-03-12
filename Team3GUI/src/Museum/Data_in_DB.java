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
		static String artist_name[]=new String[8];
		static String country[]=new String[7];
		static String[] check1() {//2���� �׸��� �׸� ȭ������ ������ ���ڿ� �迭�� ����
			try {
				String que="select distinct a_artist from art where a_floor=2";
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
		static String[] check2() {//2���� ȭ������ ��� �������� ���ڿ� �迭�� ����
			try {
				String que="select distinct a_country from art where a_floor=2";
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
		
		static String[] top_five() {//top 5 �׸��� �̸�, ȭ���̸� �ҷ�����
			String tit[]=new String[5];
			try {
				String que="select a_name, a_artist from (select * from art order by a_fav desc) where rownum<=5";
				pstm=conn.prepareStatement(que);
				
				r=pstm.executeQuery();
				int n=0;
				while(r.next()) {
					String a_name=r.getString(1);
					String a_artist=r.getString(2);
					tit[n]=a_name+" / "+a_artist;
					n++;
				}
				r.close();
				pstm.close();
				conn.close();
			}catch(Exception e) {}
			return tit;
		}
		
		static String picture_head(int a) {//2�� �� �׸��� ������ Ÿ��Ʋ �ҷ�����
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
		
		///////Ư�� ������ ��ư ������ �ϱ�!(���̵� ����)
		static int[] bling(String a, String b) {
			int[] blbl=new int[10];
			if(a==null&&b==null) {
				
			}
			else if(a==null) {
				try {
					String que="select a_no from art where a_floor=2 and a_country=?";
					pstm=conn.prepareStatement(que);
					pstm.setString(1, b);
					r=pstm.executeQuery();
					int n=0;
					while(r.next()) {
						int a_no=r.getInt(1);
						blbl[n]=a_no;
						n++;
					}
					r.close();
					pstm.close();
					conn.close();
				}catch(Exception e) {}
				
			}else if(b==null) {
				try {
					String que="select a_no from art where a_floor=2 and a_artist=?";
					pstm=conn.prepareStatement(que);
					pstm.setString(1, a);
					r=pstm.executeQuery();
					int n=0;
					while(r.next()) {
						int a_no=r.getInt(1);
						blbl[n]=a_no;
						n++;
					}
					r.close();
					pstm.close();
					conn.close();
				}catch(Exception e) {}
			
			}else {
				try {
					String que="select a_no from art where a_floor=2 and a_artist=? and a_country=?";
					pstm=conn.prepareStatement(que);
					pstm.setString(1, a);
					pstm.setString(2, b);
					r=pstm.executeQuery();
					int n=0;
					while(r.next()) {
						int a_no=r.getInt(1);
						blbl[n]=a_no;
						n++;
					}
					r.close();
					pstm.close();
					conn.close();
				}catch(Exception e) {}
				
			}
			return blbl;
		}
		static String[] comment(int a) {
			String com[]=new String[10];
			try {
				String que="select c_id, my_comm from mypage natural join customer where a_no=?";
				pstm=conn.prepareStatement(que);
				pstm.setString(1, Integer.toString(a));
				r=pstm.executeQuery();
				int n=0;
				while(r.next()) {
					String c_id=r.getString(1);
					String my_comm=r.getString(2);
					com[n]=c_id+"/"+my_comm;
					n++;
				}
				r.close();
				pstm.close();
				conn.close();
			}catch(Exception e) {}
			return com;
		}
		
		
		
		
	public static void main(String[] args) throws SQLException{
		connect();
		
		try {
			String que="select c_id, my_comm from mypage natural join customer where a_no=16";
			pstm=conn.prepareStatement(que);
			//pstm.setString(1, Integer.toString(16));
			
			r=pstm.executeQuery();
			int n=0;
			while(r.next()) {
				String c_id=r.getString(1);
				String my_comm=r.getString(2);
				System.out.println(c_id+"/"+my_comm);
				
			}
			r.close();
			pstm.close();
			conn.close();
		}catch(Exception e) {}

	}

}
