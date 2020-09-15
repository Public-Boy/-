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
		
		
		String username = request.getParameter("username");//�û���
		String uname = request.getParameter("uname");	 //��ʵ����
		String pwd = request.getParameter("pwd");		//����
		String yespwd = request.getParameter("yespwd");	//ȷ������
		String typeid = request.getParameter("typeid");	//֤������
		String typenumber = request.getParameter("typenumber");	//֤������
		String number = request.getParameter("number");	//�ֻ�����
		String email = request.getParameter("email");		//����
		String img="../images/userimg.png";
		
		UsersTable u=new UsersTable(uname,username,pwd,yespwd,typeid,typenumber,number,email,img);
		
		System.out.println(uname+"--"+username+"--"+pwd+"--"+yespwd+"--"+typeid+"--"+typenumber+"--"+number+"--"+email);
		
		int jg = UsersTableDao.Add(u);
		w.write("<script>");
		if(jg>0){
			w.write("alert('ע��ɹ�');");
			w.write("location.href='indext.jsp;'");
		}else{
			w.write("alert('ע��ʧ��');");
			w.write("location.href='registered.jsp;'");
		}
		w.write("</script>");
	}

}
