import java.util.*;

class LongestIncPath 
{
    static int dirs[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int longestIncreasingPath(int[][] matrix) 
    {
        if(matrix.length <= 0 || matrix[0].length <= 0)
            return 0;
        int maxPath = 0;
        int path[][] = new int[matrix.length][matrix[0].length];
        for(int i =  0 ; i < matrix.length ; i++)
        {
            for(int j = 0 ; j < matrix[0].length ; j++)
            {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, path));
            }
        }
        return maxPath;
    }

    public static int dfs(int[][] m, int r, int c, int[][] path)
    {
        if(path[r][c] != 0)
            return path[r][c];
        int max = 1;
        for(int[] dir: dirs)
        {
            int x = r + dir[0], y = c + dir[1];
            if(x < 0 || x >= m.length || y < 0 || y >= m[0].length || m[x][y] <= m[r][c])
                continue;
            int len = 1 + dfs(m, x, y, path);
            max = Math.max(max, len);
        }
        path[r][c] = max;

        return max;
    }

    public static void main(String args[])
    {
        int a[][] = {{7,8,9},{9,7,6},{7,2,3}};
        System.out.println(longestIncreasingPath(a));
    }
}