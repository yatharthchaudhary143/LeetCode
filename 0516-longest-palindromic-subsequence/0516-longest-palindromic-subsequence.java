class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];

        for (int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(0, n-1, s, dp);
    }

    private int helper(int l, int r, String s, int[][] dp){
        if (l>=s.length() || r<0) return 0;

        if (dp[l][r]!=-1) return dp[l][r];

        if (s.charAt(l)==s.charAt(r)) return dp[l][r]=1+helper(l+1, r-1, s, dp);

        return dp[l][r]=Math.max(helper(l+1, r, s, dp), helper(l, r-1, s, dp));
    }
}