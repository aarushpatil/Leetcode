class Solution {
    public int minCostClimbingStairs(int[] cost) {

        for(int i = 2; i < cost.length; i++)
        {
            cost[i] = Math.min(cost[i - 2], cost[i - 1]) + cost[i];
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
    // public int minCostClimbingStairs(int[] cost) {
    //     return Math.min(costt(cost, cost.length - 1), costt(cost, cost.length - 2));
    // }

    // int costt(int[] cost, int ind)
    // {
    //     if(ind <= 1) return cost[ind];
    //     // if(ind == 0) return 0;
    //     return Math.min(costt(cost, ind - 1), costt(cost, ind - 2)) + cost[ind];
    // }
}