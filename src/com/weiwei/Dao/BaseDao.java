package com.weiwei.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	public static Connection Getconn(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn= DriverManager.getConnection
					("jdbc:mysql://127.0.0.1:3306/plane?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
					"root","1314520hsw");
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void CloseAll(Connection conn,Statement stat,ResultSet rs){
		try {
			if(conn!=null){
				conn.close();
			}
			if(stat!=null){
				stat.close();	
			}
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
