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
		}else if(url.equals("/update.cu")) {
			//<form>
			//name , gender , email , phone 
			// id ( hidden )
			//</form>
			//1.View에서 보내준(요청시) 데이터가 정상적으로 Controller까지 오는지 체크
			req.setCharacterEncoding("utf-8");
//			System.out.println(req.getParameter("id"));
//			System.out.println(req.getParameter("gender"));
//			System.out.println(req.getParameter("name"));
//			System.out.println(req.getParameter("email"));
//			System.out.println(req.getParameter("phone"));
			//2.Service(Interface)를 확인하고 어떤 메소드를 이용해서 로직처리를 할껀지 생각.
			//	-설계도를 업데이트
			//	-실제 비지니스로직(데이터 처리)
			CustomerVO vo = new CustomerVO();
			vo.setId(Integer.parseInt(req.getParameter("id")+""));
			vo.setGender(req.getParameter("gender")+"");
			vo.setEmail(req.getParameter("email")+"");
			vo.setName(req.getParameter("name")+"");
			vo.setPhone(req.getParameter("phone")+"");
			cusService.customer_update(vo);
			//3.페이지 전환
			//resp.sendRedirect(req.getContextPath() + "/list.cu"); -데이터 전송이 없음(경로만설정함)
			//rd.forward(req, resp);   - 데이터 전송이 있음(Request,Response)
			//resp.sendRedirect(req.getContextPath() + "/list.cu");//list.cu
			req.setAttribute("id", vo.getId());
			rd = req.getRequestDispatcher("detail.cu");
			rd.forward(req, resp);
			
		}else if(url.equals("/delete.cu")) {
			//1.View(.Jsp)파일에서 요청할때 (데이터) 가 정상적으로 넘어오는지 확인.-O
			//2.비지니스 로직 수행 ( Interface ) - CustomerService
			//	-customerserviceImpl 호출
			//  -Impl-> DAO
			//  -DAO > MybatisMapper ( openSession  , 처리)
			cusService.customer_delete(Integer.parseInt( req.getParameter("id")+"" ));
			resp.sendRedirect(req.getContextPath() + "/list.cu");
			
		}else {
			rd.forward(req, resp);
		}
	}

}
