class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int myN = Math.min(n, getMinN(maxSum));
        int ans = myN;

        int sumWithMyN = (myN * (myN + 1)) / 2;
        int bannedSum = maxSum - sumWithMyN;
        HashSet<Integer> bannedSet = new HashSet<>();
        for(int num : banned)
        {
            bannedSet.add(num);
        }

        for (int i = 1; i <= myN; i++) {
            if (bannedSet.contains(i)) {
                bannedSum += i;
                ans--;
            }
        }

        int currNum = myN + 1; //bannedSum > currNum
        while(bannedSum >= currNum && currNum <= n)
        {
            if(!bannedSet.contains(currNum))
            {
                bannedSum -= currNum;
                ans++;
            }
            currNum++;
        }
        return ans;
        //2+3+4+0+0+7+8
    }

    int getMinN(int maxSum)
    {
        return (int) ((-1 + Math.sqrt(1 + 8L * maxSum)) / 2);
    }
}