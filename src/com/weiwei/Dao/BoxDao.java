package com.weiwei.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weiwei.Entity.Box;
public class BoxDao {
	
	//添加信箱
	public static int add(Box b){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="insert into Box values(null,?,?,?,?)";
		PreparedStatement stat=null;
		try {
			stat = conn.prepareStatement(sql);
			
			stat.setString(1,b.getBname());
			stat.setString(2,b.getBmobli());
			stat.setString(3,b.getBtitle());
			stat.setString(4,b.getBboby());
			
			jg = stat.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, null);
		}
		
		return jg;
	}

	//查询信箱
	public static List<Box> selectBox(){
		List<Box> list=new ArrayList<Box>();
		Connection conn = BaseDao.Getconn();
		String sql="select * from Box";
		Statement stat=null;
		ResultSet rs =null;
		try {
			stat = conn.createStatement();
			rs= stat.executeQuery(sql);
			
			while (rs.next()) {
				Box b=new Box();
				b.setBid(rs.getInt(1));
				b.setBname(rs.getString(2));
				b.setBmobli(rs.getString(3));
				b.setBtitle(rs.getString(4));
				b.setBboby(rs.getString(5));
				
				list.add(b);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, rs);
		}
		
		return list;
	}
	
	//删除信箱
	public static int DoAdminBoxDelete(int id){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="delete from Box where Bid=?";
		CallableStatement stat=null;
		try {
			 stat= conn.prepareCall(sql);
			 
			 stat.setInt(1,id);
			 
			 jg = stat.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, null);
		}
		
		return jg;
	}

	}	