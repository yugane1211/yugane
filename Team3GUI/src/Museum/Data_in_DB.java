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
		//1층 버전
		static String artist_name_1f[]=new String[13];
		static String country_1f[]=new String[4];
		static String[] check1_1f() {//1층의 그림을 그린 화가들의 정보를 문자열 배열에 저장
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
		static String[] check2_1f() {//1층의 화가들의 출신 국가들을 문자열 배열에 저장
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
		static String picture_head_1f(int a) {//1층 각 그림의 설명에서 타이틀 불러오기
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
		static int[] bling_1f(String a, String b) {//1층 검색 기능
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
		static void lik_count(int a) {//좋아요 버튼 누르면 값 업데이트
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
		static int show_count(int a) {//좋아요 버듵 밑에 그림의 좋아요 수가 출력되는 함수
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
		static int compare(String str) {//회원가입시 아이디 중복여부 확인
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
		static void joinmuseum(String s,String t) {//회원가입을 하면 고객 테이블에 행 삽입
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
		static int login(String id,String pw) {//로그인 가능 여부 확인
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
		static String Mycomm(String myid) {//사용자별로 자신이 쓴 한줄평을 로비창에 띄우기
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
		static void updatecomment(int a,String b,String c){//한줄평 새로 등록하기
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
		
	/*public static void main(String[] args) throws SQLException{//SQL이 제대로 작동하는지 시험하는 메인함수
		
	}*/

}
