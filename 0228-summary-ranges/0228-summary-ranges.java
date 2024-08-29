class Solution {
    public List<String> summaryRanges(int[] nums) {

        

        List<String> ranges = new ArrayList<>();
        if(nums.length == 0) 
        {
            return ranges;
        }
       
        int prevRangeEnd = nums[0];

        for(int i = 0; i < nums.length - 1; i++)
        {
            int a = nums[i];
            int b = nums[i + 1];

            if(a + 1 != b)
            {
                //add range from [prevRangeEnd, a] to the output
                // System.out.println(prevRangeEnd + ", " + a);
                if(prevRangeEnd == a)
                {
                    ranges.add("" + a);
                }
                else
                {
                    ranges.add(prevRangeEnd + "->" + a);
                }
                prevRangeEnd = b;
            }
        }

        // System.out.println(prevRangeEnd + ", " + nums[nums.length - 1]);
        if(prevRangeEnd == nums[nums.length - 1])
        {
            ranges.add("" + prevRangeEnd);
        }
        else
        {
            ranges.add(prevRangeEnd + "->" + nums[nums.length - 1]);
        }

        return ranges;
    }
}