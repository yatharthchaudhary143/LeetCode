class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u=edge[1];
            int v=edge[0];
            adj.get(u).add(v);
        }
        
        int[] indeg=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        
        for (int i=0; i<numCourses; i++){
            for (int n:adj.get(i)){
                indeg[n]++;
            }
        }
        
        for (int i=0; i<numCourses; i++){
            if (indeg[i]==0) q.add(i);
        }
            
        
        int[] res=new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            res[i++]=node;
            
            for (int n:adj.get(node)){
                indeg[n]--;
                if (indeg[n]==0) q.add(n);
            }
        }
        
        if (i!=numCourses) {
            return new int[0];
        }

        return res;
    }
}