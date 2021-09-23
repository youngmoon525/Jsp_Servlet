package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberServiceImpl;
import member.MemberVO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet(urlPatterns = {    "/login"    , "/iotlogin" , "/logout" , "/join"  ,"/id_check"     })
public class MemberController extends HttpServlet {
//login = login.jsp 연결용
//iotlogin = 실제 db연동 로그인처리용
//join = join.jsp 회원가입 페이지 연결용
//
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			RequestDispatcher rd ;
			if(req.getServletPath().equals("/login")) {
				rd = req.getRequestDispatcher("member/login.jsp");
				rd.forward(req, res);
			}else if(req.getServletPath().equals("/iotlogin")) {
				login(req,res);
			}else if(req.getServletPath().equals("/logout")) {
				HttpSession session = req.getSession();
				session.removeAttribute("logininfo");
				res.sendRedirect("home");
			}else if(req.getServletPath().equals("/join")) {
				rd = req.getRequestDispatcher("member/join.jsp");
				rd.forward(req, res);
			}else if(req.getServletPath().equals("/id_check")) {
				id_check(req, res);
			}
			
		
	}
	MemberServiceImpl service = new MemberServiceImpl();
	private void id_check(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String id = req.getParameter("id");
		boolean result = service.member_id_check(id);
		PrintWriter out = res.getWriter();
		out.print(result);
		//--?
	}
	
	private void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//Mybatis를 이용해서 로그인을 처리할수있는 로직을 호출.
		HashMap<String, String> map = new HashMap<>();
		map.put("id", req.getParameter("id")+"");
		map.put("pw", req.getParameter("pw")+"");
		MemberVO vo = service.member_login(map);//<map을 만들어야함. (인지)
		
		
		//Session (로그인 , 장바구니 .. 등등 )
		//사용자가 인터넷을 종료하기 전까지 , 톰캣서버를 리스타트 하기 전까지
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		//DB에서 정보를 조회해서 그건수가 1건이라도 있으면 회원이다.
		session.setAttribute("logininfo", vo);
		boolean rtnBool = vo==null ? false : true;
		out.print(rtnBool);
	}
}
