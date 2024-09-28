class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = 100001;

        for(int i = 0; i < cards.length; i++)
        {
            if(map.containsKey(cards[i]))
            {
                int lastInd = map.get(cards[i]);
                min = Math.min(i - lastInd, min);
            }
            map.put(cards[i], i);
        }
        
        if(min == 100001) return -1;

        return min + 1;
    }
}