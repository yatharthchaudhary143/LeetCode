class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int total=0;
        for (int x:nums) total+=x;

        if (total%2!=0) return false;

        int[][] dp=new int[n][(total/2)+1];
        for (int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(n-1, total/2, dp, nums);
    }

    private boolean helper(int ind, int target, int[][]dp, int[] arr){
        if (target==0) return true;
        if (ind==0) return arr[0]==target;

        if (dp[ind][target]!=-1) return dp[ind][target]==1;

        boolean ntake=helper(ind-1, target, dp, arr);
        boolean take=false;
        if (target>=arr[ind]) take=helper(ind-1, target-arr[ind], dp, arr);

        boolean ans = take || ntake;
        dp[ind][target] = ans ? 1 : 0;

        return ans;
    }
}