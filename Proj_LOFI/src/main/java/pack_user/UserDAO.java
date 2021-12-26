package pack_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	private Connection conn; //자바와 데이터베이스를 연결
	private PreparedStatement pstmt1; //쿼리문 대기 및 설정
	private ResultSet rs1; //결과값 받아오기
	
	//기본 생성자
	//UserDAO가 실행되면 자동으로 생성되는 부분
	//메소드마다 반복되는 코드를 이곳에 넣으면 코드가 간소화된다
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/LofiP";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//////////////////////////////// 로그인 ////////////////////////////////
	public int login(String uID, String uPw) {
		String sql = "select uPw from userInfo where uID = ?";
		try {
			pstmt1 = conn.prepareStatement(sql); //sql쿼리문을 대기 시킨다
			pstmt1.setString(1, uID); //첫번째 '?'에 매개변수로 받아온 'uID'를 대입
			rs1 = pstmt1.executeQuery(); //쿼리를 실행한 결과를 rs1에 저장
			if(rs1.next()) {
				if(rs1.getString(1).equals(uPw)) {
					return 1; //로그인 성공
					}else {
					return 0; //비밀번호 틀림
				}
			}
			return -1; //아이디 없음
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -2; //오류
	}
	
	//////////////////////////////// 회원가입 ////////////////////////////////
	public int join(User user) {
		  String sql = "insert into userInfo values(?, ?, ?, ?, ?, ?, ?)";
		  try {
		    pstmt1 = conn.prepareStatement(sql);
		    pstmt1.setString(1, user.getNationality());
		    pstmt1.setString(2, user.getCertify());
		    pstmt1.setString(3, user.getuID());
		    pstmt1.setString(4, user.getuPw());
		    pstmt1.setString(5, user.getuZip());
		    pstmt1.setString(6, user.getuAddr1());
		    pstmt1.setString(7, user.getuAddr2());
		    return pstmt1.executeUpdate();
		  }catch (Exception e) {
		 	e.printStackTrace();
		  }
		  return -1;
		}
	
	//////////////////////////////// 회원탈퇴 ////////////////////////////////
	public User getUser(String uID) {
		String sql = "select * from userInfo where uID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uID);
			rs1 = pstmt.executeQuery();
			if(rs1.next()) {
				User userC = new User();
				userC.setuID(rs1.getString(1));
				return userC;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int CMS(User user) {
		  String sql = "delete from userInfo where uID=?";
		  try {
		    pstmt1 = conn.prepareStatement(sql);
		    pstmt1.setString(1, user.getuID());

		    return pstmt1.executeUpdate();
		  }catch (Exception e) {
		 	e.printStackTrace();
		  }
		  return -1;
		}
	
	////////////////////////////////회원 정보 수정용 확인 ////////////////////////////////
	public int UserInfo(String uID, String uPw) {
		String sql = "select uPw from user where uID = ?";
		try {
			pstmt1 = conn.prepareStatement(sql); //sql쿼리문을 대기 시킨다
			pstmt1.setString(1, uID); //첫번째 '?'에 매개변수로 받아온 'uID'를 대입
			rs1 = pstmt1.executeQuery(); //쿼리를 실행한 결과를 rs1에 저장
			if(rs1.next()) {
				if(rs1.getString(1).equals(uPw)) {
					return 1; //로그인 성공
					}else
						return 0; //비밀번호 틀림
				}
			return -1; //아이디 없음
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -2; //오류
	}
}