package Implementation;

public class MetaAnswer
{
	
	public enum MetaStatus
	{
		OK,
		ERROR
	}		
	
	/* документация из мифического сваггера */
	
	// ['OK' or 'ERROR']: Результат операции
	public MetaStatus status;
	// code (integer): Код ошибки 
	public int code = 0;
	// message (string, optional): Дополнительное сообщение
	public String message = "";		
}