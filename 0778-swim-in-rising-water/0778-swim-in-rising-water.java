class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->a.time-b.time);
        boolean[][] vis=new boolean[n][n];

        pq.add(new Pair(grid[0][0], 0, 0));
        vis[0][0]=true;

        int[] dr={-1, 0, 1, 0};
        int[] dc={0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Pair cur=pq.poll();
            int time=cur.time;
            int row=cur.row;
            int col=cur.col;

            if (row==n-1 && col==n-1) {
                return time;
            }

            for (int i=0; i<4; i++) {
                int newRow=row+dr[i];
                int newCol=col+dc[i];

                if (newRow>=0 && newRow<n && newCol>=0 && newCol<n && !vis[newRow][newCol]) {
                    vis[newRow][newCol]=true;

                    int newTime=Math.max(time, grid[newRow][newCol]);
                    pq.add(new Pair(newTime, newRow, newCol));
                }
            }
        }

        return -1;
    }
}

class Pair {
    int time;
    int row;
    int col;

    Pair(int time, int row, int col) {
        this.time=time;
        this.row=row;
        this.col=col;
    }
}