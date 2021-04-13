import java.util.*;

class PalindromicPermutation {

	static boolean isPermutationOfPalindrome(String s) {

		int bitVector = createBitVector(s);

		//If the bit vector contains only one set bit, i.e only one odd occurring character, then the following expression equates to 0.
		return 0 == (bitVector & (bitVector - 1));
	}
	
	//Creating bit vector that stores if the character at a particular index has even (0) or odd count (1).
	static int createBitVector(String s) {

		int bitVec = 0;
		for(int i = 0 ; i < s.length() ; i++) {

			int charIndex = (int)s.charAt(i) - 'a' + 1;
			bitVec = toggle(bitVec, charIndex);
		}

		return bitVec;
	}

	//Toggling bit at index.
	static int toggle(int bitVec, int index) {

		if(index < 0) return bitVec;

		int mask = 1 << index;

		return bitVec ^ mask;
	}

	public static void main(String args[]) {

		String s = "Abacabc";
		System.out.println(isPermutationOfPalindrome(s.toLowerCase()));
	}
}