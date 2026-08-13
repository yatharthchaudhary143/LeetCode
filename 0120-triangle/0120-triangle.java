class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer[][] dp=new Integer[n][n];
        return helper(0, 0, dp, n, triangle);
    }

    private int helper(int i, int j, Integer[][] dp, int n, List<List<Integer>> tri){
        if (i==n-1) return tri.get(n-1).get(j);

        if(dp[i][j]!=null) return dp[i][j];

        int down=tri.get(i).get(j)+helper(i+1,j, dp, n, tri);
        int diag=tri.get(i).get(j)+helper(i+1, j+1, dp, n, tri);

        dp[i][j]=Math.min(down,diag);
        return dp[i][j];
    }
}