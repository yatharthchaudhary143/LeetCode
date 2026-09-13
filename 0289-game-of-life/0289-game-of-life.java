class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;

        int[][] neigh=new int[m][n];

        int[] dr={-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc={-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                for (int k=0; k<8; k++){
                    int r=i+dr[k];
                    int c=j+dc[k];
                    if (r<0 || r>=m || c<0 || c>=n) continue;
                    if (board[r][c]==1) neigh[i][j]++;
                }
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (board[i][j]==0 && neigh[i][j]==3){
                    board[i][j]=1;
                }
                else if (board[i][j]==1 && neigh[i][j]<2){
                    board[i][j]=0;
                }
                else if (board[i][j]==1 && neigh[i][j]>3){
                    board[i][j]=0;
                }
            }
        }

        return;
    }
}
