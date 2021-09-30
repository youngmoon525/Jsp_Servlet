package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardPage;
import board.BoardServiceImpl;
import board.BoardVO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	BoardServiceImpl boService = new BoardServiceImpl();
	BoardPage page = new BoardPage();//PageVO에있는 기능을 상속받고 + 필드 List<BoardVO>
	//Spring에서는 의존성 자동주입 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		String url = req.getServletPath();
		RequestDispatcher rd = req.getRequestDispatcher("error/404.jsp");
		if(url.equals("/list.bo")) {
			//List<BoardVO> list =boService.board_list();
			//데이터를 가지고옴 ↑
			//req.setAttribute("list", list);
			//데이터를 챙김↑
			//req.setAttribute("list",boService.board_list());
			//↑일반적인 데이터 조회만 함 페이징처리(게시판처리 x)
			System.out.println(req.getParameter("search"));
			System.out.println(req.getParameter("keyword"));
			
			int curPage = req.getParameter("curPage") == null ? 1 : Integer.parseInt(req.getParameter("curPage")+"");
			page.setKeyword(req.getParameter("keyword"));
			page.setSearch(req.getParameter("search"));
			page.setCurPage(curPage);//페이지전환을 위한 요청이 들어오면 들어온 데이터로 페이지를 바꿈
			req.setAttribute("page", boService.board_list(page) ) ;//Page에 정보들을 전부 가지고있고 + list
			
			rd = req.getRequestDispatcher("board/list.jsp");
			rd.forward(req, resp);
		}
	}
}
