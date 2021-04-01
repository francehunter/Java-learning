package Program;

// core
import java.io.IOException;

// tcp-io
import Servlet.RequestAnswer;
import Servlet.RequestHandler;
import Servlet.WebServer;

// Api implementation
import Api.ApiMethodPricePlan;

public class Program 
{
	 
    public static void main(String Args[]) throws Exception 
    {
    	WebServer ws = new WebServer(8080);
    	ws.AddRoute(new ApiMethodPricePlan());
    }
}
