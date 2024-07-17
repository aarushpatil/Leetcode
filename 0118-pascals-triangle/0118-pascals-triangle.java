class Solution {
    List<List<Integer>> retList;
    public List<List<Integer>> generate(int numRows) {
        retList = new ArrayList<>();
        
        List<Integer> currList = new ArrayList<>();
        currList.add(1);
        retList.add(currList);
        for(int i = 0; i < numRows - 1; i++)
        {
            currList = new ArrayList<>();
            List<Integer> prevList = retList.get(i);

            currList.add(1);
            for(int k = 0; k < prevList.size()-1; k++)
            {
                currList.add(prevList.get(k) + prevList.get(k+1));
            }
            currList.add(1);
            retList.add(currList);
        }

        return retList;
    }


}