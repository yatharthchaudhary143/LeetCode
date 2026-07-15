class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int countExtra=0;
        for (int i=0; i<connections.length; i++){
            int u=connections[i][0];
            int v=connections[i][1];

            if (ds.findParent(u)==ds.findParent(v)){
                countExtra++;
            }
            else {
                ds.unionBySize(u,v);
            }
        }

        int countComp=0;
        for (int i=0; i<n; i++){
            if (ds.parent.get(i)==i){
                countComp++;
            }
        }

        if (countExtra>=countComp-1){
            return countComp-1;
        }

        return -1;
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

