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
 * Servlet implementation class transaction
 */
@WebServlet("/transaction")
public class transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transaction() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("m in servlet");
		String page = "Transaction_detail.jsp";
		String msg = "";
		String function= request.getParameter("functions");
		String TranNo = request.getParameter("tranNo");
		System.out.println(function);
		System.out.println(TranNo);
		
		//-----setting session variable -----------
		 HttpSession session = request.getSession();
		session.setAttribute("Func", function);

		if(function.equals("inquire")) {
			System.out.println("inside inquire");
			DaoImplementation dao = new DaoImplementation();
			 System.out.println(dao);
			 customer cus1 = (customer)dao.Inquire(TranNo);
			 System.out.println(cus1);
			   if(cus1==null) {
				   msg = "Wrong Transaction Id";
				   page = "Transaction.jsp";
			   }
			   else {
				   System.out.println(cus1.getFullname());
				   session.setAttribute("name", cus1.getFullname());
				   session.setAttribute("age", cus1.getAge());
				   session.setAttribute("email", cus1.getEmail());
				   session.setAttribute("phone", cus1.getPhone());
				   
				   session.setAttribute("house", cus1.getHouse());
				   session.setAttribute("city", cus1.getCity());
				   session.setAttribute("state", cus1.getState());
				   session.setAttribute("pin", cus1.getPin());
				   
				   session.setAttribute("salary", cus1.getSalary());
				   session.setAttribute("bonus", cus1.getBonus());
	
			   }
		}
	    session.setAttribute("msg", msg);
		if(request.getParameter("Back")!= null) {
			 page = "finaclePage.jsp";
		}
		request.getRequestDispatcher(page).include(request, response);
	}

}
