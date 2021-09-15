import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hs.do")	//Servlet Mapping 자동설정
public class HelloServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");	//MIME Type
		PrintWriter out = response.getWriter();	//출력스트림 생성
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Response Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Hello Servlet^^</h3>");
		out.println("</body>");
		out.println("</html>");
	}//service()
}//class
