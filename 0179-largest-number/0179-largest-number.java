class Solution {
    public String largestNumber(int[] nums) {
        //convert nums to string array
        String[] arr = new String[nums.length];
        int ind = 0;
        for (int num : nums)
        {
            arr[ind] = "" + num;
            ind++;
        }
        
        // sort array
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        String ans = "";
        for (int i = 0; i < arr.length; i++)
        {
             ans += arr[i];
        }

        if(ans.charAt(0) == '0')
        {
            return "0";
        }

        return ans;
    }
}