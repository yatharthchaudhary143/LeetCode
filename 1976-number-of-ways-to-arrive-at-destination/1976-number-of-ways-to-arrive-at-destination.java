class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD=1_000_000_007;

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road:roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            long dis = cur.dist;
            int node = cur.node;

            if (dis > dist[node]) continue;

            for (Pair p : adj.get(node)) {

                int adjNode = p.node;
                int wt = p.wt;

                if (dis + wt < dist[adjNode]) {

                    dist[adjNode] = dis + wt;
                    ways[adjNode] = ways[node];

                    pq.add(new Node(dist[adjNode], adjNode));
                }
                else if (dis + wt == dist[adjNode]) {

                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}

class Pair {
    int node;
    int wt;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

class Node {
    long dist;
    int node;

    Node(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}