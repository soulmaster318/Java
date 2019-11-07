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
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:microsoft:sqlserver://HIEPNGUYEN:1433;instance=SQL;databasename=JDBCTest","sa","3108");
		}
		catch(Exception e) {
			System.out.print(e);}
		return conn;
	}
	public static int AddUser(UserInfo u) {
		int status=0;
		try {
			Connection conn= DbConnection.getConnection();
			PreparedStatement pre=conn.prepareStatement("insert into UserInfo(FirstName,LastName,Country,PhoneNo) values (?,?,?,?)");
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
}
