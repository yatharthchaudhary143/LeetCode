class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        int v=graph.length;

        for (int i=0; i<v; i++) {
            revAdj.add(new ArrayList<>());
        }

        for (int i=0; i<v; i++) {
            for (int neigh : graph[i]) {
                revAdj.get(neigh).add(i);
            }
        }

        int[] indeg=new int[v];
        for (int i=0; i<v; i++){
            for (int n:revAdj.get(i)){
                indeg[n]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i=0; i<v; i++){
            if (indeg[i]==0) q.add(i);
        }

        List<Integer> res=new ArrayList<>();
        while (!q.isEmpty()){
            int node=q.peek();
            q.remove();
            res.add(node);

            for (int n:revAdj.get(node)){
                indeg[n]--;
                if (indeg[n]==0) q.add(n);
            }
        }

        Collections.sort(res);
        return res;
    }
}