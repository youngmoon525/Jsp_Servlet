package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestConn
 */
@WebServlet( urlPatterns = { "/port"  , "/port2" })
public class TestConn extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("port페이지 연결");
		//index.jsp
		//
		RequestDispatcher rd = req.getRequestDispatcher("test/port.jsp");
		rd.forward(req, res);
	}

}
