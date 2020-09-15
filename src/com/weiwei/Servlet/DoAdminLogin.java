package com.weiwei.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weiwei.Dao.AdminDao;

/**
 * Servlet implementation class DoAdminLogin
 */
@WebServlet("/DoAdminLogin")
public class DoAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoAdminLogin() {
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
		PrintWriter w = response.getWriter();
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("pwd", pwd);	
		
		
		int jg = AdminDao.AdminLogin(user, pwd);
		
		w.write("<script>");
		if(jg>0){
			w.write("alert('登入成功');");
			w.write("location.href='Admin/indext.jsp;'");
		}else{
			w.write("alert('登入失败');");
			w.write("location.href='Admin/Login.jsp;'");
		}
		w.write("</script>");
	}
		
	}

