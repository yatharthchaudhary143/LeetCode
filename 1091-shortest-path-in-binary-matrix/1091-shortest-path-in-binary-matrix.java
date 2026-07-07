class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0]==1) return -1;

        int n=grid.length;
        if (n==1) return 1;
        
        int[][] vis=new int[n][n];
        Queue<Pair> q=new LinkedList<Pair>();

        q.add(new Pair(0,0,1));
        vis[0][0]=1;

        while (!q.isEmpty()){
            Pair p=q.peek();
            int r=p.row;
            int c=p.col;
            int d=p.dist;
            q.remove();

            for (int delr=-1; delr<=1; delr++){
                for (int delc=-1; delc<=1; delc++){
                    int nrow=r+delr;
                    int ncol=c+delc;

                    if (nrow>=0 && nrow<n && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==0){

                        if (nrow==n-1 && ncol==n-1){
                        return d+1;
                    }
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow, ncol, d+1));
                    }
                }
            }
        }

        return -1;

    }
}

class Pair {
    int row;
    int col;
    int dist;

    Pair(int r, int c, int d){
        row=r;
        col=c;
        dist=d;
    }
}