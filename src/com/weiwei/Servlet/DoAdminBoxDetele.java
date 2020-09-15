package com.weiwei.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weiwei.Dao.BoxDao;

/**
 * Servlet implementation class DoAdminBoxDetele
 */
@WebServlet("/DoAdminBoxDetele")
public class DoAdminBoxDetele extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoAdminBoxDetele() {
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
		int id =Integer.parseInt(request.getParameter("id"));
		
		int jg = BoxDao.DoAdminBoxDelete(id);
		w.write("<script>");
		if(jg>0){
			w.write("alert('ɾ���ɹ�');");
			w.write("location.href='./DoselectBox'");
		}else{
			w.write("alert('ɾ��ʧ��');");
			w.write("location.href='./DoselectBox'");
		}
		w.write("</script>");
		}
	}
