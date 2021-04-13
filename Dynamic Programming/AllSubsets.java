import java.util.*;

class AllSubsets {

	static void subsets(int[] a)
	{
		for(int i = 0 ; i < (1 << a.length) ; i++)
		{
			System.out.print("[ ");
			for(int j = 0 ; j < a.length ; j++)
			{
				if((i & (1 << j)) > 0)
					System.out.print(a[j] + " ");
			}
			System.out.println(']');
		}
	}

	public static void main(String args[])
	{
		int[] a = {1,2,3,4};
		subsets(a);
	}
}