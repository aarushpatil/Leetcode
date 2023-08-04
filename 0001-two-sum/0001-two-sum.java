class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
//value. index
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                int[] arr = {map.get(target - nums[i]), i};
                return arr;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}