class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int n = nums.length;
        if(n == 0)
            return new ArrayList();
        
        // Container to keep the size of the largest divisible subset
       //   that ends with each of the nums.
        int dp[] = new int[n];
        
        //We will sort the array in the Ascending order
        Arrays.sort(nums);
        
        //To record the max size and index where max subset ends
        int maxSubsetSize = -1;
        int maxSubsetIndex = -1;
        
        for(int i=0; i<n; i++){
            
            int subsetSize = 0;
            
            //We will divide each number by the number ahead of it and check whether its divisible
            for(int k=0; k<i; k++){
                
                //We will include a num in set only if including it increases the size of subset
                if(nums[i] % nums[k] == 0 && subsetSize < dp[k])
                    subsetSize = dp[k];
            }
            
            //Any number is divisible by itself hence we will include it in subset
            dp[i] = subsetSize + 1;
            
            if(dp[i] > maxSubsetSize){
                maxSubsetSize = dp[i];
                maxSubsetIndex = i;
            }
        }
        
        //To store the subset
        LinkedList<Integer> subset = new LinkedList();
        
        //Last number in set
        int currTail = nums[maxSubsetIndex];
        //Size of subset
        int currSize = maxSubsetSize;
        
        
        for(int i=maxSubsetIndex; i >= 0; i--){
            
            //It means we have included all elements in set
            if(currSize == 0)
                break;
            
            //We check whether a number is divisible && size is similar
            if(currTail % nums[i] == 0 && currSize == dp[i]){
                subset.addFirst(nums[i]);
                currTail = nums[i];
                currSize -=1;
            }
                
        }
          
        return subset;      
            
    }
}
