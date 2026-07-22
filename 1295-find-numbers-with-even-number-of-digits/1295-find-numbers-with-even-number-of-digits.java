class Solution {
    public int findNumbers(int[] nums) {
        int count=0;

        for (int x:nums){
            int c=0;
            while (x>0){
                c+=1;
                x/=10;
            }
            if (c%2==0) count++;
        }

        return count;
    }
}