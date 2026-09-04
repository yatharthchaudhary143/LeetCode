class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int id=n;

        for (int i=0; i<n; i++){
            int mx=Integer.MIN_VALUE;
            int mn=Integer.MAX_VALUE;
            boolean isStable=false;
            for (int j=0; j<=i; j++){
                mx=Math.max(mx, nums[j]);
            }

            for (int j=i; j<n; j++){
                mn=Math.min(mn, nums[j]);
            }

            int score=mx-mn;
            if (score<=k){
                isStable=true;
            }

            if (isStable){
                id=Math.min(id, i);
            }
        }

        if (id==n) return -1;
        
        return id;
    }
}