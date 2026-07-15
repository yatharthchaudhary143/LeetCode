class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);

        for (int row=0; row<n; row++) {
            for (int col=0; col<n; col++) {
                if (grid[row][col]==0)
                    continue;

                int[] dr={-1, 0, 1, 0};
                int[] dc={0, 1, 0, -1};
                for (int ind=0; ind<4; ind++) {
                    int newRow=row+dr[ind];
                    int newCol=col+dc[ind];

                    if (isValid(newRow, newCol, n) && grid[newRow][newCol]==1) {
                        int nodeNo=row*n+col;
                        int adjNodeNo=newRow*n+newCol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int mx=0;

        for (int row=0; row<n; row++) {
            for (int col=0;col<n; col++) {
                if (grid[row][col] == 1)
                    continue;

                int[] dr={-1, 0, 1, 0};
                int[] dc={0, 1, 0, -1};

                HashSet<Integer> components=new HashSet<>();

                for (int ind=0; ind<4; ind++) {
                    int newRow=row+dr[ind];
                    int newCol=col+dc[ind];

                    if (isValid(newRow, newCol, n) && grid[newRow][newCol]==1) {
                        components.add(ds.findParent(newRow*n+newCol));
                    }
                }

                int sizeTotal=0;
                for (Integer parent:components) {
                    sizeTotal+=ds.size.get(parent);
                }

                mx=Math.max(mx, sizeTotal+1);
            }
        }

        // Edge case: all cells are already 1
        for (int cellNo=0; cellNo<n*n; cellNo++) {
            mx = Math.max(mx, ds.size.get(ds.findParent(cellNo)));
        }

        return mx;
    }

    private boolean isValid(int row, int col, int n) {
    return row >= 0 && row < n && col >= 0 && col < n;
    }
}

class DisjointSet {
    List<Integer> size=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();

    public DisjointSet (int n){
        for (int i=0; i<=n; i++){
        parent.add(i);
        rank.add(0);
        size.add(1);
        }
    }

    public void unionByRank (int u, int v) {
        int pu=findParent(u);
        int pv=findParent(v);
        if (pu==pv) return;
        if (rank.get(pu)<rank.get(pv)){
            parent.set(pu, pv);
        }
        else if (rank.get(pv)<rank.get(pu)){
            parent.set(pv, pu);
        }
        else {
            parent.set(pv, pu);
            rank.set(pu, rank.get(pu)+1);
        }
    }

    public void unionBySize (int u, int v) {
        int pu=findParent(u);
        int pv=findParent(v);
        if (pu==pv) return;
        if (size.get(pu)<size.get(pv)){
            parent.set(pu, pv);
            size.set(pv, size.get(pu)+size.get(pv));
        }
        else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu)+size.get(pv));
        }
    }

    public int findParent (int u) {
        if (u==parent.get(u)){
            return u;
        }
        parent.set(u, findParent(parent.get(u)));
        return parent.get(u);
    }
}

