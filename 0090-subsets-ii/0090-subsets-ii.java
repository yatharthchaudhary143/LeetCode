class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        powerSet(0, nums, res, new ArrayList<>());
        return res;
    }

    private void powerSet(int ind, int[] nums, List<List<Integer>> res, List<Integer> ds) {
        res.add(new ArrayList<>(ds));

        for (int i=ind; i<nums.length; i++) {
            if (i>ind && nums[i]==nums[i-1])
                continue;

            ds.add(nums[i]);
            powerSet(i+1, nums, res, ds);
            ds.remove(ds.size()-1);
        }
    }
}