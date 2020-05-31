/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
 */
public class Day31_EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        if (m==0)
            return n;
        if (n==0)
            return m;
        // Create a table to store results of subproblems 
        int dp[][]= new int[m+1][n+1];
        
        // Fill d[][] in bottom up manner 
        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                // If first string is empty, only option is to 
                // insert all characters of second string 
                if (i==0)
                    dp[i][j] = j;
                
                // If second string is empty, only option is to 
                // remove all characters of second string
                else if (j==0)
                    dp[i][j] = i;
                
                // If last characters are same, ignore last char 
                // and recur for remaining string 
                else if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                
                // If the last character is different, consider all 
                // possibilities and find the minimum 
                else 
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
            }
        }
        
        return dp[m][n];
    }
}