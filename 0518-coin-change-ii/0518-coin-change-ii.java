class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for (int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(n-1, amount, coins, dp);
    }

    private int helper(int ind, int target, int[] coins, int[][] dp){
        if (ind==0){
            if (target%coins[ind]==0) return 1;
            else return 0;
        }

        if (dp[ind][target]!=-1) return dp[ind][target];

        int npick=helper(ind-1, target, coins, dp);
        int pick=0;
        if (coins[ind]<=target) pick=helper(ind, target-coins[ind], coins, dp);

        return dp[ind][target]=pick+npick;
    }
}