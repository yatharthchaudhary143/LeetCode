class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int[][] dp=new int[n][m];
        for (int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        int com=helper(n-1, m-1, word1, word2, dp);

        if (n==m) return 2*(n-com);
        else return (n-com)+(m-com);
    }

    private int helper(int i1, int i2, String s1, String s2, int[][] dp){
        if (i1<0 || i2<0) return 0;

        if (dp[i1][i2]!=-1) return dp[i1][i2];

        if (s1.charAt(i1)==s2.charAt(i2)){
            return dp[i1][i2]=1+helper(i1-1, i2-1, s1, s2, dp);
        }

        return dp[i1][i2]=Math.max(helper(i1-1, i2, s1, s2, dp), helper(i1, i2-1, s1, s2, dp));
    }
}