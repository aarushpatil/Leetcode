class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((bloomDay.length / k) < m)
        {
            return -1;
        }

        int high = bloomDay[0];
        for(int i = 0; i < bloomDay.length; i++)
        {
            high = Math.max(bloomDay[i], high);
        }
        int low  = 0;
        
        int day = -12;
        while(low <= high) //binary search
        {
            day = (high + low) / 2; //same as mid

            if(numBouqAtDay(day, bloomDay, k) < m) //day is too low
            {
                low = day + 1;
            }
            else if(numBouqAtDay(day, bloomDay, k) >= m && numBouqAtDay(day - 1, bloomDay, k) < m) //mid is answer
            {
                return day;
            }
            else //mid is too high
            {
                high = day - 1;
            }
        }

        return day;
    }


    int numBouqAtDay(int day, int[] nums, int k)
    {
        int n = 0;
        int numBouq = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(day >= nums[i])
            {
                n++;
            }
            else
            {
                n = 0;
            }

            if(n == k)
            {
                n = 0;
                numBouq++;
            }
        }

        return numBouq;
    }
}