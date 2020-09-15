package com.weiwei.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weiwei.Dao.UserOrdesXQDao;
import com.weiwei.Entity.UserOrdesXQ;

/**
 * Servlet implementation class DoXQ
 */
@WebServlet("/DoXQ")
public class DoXQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoXQ() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		String sfz = request.getParameter("sfz");

		UserOrdesXQ u = UserOrdesXQDao.SelectAll(id, sfz);
		request.setAttribute("u",u);
		
		
		request.getRequestDispatcher("./UserOrdesSelectXQ.jsp").forward(request, response);
		
	
	}

}
