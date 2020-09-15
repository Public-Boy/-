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

import com.weiwei.Entity.UsersTable;
import com.weiwei.Entity.flight;

public class UsersTableDao {
	
	//添加
	public static int Add(UsersTable U){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="insert into UsersTable values(null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stat =null;
		try {
			stat= conn.prepareStatement(sql);
			stat.setString(1,U.getUserName());
			stat.setString(2,U.getUserNumber());
			stat.setString(3,U.getUserPwd());
			stat.setString(4,U.getUserYesPwd());
			stat.setString(5,U.getUserTypeId());
			stat.setString(6,U.getUserTypeNumber());
			stat.setString(7,U.getUserMobile());
			stat.setString(8,U.getUserEmail());
			stat.setString(9,U.getUimg());
			jg = stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, null);
		}
		return jg;
	}
	

	//登入
 public static int Login(String UserNumber,String pwd){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="select count(*) from UsersTable where UserNumber=? and UserPwd=?";
		CallableStatement stat =null;
		ResultSet rs =null;
		try {
			stat= conn.prepareCall(sql);
			stat.setString(1,UserNumber);
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
	

	//机票查询
	public static List<flight> selectflight(String a,String b){
		List<flight> list=new ArrayList<flight>();
		Connection conn = BaseDao.Getconn();
		String sql="select * from flight where fchufa=? and fdaoda=?";
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat= conn.prepareStatement(sql);
			stat.setString(1,a);
			stat.setString(2,b);
			rs = stat.executeQuery();
			
			while (rs.next()) {
				flight f=new flight();
				f.setFid(rs.getInt(1));
				f.setFname(rs.getString(2));
				f.setFchufa(rs.getString(3));
				f.setFdaoda(rs.getString(4));
				f.setFchufajichang(rs.getString(5));
				f.setFdaodajichang(rs.getString(6));
				f.setFtime(rs.getDate(7));
				f.setFchutime(rs.getString(8));
				f.setFdaotime(rs.getString(9));
				f.setFf(rs.getString(10));
				f.setFb(rs.getString(11));
				f.setFe(rs.getString(12));
				f.setFfp(rs.getString(13));
				f.setFbp(rs.getString(14));
				f.setFep(rs.getString(15));
				
				list.add(f);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, rs);
		}
		
		
		return list;
	}


	//购票ID
	public static flight tickteid(int id){
		flight f=new flight();
		Connection conn = BaseDao.Getconn();
		String sql="select * from flight where fid=?";
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat= conn.prepareStatement(sql);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			while(rs.next()) {
				f.setFid(rs.getInt(1));
				f.setFname(rs.getString(2));
				f.setFchufa(rs.getString(3));
				f.setFdaoda(rs.getString(4));
				f.setFchufajichang(rs.getString(5));
				f.setFdaodajichang(rs.getString(6));
				f.setFtime(rs.getDate(7));
				f.setFchutime(rs.getString(8));
				f.setFdaotime(rs.getString(9));
				f.setFf(rs.getString(10));
				f.setFb(rs.getString(11));
				f.setFe(rs.getString(12));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, rs);
		}
		
		
		
		
		
		return f;
	}


	//用户查询
	public static List<UsersTable> selectuser(){
		List<UsersTable> list=new ArrayList<UsersTable>();
		Connection conn = BaseDao.Getconn();
		String sql="select * from userstable";
		Statement stat =null;
		ResultSet rs=null;
		try {
			stat= conn.createStatement();
			
			 rs = stat.executeQuery(sql);
			 
			 while (rs.next()) {
				UsersTable u=new UsersTable();
				 u.setUid(rs.getInt(1));
				 u.setUserName(rs.getString(2));
				 u.setUserNumber(rs.getString(3));
				 u.setUserPwd(rs.getString(4));
				 u.setUserYesPwd(rs.getString(5));
				 u.setUserTypeId(rs.getString(6));
				 u.setUserTypeNumber(rs.getString(7));
				 u.setUserMobile(rs.getString(8));
				 u.setUserEmail(rs.getString(9));
				 u.setUimg(rs.getString(10));
				 
				 list.add(u);
			}
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, rs);
		}
		
		return list;
	}


	//删除用户
	public static int DoDelete(int id){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="delete from userstable where Uid=?";
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


	//后台查询
	public static List<flight> Adminselectflight(){
		List<flight> list=new ArrayList<flight>();
		Connection conn = BaseDao.Getconn();
		String sql="select * from flight";
		Statement stat=null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				flight f=new flight();
				f.setFid(rs.getInt(1));
				f.setFname(rs.getString(2));
				f.setFchufa(rs.getString(3));
				f.setFdaoda(rs.getString(4));
				f.setFchufajichang(rs.getString(5));
				f.setFdaodajichang(rs.getString(6));
				f.setFtime(rs.getDate(7));
				f.setFchutime(rs.getString(8));
				f.setFdaotime(rs.getString(9));
				f.setFf(rs.getString(10));
				f.setFb(rs.getString(11));
				f.setFe(rs.getString(12));
				f.setFfp(rs.getString(13));
				f.setFbp(rs.getString(14));
				f.setFep(rs.getString(15));
				
				list.add(f);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, rs);
		}
		
		
		return list;
	}

	//后台机票添加
	public static int AdminflightAdd(flight f){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="insert into flight values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stat=null;
		try {
			stat = conn.prepareStatement(sql);
	
			stat.setString(1,f.getFname());			
			stat.setString(2,f.getFchufa());
			stat.setString(3,f.getFdaoda());
			stat.setString(4,f.getFchufajichang());
			stat.setString(5,f.getFdaodajichang());
			Date otime=new Date(f.getFtime().getTime());
			stat.setDate(6,otime);
			stat.setString(7,f.getFchutime());
			stat.setString(8,f.getFdaotime());
			stat.setString(9,f.getFfp());
			stat.setString(10,f.getFep());
			stat.setString(11,f.getFbp());
			stat.setString(12,f.getFf());
			stat.setString(13,f.getFb());
			stat.setString(14,f.getFe());
		
			
			jg = stat.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, null);
		}
		
		return jg;
	}


	//后台根据Fid查询
	public static flight selectfid(int id){
		flight f=new flight();
		Connection conn = BaseDao.Getconn();
		String sql="select * from flight where fid=?";
		PreparedStatement stat=null;
		ResultSet rs =null;
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1,id);
			rs= stat.executeQuery();
			
			while (rs.next()) {
				f.setFid(rs.getInt(1));
				f.setFname(rs.getString(2));
				f.setFchufa(rs.getString(3));
				f.setFdaoda(rs.getString(4));
				f.setFchufajichang(rs.getString(5));
				f.setFdaodajichang(rs.getString(6));
				f.setFtime(rs.getDate(7));
				f.setFchutime(rs.getString(8));
				f.setFdaotime(rs.getString(9));
				f.setFf(rs.getString(10));
				f.setFb(rs.getString(11));
				f.setFe(rs.getString(12));
				f.setFfp(rs.getString(13));
				f.setFbp(rs.getString(14));
				f.setFep(rs.getString(15));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, rs);
		}
		
		return f;
	}


	//后台修改机票
	public static int AdminflightUpdate(flight f){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="update flight set fname=?,fchufa=?,fdaoda=?,fchufajichang=?,fdaodajichang=?,ftime=?,fchutime=?,fdaotime=?,ffprice=?,fbprice=?,feprice=?,ff=?,fb=?,fe=? where fid=?";
		PreparedStatement stat=null;
		
		try {
			stat = conn.prepareStatement(sql);

			stat.setString(1,f.getFname());			
			stat.setString(2,f.getFchufa());
			stat.setString(3,f.getFdaoda());
			stat.setString(4,f.getFchufajichang());
			stat.setString(5,f.getFdaodajichang());
			Date otime=new Date(f.getFtime().getTime());
			stat.setDate(6,otime);
			stat.setString(7,f.getFchutime());
			stat.setString(8,f.getFdaotime());
			stat.setString(9,f.getFf());
			stat.setString(10,f.getFb());
			stat.setString(11,f.getFe());
			stat.setString(12,f.getFfp());
			stat.setString(13,f.getFep());
			stat.setString(14,f.getFbp());
			stat.setInt(15,f.getFid());
			
			jg = stat.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, null);
		}
		
		
		return jg;
		
		
	}
	

	//后台机票删除
	public static int AdminflightDelete(int fid){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="delete from flight where fid=?";
		CallableStatement stat=null;
		try {
			 stat= conn.prepareCall(sql);
			 
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

	
	//修改用户
	public static int DoUserUpdate(String name,String dh,String email){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="update userstable set UserMobile=?,UserEmail=? where UserNumber=?";
		PreparedStatement stat=null;
		try {
			stat = conn.prepareStatement(sql);
			
			stat.setString(1,dh);
			stat.setString(2,email);
			stat.setString(3,name);
			
			jg = stat.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, null);
		}
		
		
		return jg;
	}

	//找回密码
	public static int DoNewPwd(String car,String mobeli,String emali,String NewPwd){
		int jg=0;
		Connection conn = BaseDao.Getconn();
		String sql="update userstable set UserPwd=?,UserYesPwd=? where UserTypeNumber=? and UserMobile=? and UserEmail=?";
		PreparedStatement stat=null;
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1,NewPwd);
			stat.setString(2,NewPwd);
			stat.setString(3,car);
			stat.setString(4,mobeli);
			stat.setString(5,emali);
			
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
