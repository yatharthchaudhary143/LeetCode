class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int index = i * n + j;
                int newIndex = (index + k) % (m * n);

                int row = newIndex / n;
                int col = newIndex % n;

                ans[row][col] = grid[i][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> curr = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                curr.add(ans[i][j]);
            }

            res.add(curr);
        }

        return res;
    }
}