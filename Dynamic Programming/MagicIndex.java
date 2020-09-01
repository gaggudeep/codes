import java.util.*;

class MagicIndex {

	static int findMagicIndex(int array[]) {

		return findMagicIndex(array, 0, array.length - 1);
	}

	static int findMagicIndex(int array[], int startIndex, int endIndex) {

		if(startIndex > endIndex) {
			return Integer.MIN_VALUE;
		}
		int mid = startIndex + (endIndex - startIndex) / 2;

		if(array[mid] == mid)
			return mid;

		int leftIndex = Math.min(array[mid], mid - 1);
		int leftSol = findMagicIndex(array, startIndex, leftIndex);
		
		if(leftSol > Integer.MIN_VALUE) {
			return leftSol;
		}

		int rightIndex = Math.max(array[mid], mid + 1);
		int rightSol = findMagicIndex(array, rightIndex, endIndex);

		return rightSol;
	}

	public static void main(String args[]) {

		int array[] = {1, 2, 3, 3, 5};
		System.out.println(findMagicIndex(array));
	}
}