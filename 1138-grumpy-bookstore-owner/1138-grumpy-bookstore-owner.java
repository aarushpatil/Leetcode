class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int defaultSatisfied = 0;
        for(int i = 0; i < customers.length; i++)
        {
            if(grumpy[i] == 0)
            {
                defaultSatisfied += customers[i];
            }
        }

        int max = defaultSatisfied;
        for(int i = 0; i < customers.length; i++)
        {
            int sum = defaultSatisfied;
            for(int m = i; m < minutes + i && m < customers.length; m++)
            {
                if(grumpy[m] == 1) //if he was grumpy at this time i can flip to non grumpy
                {
                    sum += customers[m];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}