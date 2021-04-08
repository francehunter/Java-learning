package Program;

public final class SimplePerft extends Perft
{

	@Override
	protected final void FizBuzz(int start, int end) 
	{
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
		
	}

}
