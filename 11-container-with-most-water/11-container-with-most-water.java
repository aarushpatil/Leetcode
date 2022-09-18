class Solution {
    public static int maxArea(int[] height) {
		int maxArea = 0, a = 0, b = height.length - 1;
		while (b - a > 0) {
			maxArea = Math.max(maxArea, Math.min(height[a], height[b]) * (b - a));
			if (Math.min(height[a], height[b]) == height[a]) {
				a++;
			} else {
				b--;
			}
		}
		return maxArea;
	}
}