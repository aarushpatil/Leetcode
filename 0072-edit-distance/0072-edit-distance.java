class Solution {
    String x;
    String y;
    public int minDistance(String word1, String word2) {
        this.x = word1;
        this.y = word2;
        map = new HashMap<>();

        return dist(word1.length() - 1, word2.length() - 1);
    }
    
    HashMap<String, Integer> map;
    int dist(int a, int b)
    {
        if(a < 0) return b + 1;  // Base case: a is empty
        if(b < 0) return a + 1;  // Base case: b is empty

        String key = a + "," + b;  // Unique key for the current subproblem
        if(map.containsKey(key)) {
            return map.get(key);  // Return cached result if exists
        }

        int cost = (x.charAt(a) == y.charAt(b)) ? 0 : 1;

        int num1 = dist(a - 1, b) + 1;      // Deletion
        int num2 = dist(a, b - 1) + 1;      // Insertion
        int num3 = dist(a - 1, b - 1) + cost; // Substitution

        int result = Math.min(num1, Math.min(num2, num3));
        map.put(key, result);  // Cache the result for this subproblem
        return result;
    }
}
