import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.CalcDTO;
import com.hanul.study.SumMachine;

@WebServlet("/s02.do")
public class Servlet02 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//① 클라이언트의 요청을 받는다 : 매개변수 값을 가져온다 ▶ request.getParameter();
		request.setCharacterEncoding("utf-8");	//인코딩 설정
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		//② 비지니스 로직 : 별도의 클래스로 작성(Model) ▶ com.hanul.study package
		SumMachine sm = new SumMachine();	//객체생성
		int sum = sm.getSum(num1, num2);	//메소드를 호출하고 결과를 리턴받는다
		CalcDTO dto = new CalcDTO(num1, num2, sum);
		
		//③ 프리젠이션 로직 : 결과를 응답(View) ▶ result.jsp
		request.setAttribute("dto", dto);	//바인딩(연결) 객체
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");	//페이지 호출
		rd.forward(request, response);		//페이지 전환
	}
}
