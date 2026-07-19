class Solution {
    public String smallestSubsequence(String s) {
        int[] freq=new int[26];
        for (int i=0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }

        boolean[] vis=new boolean[26];
        Stack<Character> st=new Stack<>();
        
        for (char ch:s.toCharArray()){
            freq[ch-'a']--;

            if (vis[ch-'a']){
                continue;
            }

            while (!st.isEmpty() && st.peek()>ch && freq[st.peek()-'a']>0){
                vis[st.pop()-'a']=false;
            }

            st.push(ch);
            vis[ch-'a']=true;
        }

        StringBuilder res=new StringBuilder();

        for (char ch:st){
            res.append(ch);
        }

        return res.toString();
    }
}