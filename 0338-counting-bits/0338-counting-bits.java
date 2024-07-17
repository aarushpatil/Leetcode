class Solution {
    public int[] countBits(int n) {

        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] ret = new int[n+1];
        for(int i = 0; i <= n; i++)
        {
            int count = 0;
            int currNum = i;
            while(currNum != 0)
            {
                if(map.containsKey(currNum) ) // already processed
                {
                    count += map.get(currNum);
                    break;
                }
                // else if((currNum % 2 == 0) && map.containsKey(currNum+1))
                // {
                //     count += map.get(currNum + 1);
                //     break;
                // }
                // else if((currNum % 2 == 1) && map.containsKey(currNum-1))
                // {
                //     count += map.get(currNum - 1);
                //     break;
                // }
                if(currNum % 2 == 1)
                {
                    count++;
                }
                currNum /= 2;
            }
            ret[i] = count;
            map.put(i, count);
        }

        return ret;
        
    }
}