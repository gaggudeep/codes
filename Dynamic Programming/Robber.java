import java.util.*;

class Robber {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int prev1 = 0, prev2 = 0;
        for(int num: nums)
        {
            int temp = prev1;
            prev1 = Math.max(num + prev2, prev1);
            prev2 = temp;
        }
        return prev1;
    }
}