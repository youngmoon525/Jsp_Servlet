import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.MemberDAO;
import com.hanul.study.MemberDTO;

@WebServlet("/s03.do")
public class Servlet03 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//① 클라이언트의 요청을 받는다 : 입력값(매개변수)을 가져온다 ▶ request.getParameter();
		/*request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		
		System.out.println("이름 : " + name);
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + addr);
		System.out.println("전화번호 : " + tel);
		
		MemberDTO dto = new MemberDTO(name, id, pw, age, addr, tel);*/
		
		request.setCharacterEncoding("utf-8");	//인코딩 설정
		MemberDTO dto = new MemberDTO();
		dto.setName(request.getParameter("name"));
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setAddr(request.getParameter("addr"));
		dto.setTel(request.getParameter("tel"));
		
		//② 비지니스 로직 : DataBase와 연동 → DAO Class ▶ Model
		MemberDAO dao = new MemberDAO();
		int succ = dao.memberInsert(dto);
		
		//③ 프리젠테이션 로직 : 결과를 응답 → html / jsp ▶ View
		response.setContentType("text/html; charset=utf-8");	//MIME Type
		PrintWriter out = response.getWriter();		//출력스트림
		if(succ > 0) {	//성공
			out.println("<script>alert('회원가입 성공!');</script>");
			out.println("<a href='memberMain.html'>회원가입 화면으로 이동</a>");
			out.println("<br/><br/>");
			out.println("<a href='s04.do'>전체회원 목록보기</a>");
		}else {			//실패
			out.println("<script>alert('회원가입 실패!');</script>");
			out.println("<a href='memberMain.html'>회원가입 화면으로 이동</a>");
			out.println("<br/><br/>");
			out.println("<a href='s04.do'>전체회원 목록보기</a>");
		}
	}
}//class
