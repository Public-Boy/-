package com.weiwei.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weiwei.Dao.UsersTableDao;
import com.weiwei.Entity.flight;

/**
 * Servlet implementation class AdminflightUpdate
 */
@WebServlet("/AdminflightUpdate")
public class AdminflightUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminflightUpdate() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id =Integer.parseInt( request.getParameter("id"));
		
		flight f = UsersTableDao.selectfid(id);
		System.out.println(id);
		request.setAttribute("f",f);
		request.getRequestDispatcher("Admin/AdminflightUpdate.jsp").forward(request, response);
		
	}

}
