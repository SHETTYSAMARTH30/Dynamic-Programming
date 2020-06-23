class MaxSumPartition {
    public int maxSumAfterPartitioning(int[] A, int K) {
        
        int n = A.length;
        int dp[] = new int[n];
        
        for(int i=0; i < n; i++){
            
            int currMax = 0;
            for(int k=1; k <= K && i-k+1 >= 0; k++){
                
                currMax = Math.max(currMax,A[i-k+1]);
                dp[i] = Math.max(dp[i], (i >= k? dp[i - k] : 0) + currMax*k);
            }
        }
        
        return dp[n-1];
        
    }
}
