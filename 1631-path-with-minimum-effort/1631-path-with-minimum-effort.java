class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.dist-y.dist);

        int n=heights.length;
        int m=heights[0].length;

        int[][] dist=new int[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }

        dist[0][0]=0;
        pq.add(new Pair(0,0,0));
        int[] dr={-1, 0, 1, 0};
        int[] dc={0, 1, 0, -1};

        while (!pq.isEmpty()){
            Pair p=pq.poll();
            int diff=p.dist;
            int row=p.row;
            int col=p.col;

            if (diff>dist[row][col]) continue;

            if (row==n-1 && col==m-1) return diff;

            for (int i=0; i<4; i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];

                if (nrow>=0 && ncol>=0 && nrow<n && ncol<m){
                    int newEff=Math.max(Math.abs(heights[row][col]-heights[nrow][ncol]), diff);
                    if (newEff<dist[nrow][ncol]){
                        dist[nrow][ncol]=newEff;
                        pq.add(new Pair(newEff, nrow, ncol));
                    }
                }
            }
        }

        return 0;
    }
}

class Pair {
    int dist;
    int row;
    int col;

    Pair(int d, int r, int c){
        dist=d;
        row=r;
        col=c;
    }
}
