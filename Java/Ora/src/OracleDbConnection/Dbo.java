package OracleDbConnection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Dbo 
{
	private static Map<String, Dbo> instances = new HashMap<String, Dbo>();
	
	private Connection conn = null;
	private boolean transactionStarted = false;
		
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
	
	public void Update(String sql) throws SQLException
	{
		Statement stmt = conn.createStatement();    	     	 	  
		stmt.executeUpdate(sql);		

		stmt.close(); 	  	  	  	 		
	}
	
	
	public boolean BeginTransaction() throws SQLException
	{
		if (transactionStarted)
			return false;
		
		conn.setAutoCommit(false);
		transactionStarted = true;
		return transactionStarted;
	}
	
	public boolean CommitTransaction() throws SQLException
	{
		if (!transactionStarted)
			return false;
		
		conn.commit();
		transactionStarted = false;
		return transactionStarted;		
	}	
	
	public boolean RollbackTransaction() throws SQLException
	{
		if (!transactionStarted)
			return false;
		
		conn.rollback();
		transactionStarted = false;
		return transactionStarted;			
	}	
	
	public Integer GetSessionId() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
        Method method = conn.getClass().getDeclaredMethod("getSessionId", null);
        method.setAccessible(true);
        var sid = (Integer)method.invoke(conn, null);                    
        method.setAccessible(false);
        return sid;
	}
	
}
