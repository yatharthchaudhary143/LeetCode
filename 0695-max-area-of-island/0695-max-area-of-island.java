class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] vis=new int[m][n];
        for (int i=0; i<m; i++){
            Arrays.fill(vis[i], 0);
        }

        int area=0;

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (vis[i][j]==0)
                    area=Math.max(area, dfs(i, j, grid, vis));
            }
        }

        return area;
    }

    private int dfs(int row, int col, int[][] grid, int[][] vis){
        if (row<0 || row>=grid.length || col<0 || col>=grid[0].length || vis[row][col]==1 || grid[row][col]==0){
            return 0;
        }

        vis[row][col]=1;
        int left=dfs(row, col-1, grid, vis);
        int right=dfs(row, col+1, grid, vis);
        int up=dfs(row-1, col, grid, vis);
        int down=dfs(row+1, col, grid, vis);

        return 1+left+right+up+down;

    }
}