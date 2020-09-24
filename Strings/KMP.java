import java.util.*;

class KMP
{
	static void kmp(String t, String p)
	{
		int lps[] = new int[p.length()];
		computeLPS(lps, p);
		int i = 0, j = 0;
		while(i < t.length())
		{
			if(t.charAt(i) == p.charAt(j))
			{
				i++;
				j++;
			}
			if(j == p.length())
				System.out.println("Pattern found at index " + (i - j));
			else if(i < t.length() && t.charAt(i) != p.charAt(j))
			{
				if(j != 0)
					j = lps[j - 1];
				else
				{
					j = 0;
					i++;
				}

			}
		}
	}

	static void computeLPS(int[] lps, String p)
	{
		int i = 1, len = 0;
		lps[0] = 0;
		while(i < p.length())
		{
			if (p.charAt(i) == p.charAt(len)) 
				lps[i++] = ++len;
			else
			{
				if(len != 0)
					len = lps[len - 1];
				else
					lps[i++] = 0;
			}
		}
	}

	public static void main(String args[])
	{
		String text = "ABABDABACDABABCABAB"; 
        String pat = "ABABCABAB";
        kmp(text, pat);
	}
}