class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int left=0;
        int len=0;

        for (int right=0; right<s.length(); right++){
            mp.putIfAbsent(s.charAt(right), 0);
            mp.put(s.charAt(right), mp.get(s.charAt(right))+1);

            while (mp.get(s.charAt(right))>2){
                mp.put(s.charAt(left), mp.get(s.charAt(left))-1);
                left++;
            }

            len=Math.max(len, right-left+1);
        }

        return len;


    }
}