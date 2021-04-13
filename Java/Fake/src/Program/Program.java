package Program;

// core
import java.io.IOException;

import Api.Serializator.SerializeType;
import Implementation.ApiMethodPricePlan;
// tcp-io
import Servlet.RequestAnswer;
import Servlet.RequestHandler;
import Servlet.WebServer;

public class Program 
{
	 
    public static void main(String Args[]) throws Exception 
    {
    	WebServer ws = new WebServer(8080);
    	
    	SerializeType serialize = SerializeType.Json;
    	
    	ws.AddRoute(new ApiMethodPricePlan(serialize));
    }
}
