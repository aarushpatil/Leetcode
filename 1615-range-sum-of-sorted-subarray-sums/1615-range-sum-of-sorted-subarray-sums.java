class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> sums = new ArrayList<>();

        for(int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for(int k = i; k < nums.length; k++)
            {
                sum += nums[k];
                sums.add(sum);
            }
        }
        
        // Integer[] sumsArray = sums.toArray(new Integer[0]);
        Collections.sort(sums);
        System.out.println(sums.toString());

        int modConst = (int) (Math.pow(10, 9) + 7);

        int ans = 0;
        for(int i = left-1; i < right && i < sums.size(); i++)
        {
            // System.out.println("adding: " + (ans + sums.get(i)) % modConst);
            ans = (ans + sums.get(i)) % modConst;
        }

        return ans;
    }
}