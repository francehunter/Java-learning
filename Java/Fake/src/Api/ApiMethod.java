package Api;

import Servlet.RequestAnswer;
import Servlet.RequestData;
import Servlet.RequestHandler;
import com.google.gson.Gson;

import Api.Serializator.SerializeType;

public abstract class ApiMethod implements RequestHandler
{
	
	private Serializator serializator = null;
	
	public ApiMethod(SerializeType serializeType)
	{
		serializator = new Serializator(serializeType);
	}
	
	@Override
	public String GetPath() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestAnswer Process(RequestData rd)
	{
		Object ans = GetAnswer(rd);
		String text = serializator.ToString(ans);		
		RequestAnswer ra = new RequestAnswer(text);
		return ra;
	}
	
	protected abstract Object GetAnswer(RequestData rd);	
}
