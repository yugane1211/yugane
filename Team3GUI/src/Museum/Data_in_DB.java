package Museum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data_in_DB {
		static Connection conn=null; // DB와 연결하는 인터페이스
		static PreparedStatement pstm=null; // sql문 객체 -> 있어야 sql문 실행
		static ResultSet r=null; // sql에 대한 반환
		
		static void connect() {
			try {
				conn=Museum.Data_Storage.get();
			}catch(Exception e) {}
		}
		static String artist_name[]=new String[22];
		static String country[]=new String[8];
		static String[] check1() {//그림을 그린 화가들의 정보를 문자열 배열에 저장
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
		static String[] check2() {//화가들의 출신 국가들을 문자열 배열에 저장
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
		where rownum<=5;*/ //top 5 그림의 이름, 화가이름 불러오기
		
		static String picture_head(int a) {//각 그림의 설명에서 타이틀 불러오기
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
