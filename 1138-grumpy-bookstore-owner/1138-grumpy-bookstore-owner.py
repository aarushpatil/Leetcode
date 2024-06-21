class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        defSatis = 0
        for i in range(len(customers)):
            if(grumpy[i] == 0):
                defSatis += customers[i]
        
        currSum = defSatis
        for i in range(minutes):
            if(grumpy[i] == 1):
                currSum += customers[i]
        maxSum = currSum
        for i in range(minutes, len(customers)):
            if(grumpy[i - minutes] == 1):
                currSum -= customers[i - minutes]
            if(grumpy[i] == 1):
                currSum += customers[i]

            maxSum = max(currSum, maxSum)
        return maxSum
