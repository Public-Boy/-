package com.weiwei.Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.weiwei.Dao.BaseDao;
@WebServlet("/GetDropdownDataServlets")
public class GetDropdownDataServlets extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDropdownDataServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		String parentId = request.getParameter("parentId");
		if(parentId == null || parentId==""){
			parentId = "0";//������ĸ����Ϊ�գ���Ĭ�ϸ�ֵΪ�й��ĸ���㣬Ҳ����ÿһ����ѯ����ʡ�ݡ�
		}
		Connection conn = null;
		String json = "";
        try{
          conn= BaseDao.Getconn();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select region_id,region_name from region where parent_id = "+parentId);
            ArrayList rsList = new ArrayList();
            Map map = null;
            while(rs.next()){
            	map = new HashMap();
            	map.put("id", rs.getInt(1));
            	map.put("name", rs.getString(2));
            	rsList.add(map);
            }
            rs=null;
            Gson gson = new Gson();
            json = gson.toJson(rsList);
            System.out.println("json="+json);
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
        	if(conn != null){
        		try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
		response.setCharacterEncoding("UTF-8");//��ֹ����������������
		response.getWriter().print(json);
	}
}
