package com.weiwei.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weiwei.Dao.UsersTableDao;
import com.weiwei.Entity.flight;

/**
 * Servlet implementation class DoselectTicket
 */
@WebServlet("/DoselectTicket")
public class DoselectTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoselectTicket() {
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
		PrintWriter w = response.getWriter();
		String startplace = request.getParameter("chufa");
		String endplace = request.getParameter("daoda");	
		w.write("<script>");
		List<flight> list = UsersTableDao.selectflight(startplace,endplace);
		request.setAttribute("list",list);
		if(list.size()<0){
			w.write("alert('对不起，未找到您需要的航班，请重新查找');");
		}else{
		request.getRequestDispatcher("Ticket.jsp").forward(request, response);
		
		w.write("</script>");
		}
	}

}
