class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> numMap = new HashSet<>();
        numMap.add(1);

        int maxNum = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > maxNum && contains(-1 * nums[i], nums)) {
                maxNum = nums[i];
            }
        }
        return maxNum;
    }


    private static boolean contains(int a, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                return true;
            }
        }

        return false;
    }
}