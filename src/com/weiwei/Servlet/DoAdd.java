package com.weiwei.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weiwei.Dao.UsersTableDao;
import com.weiwei.Entity.UsersTable;

/**
 * Servlet implementation class DoAdd
 */
@WebServlet("/DoAdd")
public class DoAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoAdd() {
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
		
		
		String username = request.getParameter("username");//用户名
		String uname = request.getParameter("uname");	 //真实姓名
		String pwd = request.getParameter("pwd");		//密码
		String yespwd = request.getParameter("yespwd");	//确认密码
		String typeid = request.getParameter("typeid");	//证件类型
		String typenumber = request.getParameter("typenumber");	//证件号码
		String number = request.getParameter("number");	//手机号码
		String email = request.getParameter("email");		//邮箱
		String img="../images/userimg.png";
		
		UsersTable u=new UsersTable(uname,username,pwd,yespwd,typeid,typenumber,number,email,img);
		
		System.out.println(uname+"--"+username+"--"+pwd+"--"+yespwd+"--"+typeid+"--"+typenumber+"--"+number+"--"+email);
		
		int jg = UsersTableDao.Add(u);
		w.write("<script>");
		if(jg>0){
			w.write("alert('注册成功');");
			w.write("location.href='indext.jsp;'");
		}else{
			w.write("alert('注册失败');");
			w.write("location.href='registered.jsp;'");
		}
		w.write("</script>");
	}

}
