class Solution {
    int[] count;
    int minPrice;
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        minPrice=Integer.MAX_VALUE;

        int[][] dp=new int[n][budget+1];
        for (int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        count=new int[n];
        for (int i=0; i<n; i++){
            minPrice=Math.min(minPrice, items[i][1]);

            for (int j=0; j<n; j++){
                if (items[j][0]%items[i][0]==0){
                    count[i]++;
                }
            }
        }

        return helper(n-1, budget, items, dp);

    }

    public int helper(int i, int B, int[][] arr, int[][] dp){
        if (i<0){
            return B/minPrice;
        }

        if (dp[i][B]!=-1) return dp[i][B];

        int pick=0;
        if (arr[i][1]<=B) pick=count[i]+helper(i-1, B-arr[i][1], arr, dp);

        int npick=helper(i-1, B, arr, dp);

        return dp[i][B]=Math.max(pick, npick);
    }
}