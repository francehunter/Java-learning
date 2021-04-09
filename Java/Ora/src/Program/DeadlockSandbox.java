package Program;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import OracleDbConnection.Dbo;
import OracleDbConnection.User;

public class DeadlockSandbox 
{
	public void Lock() throws ClassNotFoundException, SQLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		var user = User.CreateDefault();
		
		Dbo dbo1 = new Dbo(user);
		Dbo dbo2 = new Dbo(user);
		
		System.out.println("first conn session id="+dbo1.GetSessionId());
		System.out.println("second conn session id="+dbo2.GetSessionId());
		
		dbo1.BeginTransaction();
		dbo2.BeginTransaction();
		dbo1.Update("UPDATE DIV.TABLE1 t SET t.\"name\" = 'lock1' WHERE t.\"id\" = 3");
		dbo2.Update("UPDATE DIV.TABLE1 t SET t.\"name\" = 'lock2' WHERE t.\"id\" = 3");
	  	dbo1.CommitTransaction();	
	  	dbo2.CommitTransaction();
		
		/*
		 * no lock version
		dbo1.BeginTransaction();
		dbo1.Update("UPDATE DIV.TABLE1 t SET t.\"name\" = 'lock1' WHERE t.\"id\" = 3");
	  	dbo1.CommitTransaction();
	  	
		dbo2.BeginTransaction();
		dbo2.Update("UPDATE DIV.TABLE1 t SET t.\"name\" = 'lock2' WHERE t.\"id\" = 3");
	  	dbo2.CommitTransaction();	  
	  	*/	
	  	
	}
	
}
