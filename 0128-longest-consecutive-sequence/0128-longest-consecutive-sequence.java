class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int num: nums) set.add(num);
        int maxCount = 0;

        for (int num: nums) {
            if (set.contains(num - 1)) continue;
            int count = 1;
            while (set.contains(num + count)) {
                count++;
            }

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}