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

        //open the window
        int sum = defaultSatisfied;
        for(int i = 0; i < minutes; i++)
        {
            if(grumpy[i] == 1)
            {
                sum += customers[i];
            }
        }

        int max = Math.max(defaultSatisfied, sum);
        for(int i = minutes; i < customers.length; i++)
        {
            if(grumpy[i - minutes] == 1)
            {
                sum -= customers[i - minutes];
            }
            if(grumpy[i] == 1)
            {
                System.out.println("insiiideeeeeee");
                sum += customers[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}