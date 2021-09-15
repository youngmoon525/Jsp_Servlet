import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.SumMachine;

@WebServlet("/s08.do")
public class Servlet08 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//① 클라이언트의 요청을 받는다 : 매개변수(입력값)를 가져온다 ▶ request.getParameter();
		request.setCharacterEncoding("utf-8");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		//② 비지니스 로직 : 두 정수 사이의 누적합 계산 ▶ 별도의 클래스에 작성
		SumMachine sm = new SumMachine();
		int sum = sm.getSum(num1, num2);
		
		//③ 프리젠테이션 로직 : 결과를 응답 ▶ Servlet09.java(s09.do) : response.sendRedirect();
		//sendRedirect() 방식 : 단순한 페이지 전환만 필요할 경우(연결할 객체가 없는 경우)
		//URL이 변경된다.
		//response.sendRedirect("s09.do");	//페이지 호출
		
		//sendRedirect() 방식을 페이지 전환을 할 경우 전달할 매개변수가 있다 ▶ get 방식
		response.sendRedirect("s09.do?num1=" + num1 + "&num2=" + num2 + "&sum=" + sum);
		
	}
}//class










