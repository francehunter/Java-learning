package OracleDbConnection;

public class User 
{
	public String host = "";
	public int port = 1521;
	public String login = "";
	public String pass = "";
	public String SID = "";
	
	public User(String host, int port, String login, String pass, String SID)
	{
		this.host = host;
		this.port = port;
		this.login = login;
		this.pass = pass;
		this.SID = SID;
	}
	
    @Override
    public String toString()    
    {
    	return host + "," + port + "," + login + "," + pass + "," + SID;
    }	
}
