import java.util.*;

class nextGreaterNobWith11 
{
	static int nextGrt(int n)
	{
		for(int i = n + 1 ; ; i++)
		{
			int prev = 0, cur = i;
			while(cur > 0)
			{
				if(cur % 2 == 1 && prev == 1)
				{
					break;
				}
				prev = cur % 2;
				cur /= 2;
			}
			if(cur <= 0)
				return i;
		}
	}

	public static void main(String args[])
	{
		System.out.println(nextGrt(5));
	}
}