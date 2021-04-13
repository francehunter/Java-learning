package Implementation;

public class MetaAnswer
{
	
	public enum MetaStatus
	{
		OK,
		ERROR
	}		
	
	/* ������������ �� ����������� �������� */
	
	// ['OK' or 'ERROR']: ��������� ��������
	public MetaStatus status;
	// code (integer): ��� ������ 
	public int code = 0;
	// message (string, optional): �������������� ���������
	public String message = "";		
}