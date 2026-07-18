class Solution {
    public int findGCD(int[] nums) {
        int mn=1001;
        int mx=0;

        for (int x:nums){
            if (x>mx) mx=x;
            if (x<mn) mn=x;
        }

        int gcd=1;
        for (int i=1; i<=mn; i++){
            if (mx%i==0 && mn%i==0){
                gcd=i;
            }
        }

        return gcd;
    }
}