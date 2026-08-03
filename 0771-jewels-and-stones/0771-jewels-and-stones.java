class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> st=new HashSet<>();

        for (char ch:jewels.toCharArray()){
            st.add(ch);
        }

        int count=0;

        for (char ch:stones.toCharArray()){
            if (st.contains(ch)) count++;
        }

        return count;
    }
}