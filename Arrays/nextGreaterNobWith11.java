import java.util.*;

class nextGreaterNobWith11 
{
	static int nextGrt(int n)
	{
		int ans = n + 1;
		for(int i = ans ; ; i++)
		{
			int prev = 0;
			while(n != 0)
			{
				if(i % 2 == 1 && prev == 1)
				{
					prev = i % 2;
					i /= 2;
				}
				return i;
			}
		}
	}

	public static void main(String args[])
	{
		System.out.println(nextGrt(4));
	}
}