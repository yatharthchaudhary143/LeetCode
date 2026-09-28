class Solution {
    public int maxDepth(String s) {
        int maxDepth=0;
        int level=0;

        for (char i:s.toCharArray()){
            if (i=='('){
                level++;
                maxDepth=Math.max(maxDepth,level);
            }
            else if (i==')'){
                level--;
            }
        }
        return maxDepth;
    }
}