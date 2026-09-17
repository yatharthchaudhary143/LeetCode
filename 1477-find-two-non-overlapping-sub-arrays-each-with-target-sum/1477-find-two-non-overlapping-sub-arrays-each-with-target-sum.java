class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int[] best=new int[n];
        Arrays.fill(best, n+1);

        int l=0;
        int sum=0;
        int ans=n+1;
        int minLen=n+1;

        for (int r=0; r<n; r++){
            sum+=arr[r];

            while (sum>target){
                sum-=arr[l];
                l++;
            }

            if (target==sum){
                int len=r-l+1;
                
                if (l>0 && best[l-1]!=n+1){
                    ans=Math.min(ans, len+best[l-1]);
                }

                minLen=Math.min(minLen, len);
            }

            best[r]=minLen;
        }

        if (ans==n+1) return -1;

        return ans;
    }
}