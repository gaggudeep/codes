import java.util.*;

class AllSubsets {

	static ArrayList<ArrayList<Integer>> getAllSubsets(int[] set, int index) {

		ArrayList<ArrayList<Integer>> allSubsets; 
		if(set.length == index) {

			allSubsets = new ArrayList<>();
			allSubsets.add(new ArrayList<Integer>());
		}
		else {

			allSubsets = getAllSubsets(set, index + 1);
			int element = set[index];
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
			for(ArrayList<Integer> subsets : allSubsets) {

				ArrayList<Integer> newSubset = new ArrayList<>();
				newSubset.addAll(subsets);
				newSubset.add(element);
				//System.out.println(subsets + " and " + element + " added to newSubset.");
				moreSubsets.add(newSubset);
				//System.out.println(newSubset + " added to moreSubsets");
			}
			allSubsets.addAll(moreSubsets);
			//System.out.println(moreSubsets + " added to allSubsets.");
		}
		return allSubsets;
	}

	static ArrayList<ArrayList<Integer>> getSubsets(int[] set) {

		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
		int max = 1 << set.length;
		for(int k = 0; k < max ; k++) {

			ArrayList<Integer> subset = convertIntToSet(k, set);
			allSubsets.add(subset);
		}
		return allSubsets;
	}

	static ArrayList<Integer> convertIntToSet(int x, int[] set) {

		ArrayList<Integer> subset = new ArrayList<>();
		int index = 0;
		for(int k = x ; k > 0 ; k>>= 1) {

			if((k & 1) == 1) {

				subset.add(set[index]);
			}
			index++;
		}
		return subset;
	}

	public static void main(String args[]) {

		int[] set = {1, 2, 3};
		System.out.println(getSubsets(set));
	}
}
