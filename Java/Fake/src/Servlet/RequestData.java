package Servlet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

public class RequestData
{
	public Map<String, String> params = new HashMap<String, String>();
	
	public RequestData(HttpExchange ex) throws IOException
    {		
		String query = ex.getRequestURI().getQuery();
		String[] arrPair = query.split("&");
		for (String pair : arrPair)
		{
			String[] equals = pair.split("=");
			if (equals.length == 2)
				params.put(equals[0], equals[1]);
		}		
    }	
	
}