package net.slipp.user;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class UserDAO {
	
	public Connection getConnection(){
		String url = "jdbc:mysql://localhost:3306/yskoh_dev";
		String id = "yskoh";
		String pw ="1234";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, id, pw);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void addUser(User user) throws SQLException{
		String sql ="insert into USERS values (?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getUserId());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getName());
			pstmt.setString(4,user.getEmail());
			
			pstmt.executeUpdate();			
		} finally{
			if(pstmt != null){
				pstmt.close();
			}
			if(conn !=null){
				conn.close();
			}
		}
	}

	public User findUserById(String userId) throws SQLException{
		String sql ="select * from users where userId = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(!rs.next()){
				return null;
			}
			else{
				return new User(
						rs.getString("userId"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email"));
			}
		} finally {
			if(rs !=null){
				rs.close();
			}
			if(pstmt !=null){
				pstmt.close();
			}
			if(conn !=null){
				conn.close();
			}
		}
	}
	
}
