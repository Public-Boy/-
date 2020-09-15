package com.weiwei.Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weiwei.Dao.UsersTableDao;
import com.weiwei.Entity.flight;

/**
 * Servlet implementation class DoAdminFlight_Add
 */
@WebServlet("/DoAdminFlight_Add")
public class DoAdminFlight_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoAdminFlight_Add() {
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
		
		String fname = request.getParameter("flight_id"); //航班号
		String fchufa = request.getParameter("start_place"); //出发地
		String fdaoda = request.getParameter("end_place"); 	//到达地
		String fchufajichang = request.getParameter("start_airport"); //出发机场
		String fdaodajichang = request.getParameter("end_airport");  //到达机场
		String ftime = request.getParameter("flight_time"); 		//出发日期
		String fchufatime = request.getParameter("take_off_time"); 		//出发时间
		String fdaodatime = request.getParameter("landing_time"); 		//到达时间
		String ffp = request.getParameter("first_class_price");			//头等舱价格
		String fbp = request.getParameter("business_class_price");		//商务舱价格
		String fep = request.getParameter("economy_class_price");		//经济舱价格
		String ffy = request.getParameter("first_class_piao");			//头等舱余票
		String fby = request.getParameter("business_class_piao");		//商务舱余票
		String fey = request.getParameter("economy_class_piao");		//经济舱余票
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		Date d=null;
		try {
			d = sdf.parse(ftime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		flight fb=new flight(fname,fchufa,fdaoda,fchufajichang,fdaodajichang,d,fchufatime,fdaodatime,ffy,fby,fey,ffp,fbp,fep);
		
		int jg = UsersTableDao.AdminflightAdd(fb);
		
		System.out.println(fname+"--"+fchufa+"--"+fdaoda+"--"+fchufajichang+"--"+fdaodajichang+"--"+d+"--"+fchufatime+"--"+fdaodatime+"--"+ffy+"--"+fby+"--"+fey+"--"+ffp+"--"+fbp+"--"+fep);
		
		System.out.println(jg);
		if(jg>0){
			response.sendRedirect("Admin/flight_list.jsp");
		}else{
			response.sendRedirect("Admin/flight_add.jsp");
		}
		
	}

}
