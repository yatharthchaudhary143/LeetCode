class Solution {
    int total=0;
    public int subsetXORSum(int[] nums) {
        
        return Xor(nums, 0, 0);

    }

    private int Xor(int[] nums, int i, int xor){
        if (i==nums.length) return xor;


        int notTake=Xor(nums, i+1, xor);

        int take=Xor(nums, i+1, xor^nums[i]);

        return take+notTake;
        
    }
}