package Program;

import java.sql.SQLException;

import OracleDbConnection.Dbo;
import OracleDbConnection.User;

public class Program 
{
	 
    public static void main(String Args[]) throws Exception 
    {
    	//Program.Test();
    	var dls = new DeadlockSandbox();
    	dls.Lock();
    }
    
    public static void Test() throws SQLException, ClassNotFoundException
    {
    	var user = User.CreateDefault();
    	var dbo = Dbo.GetInstance(user);
    	
    	var rs = dbo.Query("SELECT * FROM DIV.TABLE1");    	
    	while (rs.next())
    	{		  
		  int id = rs.getInt("id");
		  String name = rs.getString("name");
	  
		  System.out.println ("id="+id+" name="+name+"\n");
    	}    	
	  	rs.close();        	
    }    

}