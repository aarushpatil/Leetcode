class Solution {
    public double averageWaitingTime(int[][] customers) {

        double total = customers[0][1]; //2+2+4+1+3+0+1
        int runningSum = customers[0][0] + customers[0][1]; // 14
        for(int i = 1; i < customers.length; i++)
        {
            int sub = 0;
            if(runningSum - customers[i][0] < 0)
            {
                sub = customers[i][0] - runningSum;
            }
            total += Math.max(0, runningSum - customers[i][0]);
            total += customers[i][1];
            runningSum += customers[i][1];
            runningSum += sub;
        }

        return total / customers.length;
    }
}

//3 + 3 + 2 + 5