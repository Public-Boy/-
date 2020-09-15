package com.weiwei.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weiwei.Dao.oredsDao;
import com.weiwei.Entity.oreds;

/**
 * Servlet implementation class DoSelect
 */
@WebServlet("/DoSelect")
public class DoSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoSelect() {
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
		
		String smob = request.getParameter("smob");
		HttpSession session = request.getSession();
		session.setAttribute("smob", smob);
		oreds o = oredsDao.select(smob);
		
		request.setAttribute("o",o);
		request.getRequestDispatcher("ordesselect.jsp").forward(request, response);
		
		
	}

}
