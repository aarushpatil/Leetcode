class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Calculate the theoretical maximum `n` that fits in maxSum
        int myN = Math.min(n, getMinN(maxSum));
        int ans = myN;

        // Precompute the sum of the first `myN` natural numbers
        int sumWithMyN = (myN * (myN + 1)) / 2;
        int remainingSum = maxSum - sumWithMyN;

        // Add banned numbers to a set for quick lookups
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        // Adjust for banned numbers in the range [1, myN]
        for (int i = 1; i <= myN; i++) {
            if (bannedSet.contains(i)) {
                remainingSum += i;
                ans--;
            }
        }

        // Use remaining sum to consider numbers beyond `myN` that are not banned
        for (int i = myN + 1; i <= n && remainingSum >= i; i++) {
            if (!bannedSet.contains(i)) {
                remainingSum -= i;
                ans++;
            }
        }

        return ans;
    }

    // Helper function to compute the maximum n that fits within maxSum
    private int getMinN(int maxSum) {
        return (int) ((-1 + Math.sqrt(1 + 8L * maxSum)) / 2);
    }
}
