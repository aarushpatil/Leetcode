class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //check k numbers ahead for duplicate  -  make sure not to fail out of bounds edge case
        
        
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = i+1; j < nums.length && count < k; j++){
                if(nums[i] == nums[j]){ // fix this
                  return true;  
                }
                count++;
            }            
        }
        return false;
    }
}