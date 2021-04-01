package Api;

import Servlet.RequestAnswer;
import Servlet.RequestData;
import Servlet.RequestHandler;
import com.google.gson.Gson;

public abstract class ApiMethod implements RequestHandler
{

	@Override
	public String GetPath() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestAnswer Process(RequestData rd)
	{
		Gson gson = new Gson();
		Object ans = GetAnswer(rd);
		String json = gson.toJson(ans);
		
		RequestAnswer ra = new RequestAnswer(json);
		return ra;
	}
	
	protected abstract Object GetAnswer(RequestData rd);

	protected enum MetaStatus
	{
		OK,
		ERROR
	}	
	
	protected class MetaAnswer
	{
		/* документация из мифического сваггера */
		
		// ['OK' or 'ERROR']: Результат операции
		public MetaStatus status;
		// code (integer): Код ошибки 
		public int code = 0;
		// message (string, optional): Дополнительное сообщение
		public String message = "";		
	}
	
	
}
