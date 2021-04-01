package Servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

class CommonRequestHandler implements HttpHandler 
{
	private Router router;
	
	public CommonRequestHandler(Router router)
	{
		this.router = router;
	}
	
    @Override
    public void handle(HttpExchange ex) throws IOException 
    {
    	System.out.println("uri path="+ex.getRequestURI().getPath());
    	
    	RequestAnswer ra = new RequestAnswer();
    	String path = ex.getRequestURI().getPath();
    	
    	if (!router.Exists(path))
    	{
    		ra.code = 404;
    		ra.response = "Not found";
    	}
    	else
    	{
    		RequestHandler rh = router.Get(path);
    		RequestData rd = new RequestData(ex); 
    		ra = rh.Process(rd);
    	}
    	
    
        ex.sendResponseHeaders(ra.code, ra.response.length());
        OutputStream os = ex.getResponseBody();
        os.write(ra.response.getBytes());
        os.close();
    }
}

public interface RequestHandler
{    
    public RequestAnswer Process(RequestData rd);
    public String GetPath();
}


