package com.weiwei.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.weiwei.Entity.UserOrdesXQ;

public class UserOrdesXQDao {
	public static UserOrdesXQ SelectAll(int id,String car){
		UserOrdesXQ u=new UserOrdesXQ();
		Connection conn = BaseDao.Getconn();
		ResultSet rs=null;
		PreparedStatement stat =null;
		String sql="SELECT * FROM oreds inner JOIN flight ON oreds.ofid = flight.fid where oid=? and ousercar=?";
		try {
			stat= conn.prepareStatement(sql);
			stat.setInt(1,id);
			stat.setString(2,car);
			rs = stat.executeQuery();
			
			while (rs.next()) {

				u.setOid(rs.getInt(1));
				u.setOnumber(rs.getString(2));
				u.setOusername(rs.getString(3));
				u.setOname(rs.getString(4));
				StringBuffer sb=new StringBuffer(rs.getString(5));
				sb.replace(6,16,"***********");
				u.setOusercar(sb.toString());
				u.setOgrade(rs.getString(6));
				u.setOuname(rs.getString(7));
				u.setOmoble(rs.getString(8));
				u.setOtime(rs.getDate(9));
				u.setOfid(rs.getString(10));
				u.setOpiao(rs.getInt(11));
				String s=new String(rs.getString(12));;
				if(s.equals("1")){
					u.setOzt("已出票");	
						}
					if(s.equals("2")){
						u.setOzt("未出票");
					}
					if(s.equals("3")){
						u.setOzt("退票中");
					}
					if(s.equals("4")){
						u.setOzt("订单取消");
					}
				u.setFid(rs.getInt(13));
				u.setFname(rs.getString(14));
				u.setFchufa(rs.getString(15));
				u.setFdaoda(rs.getString(16));
				u.setFchufajichang(rs.getString(17));
				u.setFdaodajichang(rs.getString(18));
				u.setFtime(rs.getDate(19));
				u.setFchutime(rs.getString(20));
				u.setFdaotime(rs.getString(21));
				u.setFfp(rs.getString(22));
				u.setFbp(rs.getString(23));
				u.setFep(rs.getString(24));
				u.setFf(rs.getString(25));
				u.setFb(rs.getString(26));
				u.setFe(rs.getString(27));
				
		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.CloseAll(conn, stat, rs);
		}

		return u;
	}
}
