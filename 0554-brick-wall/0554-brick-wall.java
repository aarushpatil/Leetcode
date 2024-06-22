class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(List<Integer> list : wall)
        {
            int index = 0;
            for(int i = 0; i < list.size() - 1; i++)
            {
                index = index + list.get(i);
                freqMap.put(index, freqMap.getOrDefault(index, 0) + 1);
            }
        }

        // System.out.println(freqMap.toString());

        //iterate through the map and find the biggest number
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet())
        {
            max = Math.max(max, entry.getValue());
        }

        return wall.size() - max;
    }
}