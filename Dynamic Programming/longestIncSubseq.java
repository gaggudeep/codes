public int lengthOfLIS(int[] nums) {
        int max = 1;
        for(int i = 0 ; i < nums.length - 1 ; i++) {
         max = Math.max(max, maxLIS(0, i, i + 1, nums));
        }
        return max;
    }
    int maxLIS(int len, int idx, int next, int[] nums) {
        if(next == nums.length)
            return len;
        if(nums[idx] <= nums[next]) {
            maxLIS(len + 1, idx, next + 1, nums);
        }
        else
            maxLIS(len, idx, next + 1, nums);
    }