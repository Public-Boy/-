package com.weiwei.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weiwei.Dao.oredsDao;

/**
 * Servlet implementation class DoUserOrderSC
 */
@WebServlet("/DoUserOrderSC")
public class DoUserOrderSC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserOrderSC() {
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter w = response.getWriter();
		int fid =Integer.parseInt( request.getParameter("id"));
		
		int jg = oredsDao.delect(fid);
		
		
		w.write("<script>");
		if(jg>0){
			w.write("alert('É¾³ý³É¹¦');");
			w.write("location.href='DoUserSelctOreds;'");
		}else{
			w.write("alert('É¾³ýÊ§°Ü');");
			w.write("location.href='DoUserSelctOreds;'");
		}
		w.write("</script>");
		
	}

}
