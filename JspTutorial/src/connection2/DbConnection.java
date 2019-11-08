package connection2;

import tables.UserInfo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletTest","root","3108");
		}
		catch(Exception e) {
			System.out.print(e);}
		return conn;
	}
	public static int AddUser(UserInfo u) {
		int status=0;
		try {
			Connection conn= DbConnection.getConnection();
			PreparedStatement pre=conn.prepareStatement("insert into UserInfo(firstname,lastname,country,phoneno) values (?,?,?,?)");
			pre.setString(1,u.getFirstname());
			pre.setString(2,u.getLastname());
			pre.setString(3,u.getCountry());
			pre.setString(4,u.getPhoneno());
			
			status=pre.executeUpdate();
			
			conn.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static int UpdateUser(UserInfo u) {
		int status=0;
		try {
			Connection conn= DbConnection.getConnection();
			PreparedStatement pre=conn.prepareStatement("update UserInfo set firstname=?,lastname=?,country=?,phoneno=? where id=?");
			pre.setString(1,u.getFirstname());
			pre.setString(2,u.getLastname());
			pre.setString(3,u.getCountry());
			pre.setString(4,u.getPhoneno());
			pre.setInt(5,u.getId());
			
			status=pre.executeUpdate();
			
			conn.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static int DeleteUser(int id) {
		int status=0;
		try {
			Connection conn= DbConnection.getConnection();
			PreparedStatement pre=conn.prepareStatement("delete from UserInfo where id=?");
			pre.setInt(1,id);
			status = pre.executeUpdate();
			
			conn.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static UserInfo SelectUserByID(int id) {
		UserInfo u =new UserInfo();
		try {
			Connection conn= DbConnection.getConnection();
			PreparedStatement pre=conn.prepareStatement("select * from UserInfo where id=?");
			pre.setInt(1,id);
			ResultSet rs=pre.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt(1));
				u.setFirstname(rs.getString(2));
				u.setLastname(rs.getString(3));
				u.setCountry(rs.getString(4));
				u.setPhoneno(rs.getString(5));
			}
			conn.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return u;
	}
	public static List<UserInfo> getAllUsers(){
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			Connection conn= DbConnection.getConnection();
			PreparedStatement pre=conn.prepareStatement("select * from UserInfo");
			ResultSet rs=pre.executeQuery();
			while(rs.next()) {
				UserInfo u =new UserInfo();
				u.setId(rs.getInt(1));
				u.setFirstname(rs.getString(2));
				u.setLastname(rs.getString(3));
				u.setCountry(rs.getString(4));
				u.setPhoneno(rs.getString(5));
				list.add(u);
			}
			conn.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
}
