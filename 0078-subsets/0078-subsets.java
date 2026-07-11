class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res=new ArrayList<>();
        powerSet(0, nums, res, new ArrayList<>());
        return res;
    }

    private void powerSet(int ind, int[] arr, List<List<Integer>> res, List<Integer> ds){
        if (ind==arr.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        ds.add(arr[ind]);
        powerSet(ind+1, arr, res, ds);
        ds.remove(ds.size()-1);

        powerSet(ind+1, arr, res, ds);
    }
}