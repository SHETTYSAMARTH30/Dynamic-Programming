class CoinChange2 {
    public int change(int amount, int[] coins) {
        
        int dp[] = new int[amount+1];
        
        //No of combinations to make amount 0 with coin 0 is 1,rest all the other amounts will be 0 because no of combinations to make them using coin 0 will be 0.
        dp[0] = 1;
        
        for(int coin : coins){
            
            for(int x = coin; x <= amount; x++){
                dp[x] += dp[x-coin];
            }
            
        }
        
        return dp[amount];
        
    }
}
