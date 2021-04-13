package Api;

import com.google.gson.Gson;

public class Serializator 
{
	private SerializeMethod method = null;
	
	public enum SerializeType
	{
		Json,
		Xml,
		Soap
	}
	
	interface SerializeMethod
	{
	    String ToString(Object obj);
	}	
	
	public Serializator(SerializeType type)
	{
		switch (type)
		{
			case Json:
				method = (Object obj)->
				{
					Gson gson = new Gson();
					return gson.toJson(obj);				
				};
				break;
			case Xml:
				throw new UnsupportedOperationException("Xml serializator is not implemented");
			case Soap:
				throw new UnsupportedOperationException("Soap serializator is not implemented");
			default:
				throw new UnsupportedOperationException("Unknown serializator type " + type);
		}
	}
	
	public String ToString(Object obj)
	{
		return method.ToString(obj);
	}

}
