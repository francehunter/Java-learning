package Implementation;

import Api.ApiMethod;
import Api.Serializator.SerializeType;
import Servlet.RequestData;

/**
 * Реализация гипотетического провайдера, которая исходя из переданного номера телефона возвращает выбранный тарифный план
 */
public class ApiMethodPricePlan extends ApiMethod
{
	public ApiMethodPricePlan(SerializeType serializeType) 
	{
		super(serializeType);
	}

	private final String fieldMethod = "method";
	
	private final int codeNoMethod = 20000;
	private final int codeUnknownMethod = 20001;
	private final int codeNoCtn = 20101;

	
	@Override
	public String GetPath() 
	{
		return "/pricePlan";
	}

	@Override
	protected Object GetAnswer(RequestData rd) 
	{
		PricePlanAnswer ans = new PricePlanAnswer();
		
		ans.meta.status = MetaAnswer.MetaStatus.ERROR;
		
		if (!rd.params.containsKey(fieldMethod))
		{
			ans.meta.code = codeNoMethod;
			return ans;
		}
		
		switch(rd.params.get(fieldMethod))
		{
			case "get":
				ans.name = "Далекие сограждане 5";
				ans.meta.status = MetaAnswer.MetaStatus.OK;				
				break;
			default:
				ans.meta.code = codeUnknownMethod;
				return ans;
		}
				
		return ans;
	}	
	
	protected class PricePlanAnswer
	{
		public MetaAnswer meta = new MetaAnswer();
		public String name = "";		 
	}
	
}
