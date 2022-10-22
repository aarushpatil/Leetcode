class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        //trash solution
        //O(N)^2
        // for(int i = 0; i < nums.length; i++){
        //     int count = 0;
        //     for(int j = i+1; j < nums.length && count < k; j++){
        //         if(nums[i] == nums[j]){ // fix this
        //           return true;  
        //         }
        //         count++;
        //     }            
        // }
        // return false;
        
        
        //better solution 
        //time complexity O(n) * k,
        //check for worst case
        
        
        for(int i = k; i >= 1; i--){ // need this to decrement k until 1
            int l = 0; 
            int r = i;
            while(r < nums.length){
                if(nums[l] == nums[r]){
                    return true;
                }
                l++;
                r++;
            }
        }
        return false;
    }
}