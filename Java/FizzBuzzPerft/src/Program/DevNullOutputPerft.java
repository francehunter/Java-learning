package Program;

import java.io.OutputStream;
import java.io.PrintStream;

public final class DevNullOutputPerft extends Perft
{

	@Override
	protected final void FizBuzz(int start, int end) 
	{		
		PrintStream originalOutput = System.out;
		System.setOut(new PrintStream(OutputStream.nullOutputStream()));
						
    	for(int i=start; i <= end; i++)
    	{
    		if (i % 3 == 0)
    		{
                if (i % 5 == 0) 
                	WriteLine ("FizzBuzz");
                else 
                	WriteLine ("Fizz");
    		}
    		else
    		{
                if (i % 5 == 0) 
                	WriteLine ("Buzz");
                else 
                	WriteLine (i);
    		}			
    	}
    	
    	System.setOut(originalOutput);		
	}

}


