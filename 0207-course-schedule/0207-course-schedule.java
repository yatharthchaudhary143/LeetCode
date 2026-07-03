class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u=edge[0];
            int v=edge[1];
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
            
        
        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            res.add(node);
            
            for (int n:adj.get(node)){
                indeg[n]--;
                if (indeg[n]==0) q.add(n);
            }
        }
        
        if (res.size()==numCourses){
            return true;
        }
        return false;
    }
}
