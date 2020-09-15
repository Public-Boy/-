package com.weiwei.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weiwei.Dao.UsersTableDao;
import com.weiwei.Dao.oredsDao;
import com.weiwei.Entity.oreds;
import com.weiwei.javabean.oredsID;


/**
 * Servlet implementation class Doorders
 */
@WebServlet("/Doorders")
public class Doorders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doorders() {
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
		String fid =request.getParameter("flight_id");    //飞机编号
		String uname = request.getParameter("passenger_name");	//乘机人真实姓名
		String grade = request.getParameter("grade"); 			//机票等次
		String carid = request.getParameter("passenger_id");  //身份证
		String mname = request.getParameter("mname"); 			//联系人姓名
		String mdh = request.getParameter("mdh");     //联系人手机号
		String dtime = request.getParameter("dtime");  //起飞时间
		oredsID o=new oredsID();
		String ordeid=o.generateUniqueKey(); 		//订单编号
		int piao=o.piao();
		String uuname = request.getParameter("uuname");
		String ttime = request.getParameter("ttime");
		String blrid="01025886622";
		String ozt="1";
		int id =Integer.parseInt(request.getParameter("flight_id"));    //飞机编号
	
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("ordeid", ordeid);
		session.setAttribute("dtime", dtime);	
		session.setAttribute("grade", grade);
		session.setAttribute("carid", carid);
		session.setAttribute("mname", mname);
		session.setAttribute("mdh", mdh);
		session.setAttribute("fid", fid);
		session.setAttribute("uname", uname);
		session.setAttribute("ttime", ttime);
		session.setAttribute("piao", piao);
		session.setAttribute("blrid", blrid);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d=null;
		try {
			d=sdf.parse(dtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		oreds or=new oreds(ordeid,uuname,uname,carid,grade,mname,mdh,d,fid,piao,ozt);

		int sid =(int)session.getAttribute("ffid");

		int jg = oredsDao.Addorde(or);
		w.write("<script>");
		if(jg>0){
			int level = (Integer)session.getAttribute("level");
			oredsDao.updatepiao(level,sid);
			
			w.write("location.href='ordeshow.jsp;'");

			
		}else{
			w.write("alert('购买失败');");
			w.write("location.href='indext.jsp;'");
		}
		w.write("</script>");
	}

}
