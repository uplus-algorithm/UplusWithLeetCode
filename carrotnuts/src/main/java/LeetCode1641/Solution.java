package main.java.LeetCode1641;


public class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = dp[0][4] = 1;

        int max = 5;
        for(int i=1; i<n; i++) {
            dp[i][0] = max;

            for(int k=1; k<5; k++) {
                dp[i][k] = dp[i][k-1] - dp[i-1][k-1];
                max += dp[i][k];
            }
            
        }

        return max;
    }
}