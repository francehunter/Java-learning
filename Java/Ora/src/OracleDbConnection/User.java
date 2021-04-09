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
	
	public static User CreateDefault()
	{
		return new User("192.168.20.18", 15288, "div","1708", "xe");
	}
	
    @Override
    public String toString()    
    {
    	return host + "," + port + "," + login + "," + pass + "," + SID;
    }	
}
