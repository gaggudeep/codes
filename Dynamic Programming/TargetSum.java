class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int n : nums)
            sum += n;
        if(sum < S || (sum + S) % 2 != 0)
            return 0;
        int sumP = (sum + S) / 2;
        int dp[] = new int[sumP + 1];
        dp[0] = 1;
        for(int n : nums)
        {
            for(int i = sumP ; i >= n ; i--)
                dp[i] += dp[i - n];
        }
        return dp[sumP];
    }
    
}