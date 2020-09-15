package com.weiwei.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weiwei.Dao.BoxDao;
import com.weiwei.Entity.Box;

/**
 * Servlet implementation class DoBoxAdd
 */
@WebServlet("/DoBoxAdd")
public class DoBoxAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoBoxAdd() {
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
		String uuname = request.getParameter("uuname"); //姓名
		String ddhm = request.getParameter("ddhm");		//电话号码
		String title = request.getParameter("title");	//标题
		String bobyy = request.getParameter("bobyy");		//正文
		
		Box b=new Box(uuname,ddhm,title,bobyy);
		
		int jg = BoxDao.add(b);
		

		
		w.write("<script>");
		if(jg>0){
			w.write("alert('感谢您的建议');");
			w.write("location.href='indext.jsp;'");
		}else{
			w.write("alert('感谢您的建议');");
			w.write("location.href='indext.jsp;'");
		}
		w.write("</script>");
				}
		
		}	
