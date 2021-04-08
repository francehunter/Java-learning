package Program;

import java.sql.SQLException;

import OracleDbConnection.Dbo;
import OracleDbConnection.User;

public class Program 
{
	 
    public static void main(String Args[]) throws Exception 
    {
    	Program.Test();
    }
    
    public static void Test() throws SQLException, ClassNotFoundException
    {
    	var user = new User("192.168.20.18", 15288, "div","1708", "xe");
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