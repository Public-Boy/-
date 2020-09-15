package com.weiwei.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weiwei.Dao.UsersTableDao;

/**
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/DoUserUpdate")
public class DoUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserUpdate() {
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
		
		String username = request.getParameter("username");
		String dhhm = request.getParameter("dhhm");
		String emailb = request.getParameter("emailb");
		
		int jg = UsersTableDao.DoUserUpdate(username, dhhm, emailb);
		
		System.out.println(username+"---"+dhhm+"---"+emailb);
		System.out.println(jg);
		
		PrintWriter w = response.getWriter();
		
		w.write("<script>");
		if(jg>0){
			w.write("alert('修改成功');");
			w.write("location.href='user_info.jsp;'");
		}else{
			w.write("alert('修改失败');");
			w.write("location.href='edit_info.jsp;'");
		}
		w.write("</script>");
		
	}

}
