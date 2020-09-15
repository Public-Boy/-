package com.weiwei.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weiwei.Dao.oredsDao;

/**
 * Servlet implementation class DoUserSelectXQ
 */
@WebServlet("/DoUserSelectXQ")
public class DoUserSelectXQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserSelectXQ() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		String sfz = request.getParameter("sfz");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("id", id);
		session.setAttribute("sfz", sfz);	

		PrintWriter w = response.getWriter();
		int jg = oredsDao.UserSelectXQ(id, sfz);
	
		w.write("<script>");
		if(jg>0){
			w.write("alert('验证正确');");
			w.write("location.href='DoXQ?id="+id+"&sfz="+sfz+"'");
		}else{
			w.write("alert('验证错误!请检查身份证是否输入错误');");
			w.write("location.href='ordesselect.jsp;'");
		}
		w.write("</script>");
		
	}
		
	}

