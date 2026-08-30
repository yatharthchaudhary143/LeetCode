class Solution {
    public int minimumDeletions(int[] nums) {
        int maxi=-1;
        int mini=-1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++){
            min=Math.min(min, nums[i]);
            if (nums[i]==min) mini=i;
            max=Math.max(max, nums[i]);
            if (max==nums[i]) maxi=i;
        }

        int d1=Math.max(maxi, mini)+1;
        int d2=nums.length-Math.min(maxi, mini);
        int d3=Math.min(maxi, mini)+1+(nums.length-Math.max(mini, maxi));

        return Math.min(d1, Math.min(d2, d3));
        
    }
}