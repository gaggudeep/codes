import java.util.*;

class OneMoveAway {

	static boolean isOneMoveAway(String str1, String str2) {

		//If string lengths differ by more than 1 return false.
		if(Math.abs(str1.length() - str2.length()) > 1) {
			return false;
		}

		//Setting shorter string as s1 and longer as s2.
		String s1 = str1.length() < str2.length() ? str1 : str2;
		String s2 = str1.length() < str2.length() ? str2 : str1;

		int index1 = 0, index2 = 0;
		boolean foundDifference = false;

		while(index1 < s1.length() && index2 < s2.length()) {

			if(s1.charAt(index1) != s2.charAt(index2)) {

				//Ensure that only one difference is found, if not then return false;
				if(foundDifference) return false;
				foundDifference = true;

				if(s1.length() == s2.length()) {

					index1++;
				}
			}

			else {
				index1++;
			}

			index2++;
		}

		return true;
	}

	public static void main(String args[]) {

		String s1 = "kale", s2 = "ale";
		System.out.println(isOneMoveAway(s1, s2));
	}
}