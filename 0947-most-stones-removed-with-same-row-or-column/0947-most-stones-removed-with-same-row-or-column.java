class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int maxRow=0;
        int maxCol=0;

        for (int i=0; i<n; i++) {
            maxRow=Math.max(maxRow, stones[i][0]);
            maxCol=Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds=new DisjointSet(maxRow+maxCol+2);
        HashSet<Integer> nodes = new HashSet<>();

        for (int i=0; i<n; i++) {
            int rowNode=stones[i][0];
            int colNode=stones[i][1]+maxRow+1;

            ds.unionBySize(rowNode, colNode);
            nodes.add(rowNode);
            nodes.add(colNode);
        }

        int components=0;
        for (int node:nodes) {
            if (ds.findParent(node)==node) {
                components++;
            }
        }

        return n-components;
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