package Servlet;

import java.util.HashMap;
import java.util.Map;

public class Router 
{
	private Map<String, RequestHandler> map = new HashMap<String, RequestHandler>();
	
	public void Add(String path, RequestHandler handler) throws Exception
	{
		if (map.containsKey(path))
			throw new Exception("Route still exists");
		
		map.put(path, handler);
	}	
	
	public boolean Exists(String path)
	{
		return map.containsKey(path);
	}
	
	public RequestHandler Get(String path)
	{
		return map.get(path);
	}

	
}
