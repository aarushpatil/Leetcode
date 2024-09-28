class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int ans = 0;
        String inside = "";

        HashSet<String> subArr = new HashSet<>();

        int numDiv = 0;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i; j < nums.length; j++)
            {
                if(nums[j] % p == 0)
                {
                    //is divisible
                    numDiv++;
                }
                inside += nums[j] + ",";
                if(numDiv <= k && !subArr.contains(inside))
                {
                    subArr.add(inside);
                    ans++;
                    // System.out.println(i + " " + j + "\n" + inside);
                }
            }
            //clear
            numDiv = 0;
            inside = "";
        }

        return ans;
    }
}