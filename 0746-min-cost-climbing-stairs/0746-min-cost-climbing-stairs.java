class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,cost,dp);
    }

    private int helper(int ind, int[] arr, int[] dp){
        if (ind==0 || ind==1) return 0;

        if (dp[ind]!=-1) return dp[ind];

        int left=helper(ind-1,arr,dp)+arr[ind-1];
        int right=helper(ind-2,arr,dp)+arr[ind-2];

        dp[ind]=Math.min(left, right);
        return dp[ind];
    }
}