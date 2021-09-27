package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerServiceImpl;
import customer.CustomerVO;

/**
 * Servlet implementation class CustomerController
 */ 
@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	CustomerServiceImpl cusService = new CustomerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println(cusService.customer_test() ) ;
		System.out.println(req.getServletPath());
		String url = req.getServletPath();
		RequestDispatcher rd = req.getRequestDispatcher("error/404.jsp");
		if(url.equals("/list.cu")) {
			rd = req.getRequestDispatcher("customer/list.jsp");
			req.setAttribute("list", cusService.customer_list());
			rd.forward(req, resp);
		}else if(url.equals("/detail.cu")) {
			rd = req.getRequestDispatcher("customer/detail.jsp");
			int id = Integer.parseInt( req.getParameter("id")+"" ) ;
			req.setAttribute("vo", cusService.customer_detail(id));
			rd.forward(req, resp);
		}else if (url.equals("/new.cu")) {
			rd = req.getRequestDispatcher("customer/new.jsp");
			rd.forward(req, resp);
		}else if (url.equals("/insert.cu")) {
			//사용자가 요청한 정보를 제대로 저장.※
			//요청한 정보가 들어왔는지 확인.
			req.setCharacterEncoding("utf-8"); 
			///System.out.println(req.getParameter("name"));
			//System.out.println(req.getParameter("gender"));
			//System.out.println(req.getParameter("phone"));
			//System.out.println(req.getParameter("email"));
			CustomerVO vo = new CustomerVO();
			vo.setName(req.getParameter("name"));
			vo.setGender(req.getParameter("gender"));
			vo.setPhone(req.getParameter("phone"));
			vo.setEmail(req.getParameter("email"));
			cusService.customer_insert(vo);
			resp.sendRedirect(req.getContextPath() + "/list.cu");
			
		}else if(url.equals("/modify.cu")) {
			int id = Integer.parseInt( req.getParameter("id")+"" ) ;
			rd = req.getRequestDispatcher("customer/modify.jsp");
			req.setAttribute("vo", cusService.customer_detail(id));
			rd.forward(req, resp);
		}
		
		else {
			rd.forward(req, resp);
		}
	}

}
