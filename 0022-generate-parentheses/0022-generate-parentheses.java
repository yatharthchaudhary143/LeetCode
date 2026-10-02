class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(0,0,n,"");
        return res;
    }

    public void helper(int open, int close, int n, String s){
        if (s.length()==2*n){
            res.add(s);
            return;
        }

        if (open<n){
            helper(open+1, close, n, s+'(');
        }

        if (close<open){
            helper(open, close+1, n, s+')');
        }

        return;
    }
}