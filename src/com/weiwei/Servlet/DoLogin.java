package com.weiwei.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weiwei.Dao.UsersTableDao;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
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
		
		String UserNumber=request.getParameter("usernumber");
		String pwd=request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		session.setAttribute("UserNumber", UserNumber);
		session.setAttribute("pwd", pwd);	
		
		
		
		int jg = UsersTableDao.Login(UserNumber, pwd);
			
		
		w.write("<script>");
			if(jg>0){
				w.write("alert('登入成功');");
				w.write("location.href='indext.jsp;'");
			}else{
				w.write("alert('登入失败');");
				w.write("location.href='indext.jsp;'");
			}
			w.write("</script>");
		}
	}
