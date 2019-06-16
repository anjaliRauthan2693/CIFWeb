package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.DaoImplementation;
import entity.customer;

/**
 * Servlet implementation class transactionDet
 */
@WebServlet("/transactionDet")
public class transactionDet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transactionDet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("m in det servlet");
		String page1 = "Transaction_detail.jsp";
		HttpSession session = request.getSession();
		if(request.getParameter("Back")!= null)
		{
			 page1 = "Transaction.jsp";
		}
		else 
		{
			String action = request.getParameter("action");
			System.out.println("action "+ action);
			System.out.println(session.getAttribute("Func"));
			if(session.getAttribute("Func").equals("inquire")) 
			{
				System.out.println("inside inq go");
				if(request.getParameter("Go")!= null)
				{
					 page1 = "Transaction.jsp";
					 System.out.println(page1);
				}
			}
			if(session.getAttribute("Func").equals("add")) 
			{  
				if(request.getParameter("Go")!= null) 
				{
					if(action.equals("main")) {
						System.out.println(request.getParameter("name"));
						String name = request.getParameter("name");
						System.out.println(request.getParameter("state"));
						String state = request.getParameter("state");
						String msg = "";
						
						session.setAttribute("name", name);
						//session.setAttribute("state", state);
						if(name == null)
						{
							msg = "Please visit personal detail page";
						}
						else if(state == null)
						{
							msg = "Please visit Address detail page";
						}
						session.setAttribute("msg", msg);
						page1 = "Transaction_detail.jsp";
					}
					if(action.equals("address") || action.equals("salary")) {
						DaoImplementation dao = new DaoImplementation();
						 System.out.println(dao);
						 customer cus = new customer();
						 cus.setFullname((String)session.getAttribute("fullname"));
						 cus.setAge((int)session.getAttribute("age"));
						 cus.setEmail((String)session.getAttribute("email"));
						 cus.setPhone((String)session.getAttribute("phone"));
						 cus.setHouse((String)session.getAttribute("house"));
						 cus.setState((String)session.getAttribute("state"));
						 cus.setPin((int)session.getAttribute("pin"));
						 cus.setSalary(Integer.parseInt(request.getParameter("salary")));
						 cus.setBonus(Integer.parseInt(request.getParameter("bonus")));
						String  msg = dao.add(cus);
						if(msg != null) {
							session.setAttribute("msg", msg);
							page1 = "Transaction_result.jsp";
						}
						 
					}
				}
				if(request.getParameter("Next")!= null) {
					if(action.equals("main")) {
						session.setAttribute("name", request.getParameter("name"));
						session.setAttribute("age", Integer.parseInt(request.getParameter("age")));
						session.setAttribute("email", request.getParameter("email"));
						session.setAttribute("phone", request.getParameter("phone"));
						page1 = "Tran_detail_Address.jsp";
					}
					if(action.equals("address")) {
						session.setAttribute("house", request.getParameter("house"));
						session.setAttribute("city", request.getParameter("city"));
						session.setAttribute("state", request.getParameter("state"));
						session.setAttribute("pin", Integer.parseInt(request.getParameter("pin")));
						page1 = "Tran_detail_salary.jsp";
					}
				}
			}
		}
		request.getRequestDispatcher(page1).include(request, response);
	}
}
