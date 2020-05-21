/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
 */
public class Day21_CountSquareSubmetricesWithAllOnes {
    public int countSquares(int[][] a) {
        int ans = 0; 
        int m = a[0].length;
        int n = a.length;
        
        for (int i=0; i<n; i++) {
            ans += a[i][m-1];
        }
        
        for (int i=0; i<m; i++) {
            ans += a[n-1][i];
        }
        
        ans = ans - a[n-1][m-1];
        
        for (int i = n-2; i>=0; i--) {
            for (int j = m-2; j>=0; j--) {
                if (a[i][j] == 1) {
                    a[i][j] = a[i][j] + Math.min(Math.min(a[i+1][j], a[i][j+1]), a[i+1][j+1]);
                } else 
                    a[i][j] = 0;
                
                ans += a[i][j];
            }
        }
        
        return ans;
    }
}