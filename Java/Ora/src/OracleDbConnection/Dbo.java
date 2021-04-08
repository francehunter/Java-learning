package OracleDbConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Dbo 
{
	private static Map<String, Dbo> instances = new HashMap<String, Dbo>();
	
	private Connection conn = null;
		
	public static Dbo GetInstance(User user) throws ClassNotFoundException, SQLException
	{
		String hash = user.toString();
		Dbo instance = null;
		if (!instances.containsKey(hash))
		{
			instance = new Dbo(user);
			instances.put(hash, instance);
		}
		else
			instance = instances.get(hash);
			
			
		return instance;
	}
	
	public Dbo(User user) throws ClassNotFoundException, SQLException
	{
  	  Class.forName("oracle.jdbc.driver.OracleDriver");
  	  //conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.20.18:15288:xe", "div","1708");
  	  conn = DriverManager.getConnection("jdbc:oracle:thin:@"+user.host+":"+user.port+":"+user.SID, user.login, user.pass);  	  		
	}
	
	public void Close() throws SQLException
	{
		conn.close();
	}
	
	public void Execute(String sql) throws SQLException
	{
  	  Statement stmt = conn.createStatement();    	     	 	  
  	  ResultSet rset = stmt.executeQuery(sql);
  	  
	  rset.close();
	  stmt.close();   	  
	}
	
	public ResultSet Query(String sql) throws SQLException
	{
  	  Statement stmt = conn.createStatement();    	     	 	  
  	  ResultSet rset = stmt.executeQuery(sql);
  	  	  
	  return rset;
	}	
	
}
