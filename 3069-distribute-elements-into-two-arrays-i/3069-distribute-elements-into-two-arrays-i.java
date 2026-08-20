class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        int l1=0;
        int l2=0;
        for (int i=2; i<n; i++){
            if (arr1.get(l1)>arr2.get(l2)){
                arr1.add(nums[i]);
                l1++;
            }
            else {
                arr2.add(nums[i]);
                l2++;
            }
        }

        int[] res=new int[n];
        int i=0;
        for (int x:arr1){
            res[i++]=x;
        }
        for (int x:arr2){
            res[i++]=x;
        }

        return res;

    }
}