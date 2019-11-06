package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A.length == 0 || A[0].length == 0)
            return 0;

        int r = A.length, c = A[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0){
                    dp[i][j] = A[i][j];
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                    continue;
                }

                if (j == c - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + A[i][j];
                    continue;
                }

                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + A[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < c; j++) {
            res = Math.min(res, dp[r - 1][j]);
        }
        return res;
    }
}