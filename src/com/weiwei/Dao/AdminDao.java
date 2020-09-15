package com.weiwei.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
	public static int AdminLogin(String user,String pwd){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="select count(*) from Admin where user=? and pwd=?";
		CallableStatement stat =null;
		ResultSet rs =null;
		try {
			stat= conn.prepareCall(sql);
			stat.setString(1,user);
			stat.setString(2,pwd);
			
			rs= stat.executeQuery();
			
			while (rs.next()) {
				jg = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, rs);
		}
		
		
		return jg;
		}
	
}
