class Solution {
    public int reverseDegree(String s) {
        int res=0;
        int i=1;
        for (char ch:s.toCharArray()){
            int x=(123-ch)*i;
            res+=x;
            i++;
        }

        return res;
    }
}