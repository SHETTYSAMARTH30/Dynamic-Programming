class UniquePath {
    public int uniquePaths(int m, int n) {
        
        int dp[][] = new int[n][m];
        
        //No fo ways to reach any cell in first row is 1(right) & first column is 1(down) hence we put 1
        for(int[] arr: dp){
            Arrays.fill(arr,1);
        }
        
        //To reach a cell (n,m), we can come from either top ie [row-1,col] or from left ie [row,col-1]
        for(int row = 1; row < n; row++){
            for(int col=1; col < m; col++){
                
                    dp[row][col] = dp[row-1][col]+dp[row][col-1];
            }
        }
        
        return dp[n-1][m-1];
    }
}
