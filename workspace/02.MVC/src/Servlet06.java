import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.CalcDTO;
import com.hanul.study.SumMachine;

@WebServlet("/s06.do")
public class Servlet06 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		//① 클라이언트의 요청을 받는다 : 매개변수를 가져온다 ▶ request.getParameter();
		request.setCharacterEncoding("utf-8");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		//② 비니지스 로직 : 두 정수 사이의 누적합 계산 ▶ 별도의 클래스에 작성
		SumMachine sm = new SumMachine();
		int sum = sm.getSum(num1, num2);
		CalcDTO dto = new CalcDTO(num1, num2, sum);
		
		//③ 프리젠테이션 로직 : 결과를 응답 ▶ Servlet07.java(s07.do) 페이지 전환 : request.forward();
		//forward() 방식 : 페이지 전환 시 연결할 객체(가지고 갈 객체)가 있을 경우
		//url이 변경되지 않는다 ▶ 일반적으로 많이 사용하는 동적 페이지 전환 방식
		request.setAttribute("num1", num1);	//바인딩(연결) 객체
		request.setAttribute("num2", num2);
		request.setAttribute("sum", sum);
		request.setAttribute("dto", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("s07.do");	//페이지 호출
		
		rd.forward(request, response);		//동적 페이지 전환
	}
}
