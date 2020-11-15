package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DiscountDAO{
	Database db =new Database();
	
	
	public void getData() {
		try {
		Connection conn = db.getConnection();
		Statement sta = conn.createStatement();
		String Sql = "select * from tblCountry";
		ResultSet rs;
		
			rs = sta.executeQuery(Sql);
		
		while (rs.next()) {
			System.out.println(rs.getString("CountryName"));
		}
		} catch (SQLException | ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}


	public Map getDiscountConfiguredValues(String userName,String mobileNo) throws SQLException {
		Map configValues = new HashMap();
		ResultSet rs =null;
		Connection conn = null;		
		PreparedStatement sta =null;
		Statement st =null;
		ResultSet rs1 =null;
		try {
			 conn = db.getConnection();
			
			String sql = "select u.usercategory userCat, u.registerDate regDate, pd.DiscountPercent dp from userMaster u inner join PercentageDiscount pd on \r\n" + 
					"u.userCategory=pd.userCategory and u.userName=? and u.mobileNo=?";
			 sta = conn.prepareStatement(sql);
			sta.setString(1,userName);
			sta.setString(2,mobileNo);			
			rs = sta.executeQuery();
			
			while (rs.next()) {
				configValues.put("percentDiscount", rs.getString("dp"));		
				configValues.put("userCategory",rs.getString("userCat"));
				configValues.put("registeredDate", rs.getString("regDate"));			
				
			}
			String sql1 ="select cutOffAmt,discount from priceDiscount";
			st = conn.createStatement();
			rs1= st.executeQuery(sql1);
			
			while (rs1.next()) {
				configValues.put("cutOffAmt", rs1.getString("cutOffAmt"));		
				configValues.put("priceDiscount",rs1.getString("discount"));
				
			}
			
			} catch (SQLException | ClassNotFoundException e) {			
				e.printStackTrace();
			}finally {
				
				if(rs!=null && rs.isClosed()==false) {
					rs.close();
				}if(rs1!=null && rs1.isClosed()==false) {
					rs1.close();
				}if(sta!=null && sta.isClosed()==false) {
					sta.close();
				}if(conn!=null && conn.isClosed()==false) {
					conn.close();
				}
			}
		return configValues;
	}

}
