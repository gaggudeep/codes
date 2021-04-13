class RoboGrid {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        int cur[] = new int[n];
        Arrays.fill(cur, 1);
        for(int i = 1 ; i < m ; i++)
        {
            for(int j = 1 ; j < n ; j++)
            {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}