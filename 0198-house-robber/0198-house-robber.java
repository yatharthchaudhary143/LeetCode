class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        return helper(n-1, nums, dp);
    }

    private int helper(int ind, int[] arr, int[] dp){
        if (ind==0) return arr[0];
        if (ind<1) return 0;

        if (dp[ind]!=-1) return dp[ind];

        int pick=arr[ind]+helper(ind-2, arr, dp);
        int notPick=0+helper(ind-1, arr, dp);

        dp[ind]=Math.max(pick, notPick);

        return dp[ind];
    }
}