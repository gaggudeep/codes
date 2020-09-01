import java.util.*;

class CompressedString {

	static String compressString(String s) {

		//If compressed string is lengthier than return orignal string.
		int finalLength = countCompressedLength(s);
		if(finalLength >= s.length()) {
			return s;
		}

		StringBuilder compressedString = new StringBuilder(finalLength);

		int countConsecutive = 0;

		for(int i = 0 ; i < s.length() ; i++) {

			countConsecutive++;

			if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compressedString.append(s.charAt(i));
				compressedString.append(countConsecutive);
				countConsecutive = 0;
			}
		}

		return compressedString.toString();

	}

	static int countCompressedLength(String s) {

		int countConsecutive = 0, compressedLength = 0;

		for(int i = 0 ; i < s.length() ; i++) {

			countConsecutive++;

			//If next character is different or is last character
			if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {

				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}

		return compressedLength;
	}

	public static void main(String args[]) {

		String s = "aabbccddd";
		System.out.println(compressString(s));
	}
}