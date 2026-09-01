class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m=classroom.length;
        int n=classroom[0].length();
        
        int sr=0;
        int sc=0;
        int litter=0;

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                char ch=classroom[i].charAt(j);
                if (ch=='S') {
                    sr=i;
                    sc=j;
                }
                if (ch=='L') litter++; 
            }
        }
                

        int[][] litterId=new int[m][n];
        for (int i=0; i<m; i++){
            Arrays.fill(litterId[i], -1);
        }

        int id=0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (classroom[i].charAt(j)=='L') litterId[i][j]=id++;
            }
        }

        int allCollected=(1<<litter)-1;

        boolean[][][][] vis=new boolean[m][n][energy+1][1<<litter];

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr, sc, energy, 0));
        vis[sr][sc][energy][0]=true;

        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};

        int moves=0;

        while(!q.isEmpty()){
            int size=q.size();

            while (size-->0){
                Pair p=q.poll();
                int r=p.row;
                int c=p.col;
                int e=p.energy;
                int mask=p.mask;

                if (mask==allCollected){
                    return moves;
                }

                for (int i=0; i<4; i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];

                    if (nr<0 || nr>=m || nc<0 || nc>=n) {
                        continue;
                    }

                    if (classroom[nr].charAt(nc)=='X') continue;

                    if (e==0) continue;

                    int newEnergy=e-1;
                    int newMask=mask;

                    if (classroom[nr].charAt(nc)=='L'){
                        int lit=litterId[nr][nc];
                        newMask = mask | (1 << lit);
                    }

                    if (classroom[nr].charAt(nc)=='R') newEnergy=energy;

                    if (!vis[nr][nc][newEnergy][newMask]){
                        vis[nr][nc][newEnergy][newMask]=true;

                        q.add(new Pair(nr, nc, newEnergy, newMask));
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}

class Pair{
    int row;
    int col;
    int energy;
    int mask;

    Pair (int row, int col, int energy, int mask){
        this.row=row;
        this.col=col;
        this.energy=energy;
        this.mask=mask;
    }
}