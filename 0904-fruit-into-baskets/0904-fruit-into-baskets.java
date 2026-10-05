class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> mp=new HashMap<>();

        int l=0;
        int maxLen=0;

        for (int r=0; r<fruits.length; r++){
            mp.putIfAbsent(fruits[r],0);
            mp.put(fruits[r], mp.get(fruits[r])+1);

            while (mp.size()>2){
                mp.put(fruits[l], mp.get(fruits[l])-1);
                if (mp.get(fruits[l])==0) mp.remove(fruits[l]);
                l++;
            }

            maxLen=Math.max(maxLen, r-l+1);
        }

        return maxLen;
    }
}