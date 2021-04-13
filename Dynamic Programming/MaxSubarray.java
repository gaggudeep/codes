class MaxSubarray {
    public static int maxSubArray(int[] A) {
        int maxSumSoFar = A[0], maxEndingHere = A[0];
        for(int i = 1 ; i < A.length ; i++)
        {
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSumSoFar = Math.max(maxSumSoFar, maxEndingHere);
        }
        return maxSumSoFar;
    }
}