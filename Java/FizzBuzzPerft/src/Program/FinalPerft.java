package Program;

import java.io.OutputStream;
import java.io.PrintStream;

public final class FinalPerft extends Perft
{
	private byte[] bufInt = new byte[5];
	
	public FinalPerft()
	{
		bufInt[4] = 13;
	}
	
	@Override
	protected final void FizBuzz(int start, int end) 
	{		
		PrintStream originalOutput = System.out;
		System.setOut(new PrintStream(OutputStream.nullOutputStream()));
						
		end++;
    	for(int i=start; i < end; i++)
    	{
    		if (i % 3 == 0)
    		{
                if (i % 5 == 0) 
                	WriteLine ("FizzBuzz\n");
                else 
                	WriteLine ("Fizz\n");
    		}
    		else
    		{
                if (i % 5 == 0) 
                	WriteLine ("Buzz\n");
                else 
                	WriteLine (i);
    		}			
    	}
    	
    	System.out.flush();    	
    	System.setOut(originalOutput);		
	}

	@Override
	protected void WriteLine(String value)
	{		
		System.out.writeBytes(value.getBytes());
	}
	
	@Override
	protected void WriteLine(int value)
	{		
		bufInt[0] = (byte) (value >> 24);
		bufInt[1] = (byte) (value >> 16);
		bufInt[2] = (byte) (value >> 8);
		bufInt[3] = (byte) (value);		

		System.out.writeBytes(bufInt);
	}	

	
}


