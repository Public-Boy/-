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
 * Servlet implementation class DoUserOrderTK
 */
@WebServlet("/DoUserOrderTK")
public class DoUserOrderTK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserOrderTK() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		PrintWriter w = response.getWriter();
		HttpSession session = request.getSession();
		int jg = oredsDao.DoUserTK(id);
		String number =(String) session.getAttribute("ordeid");

		w.write("<script>");
		if(jg>0){
			w.write("alert('退款成功!您的费用将在退款后3个工作日返回到您的银行卡');");
			w.write("location.href='DoUserSelctOreds;'");
		}else{
			w.write("alert('退款失败');");
			w.write("location.href='DoUserSelctOreds;'");
		}
		w.write("</script>");
			}
	}
