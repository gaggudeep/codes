public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int prev[] = new int[matrix[0].length], cur[] = new int[matrix[0].length], max = 0;
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if( i == 0 || j == 0 || matrix[i][j] == '0') {
                    cur[j] = matrix[i][j] - '0';
                }
                else {
                    cur[j] = Math.min(cur[j - 1], Math.min(prev[j - 1], prev[j])) + 1;
                } 
                max = Math.max(max, cur[j]);
            }
            prev = cur;
            cur = new int[cur.length];
        }
        return max * max;
    }