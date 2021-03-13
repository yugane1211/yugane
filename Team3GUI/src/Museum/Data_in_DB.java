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
		static String artist_name[]=new String[8];
		static String country[]=new String[7];
		static String[] check1() {//2층의 그림을 그린 화가들의 정보를 문자열 배열에 저장
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
		static String[] check2() {//2층의 화가들의 출신 국가들을 문자열 배열에 저장
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
		
		static String[] top_five() {//top 5 그림의 이름, 화가이름 불러오기
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
		
		static String picture_head(int a) {//2층 각 그림의 설명에서 타이틀 불러오기
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
		
		///////특정 조건의 버튼 빛나게 하기!(난이도 있음)
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
		static String[] comment(int a) {//그림 설명창에서 한줄평 띄우기
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
		
		
		
		
	public static void main(String[] args) throws SQLException{//SQL이 제대로 작동하는지 시험하는 메인함수
		connect();
		
		String com[]=new String[10];
		try {
			String que="select c_id, my_comm from mypage natural join customer where a_no=?";
			pstm=conn.prepareStatement(que);
			pstm.setInt(1,16);
			r=pstm.executeQuery();
			int n=0;
			while(r.next()) {
				String c_id=r.getString(1);
				String my_comm=r.getString(2);
				com[n]=c_id+"/"+my_comm;
				System.out.println(c_id+"/"+my_comm);
				n++;
			}
			r.close();
			pstm.close();
			conn.close();
		}catch(Exception e) {}

	}

}
