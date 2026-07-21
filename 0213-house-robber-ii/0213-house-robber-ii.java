class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];

        for (int i = 1; i < n; i++)
            temp1[i - 1] = nums[i];

        for (int i = 0; i < n - 1; i++)
            temp2[i] = nums[i];

        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(helper(n - 2, temp1, dp1),
                        helper(n - 2, temp2, dp2));
    }

    private int helper(int ind, int[] arr, int[] dp) {

        if (ind == 0)
            return arr[0];

        if (ind < 0)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        int pick = arr[ind] + helper(ind - 2, arr, dp);
        int notPick = helper(ind - 1, arr, dp);

        dp[ind] = Math.max(pick, notPick);

        return dp[ind];
    }
}