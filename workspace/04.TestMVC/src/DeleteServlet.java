import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.BookDAO;

@WebServlet("/ds.do")
public class DeleteServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//클라이언트 요청
		String isbn = request.getParameter("isbn");
		
		//비지로스 로직
		BookDAO dao = new BookDAO();
		int succ = dao.deleteBook(isbn);
		
		//프리젠이션 로직 : html
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();
		if(succ > 0) {
			out.println("<script>alert('도서정보 삭제성공!');</script>");
			out.println("<a href='bookMain.html'>도서정보 입력하기</a><br/><br/>");
			out.println("<a href='list.do'>전체도서 정보보기</a>");
		}else {
			out.println("<script>alert('도서정보 삭제실패!');</script>");
			out.println("<a href='bookMain.html'>도서정보 입력하기</a><br/><br/>");
			out.println("<a href='list.do'>전체도서 정보보기</a>");
		}
		
	}

}
