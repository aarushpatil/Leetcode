class Solution {
    public boolean containsDuplicate(int[] nums) {
        //low space complexity solution
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = i+1; j < nums.length; j++){
        //         if(nums[i] == nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
        
        //time efficient solution
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length-1; i++){
            set.add(nums[i]);
            if(set.contains(nums[i+1])){
                return true;
            }
        }
        return false;
    }
}