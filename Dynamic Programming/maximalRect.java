 public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, left[] = new int[n], right[] = new int[n], height[] = new int[n], maxA = 0;
        Arrays.fill(right, n);
        for(int i = 0 ; i < m ; i++) {
            int cur_left = 0, cur_right = n; 
            for(int j = 0 ; j < n ; j++) {
                if(matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], cur_left);
                }
                else {
                    height[j] = left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for(int j = n - 1 ; j >= 0 ; j--) {
                if(matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            for(int j = 0 ; j < n ; j++)
                maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
        }
        return maxA;
    }