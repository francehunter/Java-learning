package Program;

public class Program 
{
	private static int start = 1; 
	private static int end = 10000000;
	
    public static void main(String Args[]) 
    {
    	new SimplePerft().Execute(start, end);
    	new DevNullOutputPerft().Execute(start, end);
    	new FinalPerft().Execute(start, end);
    }
}