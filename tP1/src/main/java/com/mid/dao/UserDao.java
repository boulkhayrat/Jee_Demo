package com.mid.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mid.model.User;


public class UserDao implements InterfaceUserDao {
	
	public User selectUser(String email) {
		User u = null;
		Connection con = MysqlConnection.getConnection();	
		PreparedStatement ps ;
		try {
			u = new User();
			ps = con.prepareStatement("select * from utilisateur where email like ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			u.setRole(rs.getString("role"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return u;
		
	}

	@Override
	public String selectRole(String email) {
		
		Connection con = MysqlConnection.getConnection();
		PreparedStatement ps;
		String role = null;
		try {
			 ps= con.prepareStatement("select role from utilisateur where email like ?;");
			 ps.setString(1, email);
			 ResultSet rs = ps .executeQuery();
			 rs.next();
			 role = rs.getString("role");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	
	

}
