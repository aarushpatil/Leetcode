class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        //track left product
        //track right product
        //in array store value of product of everything to left of it
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1; i < left.length; i++){ //left [1,2,6,24] , right [24,24,12,4]
            left[i] = nums[i] * left[i-1];
            right[nums.length - i - 1] = nums[nums.length - i - 1] * right[nums.length - i];
            //then solution[r[i+1] * l[i-1], r[i+1] * l[i-1], r[i+1] * l[i-1]]
        }
        int[] answer = new int[nums.length];
        for(int i = 1; i < nums.length - 1; i++){
            answer[i] = right[i+1] * left[i-1];
        }
        answer[0] = right[1];
        answer[answer.length-1] = left[answer.length-2];
        return answer;
    }
}