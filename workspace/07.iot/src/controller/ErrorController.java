package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorController
 */
@WebServlet("/error")
public class ErrorController extends HttpServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Throwable exception
		= (Throwable) req.getAttribute("javax.servlet.error.exception");
		StringBuffer msg = new StringBuffer();
		while (exception!=null) {
			msg.append("<p>").append(exception.getMessage()).append("</p>");
			exception = exception.getCause();//exception발생한 근본적인 원인을 리턴한다.
		}
		req.setAttribute("msg", msg.toString());
		int code = (int) req.getAttribute("javax.servlet.error.status_code");
		System.out.println(code);
		System.out.println(msg.toString());
		//=>
		RequestDispatcher rd = req.getRequestDispatcher("error/404.jsp");
		rd.forward(req, res);
		//스프링에서는 > return "페이지명";
	}

}
