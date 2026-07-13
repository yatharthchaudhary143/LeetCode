class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if (digits.length()==0) {
            return res;
        }

        String[] map = {
                "", "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"
        };

        helper(0, digits, map, new StringBuilder(), res);

        return res;
    }

    private void helper(int index,
                        String digits,
                        String[] map,
                        StringBuilder curr,
                        List<String> res) {

        if (index==digits.length()) {
            res.add(curr.toString());
            return;
        }

        String letters=map[digits.charAt(index)-'0'];

        for (char ch:letters.toCharArray()) {
            curr.append(ch);
            helper(index+1, digits, map, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}