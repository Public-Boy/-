package com.weiwei.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weiwei.Dao.UsersTableDao;
import com.weiwei.Entity.flight;

/**
 * Servlet implementation class Doorder
 */
@WebServlet("/Doorder")
public class Doorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int fid = Integer.parseInt(request.getParameter("fid"));
		int level = Integer.parseInt(request.getParameter("level"));
	
		String chufajichang = request.getParameter("fchufajichang");
		
		
		flight f = UsersTableDao.tickteid(fid);
		HttpSession session = request.getSession();
		
		String chufa = request.getParameter("chufa");
		
		session.setAttribute("chufa", chufa);
		session.setAttribute("ffid", fid);
		session.setAttribute("level", level);
		
	
		request.setAttribute("f",f);
		
		request.getRequestDispatcher("order.jsp").forward(request, response);
		
	}

}
