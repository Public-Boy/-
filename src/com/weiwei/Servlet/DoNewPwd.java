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
 * Servlet implementation class DoNewPwd
 */
@WebServlet("/DoNewPwd")
public class DoNewPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoNewPwd() {
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
		
		String car = request.getParameter("car");
		String mobeli = request.getParameter("mobeli");
		String emali = request.getParameter("emali");
		String newpwd = request.getParameter("newpwd");
		PrintWriter w = response.getWriter();
		int jg = UsersTableDao.DoNewPwd(car, mobeli, emali, newpwd);
		
		System.out.println(car+"--"+mobeli+"--"+emali+"--"+newpwd);
		
		w.write("<script>");
		if(jg>0){
			w.write("alert('√‹¬Î“—–ﬁ∏ƒ');");
			w.write("location.href='Login.jsp;'");
		}else{
			w.write("alert('√‹¬Î–ﬁ∏ƒ ß∞‹£¨«Î÷ÿ ‘');");
			w.write("location.href='DontPwd.jsp;'");
		}
		w.write("</script>");
		}
		
	}
