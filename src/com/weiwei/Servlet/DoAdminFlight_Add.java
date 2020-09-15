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
		
		String fname = request.getParameter("flight_id"); //�����
		String fchufa = request.getParameter("start_place"); //������
		String fdaoda = request.getParameter("end_place"); 	//�����
		String fchufajichang = request.getParameter("start_airport"); //��������
		String fdaodajichang = request.getParameter("end_airport");  //�������
		String ftime = request.getParameter("flight_time"); 		//��������
		String fchufatime = request.getParameter("take_off_time"); 		//����ʱ��
		String fdaodatime = request.getParameter("landing_time"); 		//����ʱ��
		String ffp = request.getParameter("first_class_price");			//ͷ�Ȳռ۸�
		String fbp = request.getParameter("business_class_price");		//����ռ۸�
		String fep = request.getParameter("economy_class_price");		//���òռ۸�
		String ffy = request.getParameter("first_class_piao");			//ͷ�Ȳ���Ʊ
		String fby = request.getParameter("business_class_piao");		//�������Ʊ
		String fey = request.getParameter("economy_class_piao");		//���ò���Ʊ
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
