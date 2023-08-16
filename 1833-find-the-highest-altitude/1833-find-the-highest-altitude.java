class Solution {
    public int largestAltitude(int[] gain) {
        int maxSum = 0;
        int currSum = 0;

        for(int i = 0; i < gain.length; i++)
        { 
            currSum += gain[i];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}