package Servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class WebServer 
{
	private HttpServer ws = null;
	private Router router = new Router();

	public WebServer(int port) throws IOException
    {		
        ws = HttpServer.create(new InetSocketAddress(port), 0);
        ws.createContext("/", new CommonRequestHandler(router));
        ws.setExecutor(null);
        ws.start();
        
        System.out.println("Listen TCP " + port + " port..");        //
        System.out.println("Open browser and enter string like http://localhost:8080/pricePlan?method=get&ctn=9083161123 for test");
    }
	
	@Override
	public void finalize() 
	{
		System.out.println("WebServer finalize");
		ws.stop(0);
	}	
		
	public void AddRoute(String path, RequestHandler handler) throws Exception
	{
		router.Add(path, handler);
	}
	
	public void AddRoute(RequestHandler handler) throws Exception
	{
		router.Add(handler.GetPath(), handler);
	}	
	
}
