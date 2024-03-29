class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       //Nov 3rd
        
        if(k == 0){
            return false;
        }
        
        //loop k times
        //setup / open window
        //start left at 0
        //check if right is in the hashset
        //add right to hashset
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < k + 1 && i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }        
        
        //start looping until right side < length;
    //every iteration of loop remove leftmost from hashset and check if new right value is bread
        int right = k+1;
        while(right < nums.length){
            set.remove(nums[right - k - 1]);
            if(set.contains(nums[right])){
                return true;
            }
            set.add(nums[right]);
            right++;
        }
        return false;
       
        
       
        
        
  
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         if(k <= 0){
//             return false;
//         }
        
//         if(k == 1){
//            for(int i = 1; i < nums.length; i++){
//                if(nums[i-1] == nums[i]){
//                   return true; 
//                }
//            } 
//             return false;
//         }
        
//         int l = 0;
//         int r = 0;
//         //retry
//         HashSet<Integer> set = new HashSet<>();
//         while(r < k+1 && r < nums.length){
//             if(set.contains(nums[r])){
//                 return true;                
//             }
//             set.add(nums[r]);
//             r++;
//         }
//         while(r < nums.length){
//             set.remove(nums[l]);
//             if(set.contains(nums[r])){
//                 return true;                
//             }
//             set.add(nums[r]);
//             r++;
//             l++;
//         }
//         return false;
        
        
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
        
        
        // for(int i = k; i >= 1; i--){ // need this to decrement k until 1
        //     int l = 0; 
        //     int r = i;
        //     while(r < nums.length){
        //         if(nums[l] == nums[r]){
        //             return true;
        //         }
        //         l++;
        //         r++;
        //     }
        // }
        // return false;
        
        
        //best hashset solution
        
//         if(k <= 0){
//             return false;
//         }
        
//         if(k == 1){
//            for(int i = 1; i < nums.length; i++){
//                if(nums[i-1] == nums[i]){
//                   return true; 
//                }
//            } 
//             return false;
//         }
        
//         HashSet<Integer> set = new HashSet<>();
        
//         for(int i = 0; i < k+1 && i < nums.length; i++){
//             if(!set.add(nums[i])){
//                 return true;
//             }
//         }
        
//         for(int i = set.size(); i < nums.length; i++){
//             set.remove(nums[i-k-1]);
//             if(!set.add(nums[i])){
//                 return true;
//             }
//         }
//         return false;
    }
}