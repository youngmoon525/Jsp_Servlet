package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.ExamDAO;
import exam.ExamVO;

/**
 * Servlet implementation class ExamController
 */
@WebServlet(urlPatterns = { "/exam", "/grading" })
public class ExamController extends HttpServlet {

	@Override // 재정의
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// DAO객체를 통해서 문제를 얻어옴.
		if (req.getServletPath().equals("/exam")) {

			ExamDAO dao = new ExamDAO();
			List<ExamVO> list = dao.getList();
		
			HttpSession session = req.getSession();
			session.setAttribute("list", list); // Login정보처럼 사용가능 session에 물려놈

			RequestDispatcher rd = req.getRequestDispatcher("exam/examMain.jsp");
			rd.forward(req, resp);
			
		}else if(req.getServletPath().equals("/grading")) {
			//Session에 물려놓은 정보를 다시 가져오기
			HttpSession session = req.getSession();//web.xml time-out 
			List<ExamVO> list = (List<ExamVO>) session.getAttribute("list");
			req.setCharacterEncoding("UTF-8");
			//원본에 있는 데이터를 가지고 옴.
			int totalcnt = Integer.parseInt( req.getParameter("totalcnt")+"" );
			for (int i = 0; i < totalcnt; i++) {
				//result 1 = 맞음 , 0은 틀림
				try {
					if(req.getParameter((i+1)+"").equals(list.get(i).getAnswer()) ){
						list.get(i).result = 1;//정답
						list.get(i).user_result = req.getParameter((i+1)+"");
					}else {
						list.get(i).result = 0;
						list.get(i).user_result = req.getParameter((i+1)+"") == null ? "문제안품" : req.getParameter((i+1)+"");
						
					}
				}catch (Exception e) {
					list.get(i).result = 0;
					list.get(i).user_result = "x";
				}
			}
			for (ExamVO vo : list) {
				System.out.print(vo.getNo() + "번 문제 " );
				System.out.print(vo.result == 0 ? " 오답 " : " 정답 ");
				System.out.print("\t사용자가 제출한 답안 : " + vo.user_result);
				System.out.println("\t실제 답안 : " + vo.getAnswer());
			}
			//사용자가 제출한 답안을 전부 가지고옴.
			//String 안풀었을때 null , 사용자가 답을 입력  
		}
	}
}
