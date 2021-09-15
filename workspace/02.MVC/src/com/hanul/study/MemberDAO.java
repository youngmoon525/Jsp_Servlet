package com.hanul.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	private Connection conn;		//연결객체
	private PreparedStatement ps;	//전송객체
	private ResultSet rs;			//결과객체 : select Query
	
	//DB 접속 : ojdbc6.jar ▶ WebContent > WEB-INF > lib 등록 → 정적로딩
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//동적로딩
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();	//예외발생의 원인을 상세하게 출력
			System.out.println("getConn() Exception!!!");
		}
		return conn;
	}//getConn()
	
	//DB 접속 해제 : 역순으로 해제(rs → ps → conn)
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//dbClose()
	
	//회원가입
	public int memberInsert(MemberDTO dto) {
		conn = getConn();	//DB접속
		String sql = "insert into Member values(?, ?, ?, ?, ?, ?)";	//SQL 문장 작성
		int succ = 0;		//성공여부를 판단
		try {
			ps = conn.prepareStatement(sql);	//전송객체
			ps.setString(1, dto.getName());		//입력값(매개변수)을 세팅(할당)
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getAddr());
			ps.setString(6, dto.getTel());
			succ = ps.executeUpdate();			//실행
		} catch (Exception e) {
			e.printStackTrace();	//예외 발생 시 예외의 원인을 상세하게 출력
			System.out.println("memberInsert() Exception!!!");
		} finally {
			dbClose();		//DB접속 해제
		}
		return succ;
	}//memberInsert()
	
	//전체회원 목록검색
	public ArrayList<MemberDTO> memberSearchAll() {
		conn = getConn();	//DB접속
		String sql = "select * from Member";	//SQL 문장 작성
		ArrayList<MemberDTO> list = new ArrayList<>();	//검색 목록을 저장할 컬렉션
		try {
			ps = conn.prepareStatement(sql);	//SQL 문장 전송
			rs = ps.executeQuery();				//실행 → 결과 객체
			while(rs.next()) {
				/*String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				MemberDTO dto = new MemberDTO(name, id, pw, age, addr, tel);
				list.add(dto);*/
				
				MemberDTO dto = new MemberDTO();
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setTel(rs.getString("tel"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("memberSearchAll() Exception!!!");
		} finally {
			dbClose();
		}
		return list;
	}//memberSearchAll()
	
	//회원정보 삭제
	public int memberDelete(String id) {
		conn = getConn();
		String sql = "delete from Member where id = ?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("memberDelete() Exception!!!");
		} finally {
			dbClose();
		}
		return succ;
	}//memberDelete()
		
}//class
