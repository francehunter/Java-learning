package Program;

import java.util.Scanner;

public abstract class Perft 
{
	public void Execute(int start, int end)
	{
	   System.out.println("Press \"ENTER\" to test " + this.getClass() + "...");
	   Scanner scanner = new Scanner(System.in);
	   scanner.nextLine();		
		
		long startTime = System.nanoTime();
		
		this.FizBuzz(start, end);
		
		long endTime = System.nanoTime();
		long delta = endTime - startTime;
		System.out.println("Perft completed from " + start + " to " + end + " samplers:" +  delta + " nano sec (" +  String.format("%1.2f", delta/1000000000.0) + " сек)");
	}
	
	protected void WriteLine(String value)
	{		
		System.out.println(value);
	}
	
	protected void WriteLine(int value)
	{
		System.out.println(value);
	}	
	
	protected abstract void FizBuzz(int start, int end);
}
