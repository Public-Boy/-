package com.weiwei.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weiwei.Entity.oreds;

public class oredsDao {
	//购票
	public static int Addorde(oreds o){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="insert into oreds values(null,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stat=null;
		try {
		stat = conn.prepareStatement(sql);
		
		stat.setString(1, o.getOnumber());
		stat.setString(2, o.getOusername());
		stat.setString(3, o.getOname());
		stat.setString(4, o.getOusercar());
		stat.setString(5, o.getOgrade());
		stat.setString(6, o.getOuname());
		stat.setString(7, o.getOmoble());
		Date otime=new Date(o.getOtime().getTime());
		stat.setDate(8,otime);
		stat.setString(9, o.getOfid());
		stat.setInt(10,o.getOpiao());
		stat.setString(11,o.getOzt());
		jg = stat.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jg;
	}

	//根据姓名，身份证号，票号查询订单
	public static oreds select(String sjh){
		oreds o=new oreds();
		Connection conn = BaseDao.Getconn();
		String sql="SELECT oid,onumber,ousername,oname,ousercar,ograde,ouname,omoble,otime,fname,ochupiao,ozt FROM oreds inner JOIN flight ON oreds.ofid = flight.fid where ochupiao=?";
		PreparedStatement stat =null;
		ResultSet rs=null;
		try {
		stat = conn.prepareStatement(sql);
		stat.setString(1,sjh);
		
		rs = stat.executeQuery();
		
		while (rs.next()) {
			
			o.setOid(rs.getInt(1));
			o.setOnumber(rs.getString(2));
			o.setOusername(rs.getString(3));
			StringBuffer sbb=new StringBuffer(rs.getString(4));
			sbb.replace(1,2,"*");				
			o.setOname(sbb.toString());
			StringBuffer sb=new StringBuffer(rs.getString(5));
			sb.replace(6,14,"********");
			o.setOusercar(sb.toString());
			o.setOgrade(rs.getString(6));
			o.setOuname(rs.getString(7));
			StringBuffer sbbb=new StringBuffer(rs.getString(8));
			sbbb.replace(3,7,"****");
			o.setOmoble(sbbb.toString());
			o.setOtime(rs.getDate(9));
			o.setOfid(rs.getString(10));
			o.setOpiao(rs.getInt(11));
			String s=new String(rs.getString(12));
			
			if(s.equals("1")){
				o.setOzt("已出票");	
					}
				if(s.equals("2")){
					o.setOzt("未出票");
				}
				if(s.equals("3")){
					o.setOzt("退票中");
				}
				if(s.equals("4")){
					o.setOzt("订单取消");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, rs);
		}
		
		
		
		return o;
	}

	//查询全部订单
	public static List<oreds> selectAll(){
		List<oreds> list=new ArrayList<oreds>();
		Connection conn = BaseDao.Getconn();
		String sql="SELECT oid,onumber,ousername,oname,ousercar,ograde,ouname,omoble,otime,fname,ochupiao,ozt FROM oreds inner JOIN flight ON oreds.ofid = flight.fid;";
		ResultSet rs=null;
		Statement stat =null;
		try {
			stat= conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				oreds o=new oreds();
				o.setOid(rs.getInt(1));
				o.setOnumber(rs.getString(2));
				o.setOusername(rs.getString(3));			
				o.setOname(rs.getString(4));
				o.setOusercar(rs.getString(5));
				o.setOgrade(rs.getString(6));
				o.setOuname(rs.getString(7));
				o.setOmoble(rs.getString(8));
				o.setOtime(rs.getDate(9));
				o.setOfid(rs.getString(10));
				o.setOpiao(rs.getInt(11));
				o.setOzt(rs.getString(12));
				
				list.add(o);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	//购票成功后票数-1
	public static int updatepiao(int level,int fid){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql = "";
		if(level==1){
			sql = "update flight set ff = ff-1 where fid=?";
		}else if(level==2){
			sql = "update flight set fb = fb-1 where fid=?";
		}else{
			sql = "update flight set fe = fe-1 where fid=?";
		}
		PreparedStatement stat=null;
		try {
			stat = conn.prepareStatement(sql);			
			stat.setInt(1,fid);
			jg = stat.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, null);
		}
		
		return jg;
	}

	//查询用户订单
	public static List<oreds> selectUser(String username){
		List<oreds> list=new ArrayList<oreds>();
		Connection conn = BaseDao.Getconn();
		String sql="SELECT oid,onumber,ousername,oname,ousercar,ograde,ouname,omoble,otime,fname,ochupiao,ozt FROM oreds inner JOIN flight ON oreds.ofid = flight.fid where ousername=?;";
		ResultSet rs=null;
		PreparedStatement stat=null;
		try {
			
			stat = conn.prepareStatement(sql);
			stat.setString(1,username);
			rs = stat.executeQuery();
			
			while (rs.next()) {
				oreds o=new oreds();
				o.setOid(rs.getInt(1));
				o.setOnumber(rs.getString(2));
				o.setOusername(rs.getString(3));			
				o.setOname(rs.getString(4));
				o.setOusercar(rs.getString(5));
				o.setOgrade(rs.getString(6));
				o.setOuname(rs.getString(7));
				o.setOmoble(rs.getString(8));
				o.setOtime(rs.getDate(9));
				o.setOfid(rs.getString(10));
				o.setOpiao(rs.getInt(11));
				String s=new String(rs.getString(12));;
				if(s.equals("1")){
					o.setOzt("已出票");	
						}
					if(s.equals("2")){
						o.setOzt("未出票");
					}
					if(s.equals("3")){
						o.setOzt("退票中");
					}
					if(s.equals("4")){
						o.setOzt("订单取消");
					}
				
				list.add(o);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	//修改订单(退款)
	public static int DoUserTK(int fid){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="update oreds set ozt=3 where oid=?";
		PreparedStatement stat =null;
		try {
			stat= conn.prepareStatement(sql);
			stat.setInt(1,fid);
			jg = stat.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, null);
		}
		
		return jg;
	}

	//用户订单删除
	public static int delect(int id){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="delete from oreds where oid=?";
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

	//用户信息查询验证
	public static int UserSelectXQ(int id,String car){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="select count(*) from oreds where oid=? and ousercar=?";
		CallableStatement stat=null;
		ResultSet rs =null;
		try {
			stat = conn.prepareCall(sql);
			stat.setInt(1,id);
			stat.setString(2,car);
			
			rs = stat.executeQuery();
			
			while (rs.next()) {
				jg = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, null);
		}
		
		
		return jg;
	}

}
