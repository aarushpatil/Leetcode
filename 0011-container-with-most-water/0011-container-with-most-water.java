class Solution {
   public static int maxArea(int[] height) {
		int maxArea = 0, a = 0, b = height.length - 1;
		while (b - a > 0) {
			maxArea = max(maxArea, min(height[a], height[b]) * (b - a));
			if (min(height[a], height[b]) == height[a]) {
				a++;
			} else {
				b--;
			}
		}
		return maxArea;
	}
	
	public static int max(int a, int b) {
		if(a>b) {
			return a;
		}
		else {
			return b;
		}
	}
	public static int min(int a, int b) {
		if(a<b) {
			return a;
		}
		else {
			return b;
		}
	}
}