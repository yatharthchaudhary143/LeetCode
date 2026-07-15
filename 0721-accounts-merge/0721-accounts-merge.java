class Solution {
    static List<List<String>> accountsMerge(List<List<String>> details) {

        int n = details.size();

        DisjointSet ds = new DisjointSet(n);

        HashMap<String, Integer> mapMailNode = new HashMap<>();

        // Map every email to its account index
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < details.get(i).size(); j++) {

                String mail = details.get(i).get(j);

                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        // Put every email under its ultimate parent
        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {

            String mail = it.getKey();
            int node = ds.findParent(it.getValue());

            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (mergedMail[i].size() == 0)
                continue;

            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();

            temp.add(details.get(i).get(0));

            for (String mail : mergedMail[i]) {
                temp.add(mail);
            }

            ans.add(temp);
        }

        return ans;
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
