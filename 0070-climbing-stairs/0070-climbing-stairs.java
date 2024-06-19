class Solution {
    HashMap<Integer, Integer> ansMap;
    public int climbStairs(int n) {
        ansMap = new HashMap<>();
        return recur(n);
    }
    int recur(int n)
    {
        if(n <= 3)
        {
            return n;
        }
        if(ansMap.containsKey(n))
        {
            return ansMap.get(n);
        }
        int ans = recur(n-2) + recur(n-1);
        ansMap.put(n, ans);
        return ans;
    }
}