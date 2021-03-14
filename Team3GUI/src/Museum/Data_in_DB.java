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
		//1�� ����
		static String artist_name_1f[]=new String[13];
		static String country_1f[]=new String[4];
		static String[] check1_1f() {//1���� �׸��� �׸� ȭ������ ������ ���ڿ� �迭�� ����
			try {
				String que="select distinct a_artist from art where a_floor=1";
				pstm=conn.prepareStatement(que);
				r=pstm.executeQuery();
				int n=0;
				while(r.next()) {
					String a_name=r.getString(1);
					artist_name_1f[n]=a_name;
					n++;
				}
				r.close();
				pstm.close();
				conn.close();
			}catch(Exception e) {e.getStackTrace();}
			return artist_name_1f;
		}
		static String[] check2_1f() {//1���� ȭ������ ��� �������� ���ڿ� �迭�� ����
			try {
				String que="select distinct a_country from art where a_floor=1";
				pstm=conn.prepareStatement(que);
				r=pstm.executeQuery();
				int n=0;
				while(r.next()) {
					String a_coun=r.getString(1);
					country_1f[n]=a_coun;
					n++;
				}
				r.close();
				pstm.close();
				conn.close();
			}catch(Exception e) {e.getStackTrace();}
			return country_1f;
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
		static String picture_head_1f(int a) {//1�� �� �׸��� ������ Ÿ��Ʋ �ҷ�����
			String tit="";
			try {
				String que="select a_name, a_artist, a_year from art where a_no=?";
				pstm=conn.prepareStatement(que);
				pstm.setString(1, Integer.toString(a+1));
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
		static int[] bling_1f(String a, String b) {//1�� �˻� ���
			int[] blbl=new int[10];
			if(a==null&&b==null) {
				
			}
			else if(a==null) {
				try {
					String que="select a_no from art where a_floor=1 and a_country=?";
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
					String que="select a_no from art where a_floor=1 and a_artist=?";
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
					String que="select a_no from art where a_floor=1 and a_artist=? and a_country=?";
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
		static String[] comment(int a) {//�׸� ����â���� ������ ����
			String com[]=new String[5];
			try {
				String que="select c_id, my_comm from mypage natural join customer where a_no=?";
				pstm=conn.prepareStatement(que);
				pstm.setInt(1,a);
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
		static void lik_count(int a) {//���ƿ� ��ư ������ �� ������Ʈ
			int up=0;
			try {
				String que="update art set a_fav=a_fav+1 where a_no=?";
				pstm=conn.prepareStatement(que);
				pstm.setInt(1,(a));
				up=pstm.executeUpdate();
				pstm.close();
				conn.close();
			}catch(Exception e) {}
		}
		static int show_count(int a) {//���ƿ� ���� �ؿ� �׸��� ���ƿ� ���� ��µǴ� �Լ�
			int up=0;
			try {
				String que="select a_fav from art where a_no=?";
				pstm=conn.prepareStatement(que);
				pstm.setInt(1,(a));
				r=pstm.executeQuery();
				while(r.next()){
					up=r.getInt(1);
				}
				pstm.close();
				conn.close();
			}catch(Exception e) {}
			return up;
		}
		static int compare(String str) {//ȸ�����Խ� ���̵� �ߺ����� Ȯ��
			int c=0;
			try {
				String que="select count(*) from customer where c_id=?";
				pstm=conn.prepareStatement(que);
				pstm.setString(1, str);
				r=pstm.executeQuery();
				while(r.next()){
					c=r.getInt(1);
				}
				pstm.close();
				conn.close();
			}catch(Exception e) {}
			return c;
		}
		static void joinmuseum(String s,String t) {//ȸ�������� �ϸ� �� ���̺� �� ����
			int d=0;
			try {
				String que="insert into customer values(customer_seq.NEXTVAL, ?, ?)";
				pstm=conn.prepareStatement(que);
				pstm.setString(1, s);
				pstm.setString(2, t);
				d=pstm.executeUpdate();
				pstm.close();
				conn.close();
			}catch(Exception e) {}
		}
		static int login(String id,String pw) {//�α��� ���� ���� Ȯ��
			int c=0;
			try {
				String que="select count(*) from customer where c_id=? and c_pw=?";
				pstm=conn.prepareStatement(que);
				pstm.setString(1, id);
				pstm.setString(2, pw);
				r=pstm.executeQuery();
				while(r.next()){
					c=r.getInt(1);
				}
				pstm.close();
				conn.close();
			}catch(Exception e) {}
			return c;
		}
		static String Mycomm(String myid) {//����ں��� �ڽ��� �� �������� �κ�â�� ����
			String myc="";
			try {
				String que="select a_name||' / '||my_comm from mypage,customer,art\r\n"
						+ "where mypage.a_no=art.a_no and mypage.c_no=customer.c_no and c_id=?";
				pstm=conn.prepareStatement(que);
				pstm.setString(1, myid);
				r=pstm.executeQuery();
				while(r.next()) {
					myc+=r.getString(1)+",";
				}
				r.close();
				pstm.close();
				conn.close();
			}catch(Exception e) {}
			return myc;
		}
		static void updatecomment(int a,String b,String c){//������ ���� ����ϱ�
			int c_no=0;
			try {
				String que="select c_no from customer where c_id=?";
				pstm=conn.prepareStatement(que);
				pstm.setString(1, b);
				r=pstm.executeQuery();
				while(r.next()){
					c_no=r.getInt(1);
				}
			}catch(Exception e) {}			
			int d=0;
			try {
				String que="insert into mypage values(my_seq.NEXTVAL,?,?,?)";
				pstm=conn.prepareStatement(que);
				pstm.setInt(1, c_no);
				pstm.setInt(2, a);
				pstm.setString(3, c);
				d=pstm.executeUpdate();
				pstm.close();
				conn.close();
			}catch(Exception e) {}
		}
		
	/*public static void main(String[] args) throws SQLException{//SQL�� ����� �۵��ϴ��� �����ϴ� �����Լ�
		
	}*/

}
