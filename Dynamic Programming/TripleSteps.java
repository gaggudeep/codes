import java.util.*;

class TripleSteps {

	static long countWays(int steps) {

		long memo[] = new long[steps + 1];
		Arrays.fill(memo, -1);

		return countWays(steps, memo);
	}

	static long countWays(int steps, long memo[]) {

		if(steps < 0) {
			return 0;
		}
		else if(steps == 0) {
			return 1;
		}
		else if(memo[steps] > -1) {
			return memo[steps];
		}
		else {

			memo[steps] = countWays(steps - 1, memo) + countWays(steps - 2, memo) + countWays(steps - 3, memo);

			return memo[steps];
		}

	}

	public static void main(String args[]) {

		int n = 4085;
		System.out.println(countWays(n));
	}
}