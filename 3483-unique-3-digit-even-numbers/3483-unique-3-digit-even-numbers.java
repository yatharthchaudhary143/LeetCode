class Solution {
    HashSet<Integer> st=new HashSet<>();
    boolean[] used=new boolean[10];

    public int totalNumbers(int[] digits) {
        helper(0, 0, digits);
        return st.size();
    }

    private void helper(int count, int num, int[] digits) {
        if (count==3) {
            if (num>=100 && num%2==0) {
                st.add(num);
            }
            return;
        }

        for (int i=0; i<digits.length; i++) {

            if (used[i]) continue;

            if (count==0 && digits[i]==0) continue;

            used[i]=true;

            helper(count+1, num*10+digits[i], digits);

            used[i]=false;
        }
    }
}