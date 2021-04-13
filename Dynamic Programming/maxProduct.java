public int maxProduct(int[] nums) {
      int max = nums[0];
        for(int i = 1, minSoFar = max, maxSoFar = max ; i < nums.length ; i++) {
            if(nums[i] < 0) {
                int temp = minSoFar;
                minSoFar = maxSoFar;
                maxSoFar = temp;
            }
            maxSoFar = Math.max(maxSoFar * nums[i], nums[i]);
            minSoFar = Math.min(minSoFar * nums[i], nums[i]);
            max = Math.max(max, maxSoFar);
        }
        return max;
}