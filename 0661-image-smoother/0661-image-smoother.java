class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;

        int[][] ans = new int[m][n];

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = img[i][j];
                int count = 1;

                for (int k = 0; k < 8; k++) {
                    int ni = i + dr[k];
                    int nj = j + dc[k];

                    if (ni >= 0 && ni < m &&
                        nj >= 0 && nj < n) {

                        sum += img[ni][nj];
                        count++;
                    }
                }

                ans[i][j] = sum / count;
            }
        }

        return ans;
    }
}