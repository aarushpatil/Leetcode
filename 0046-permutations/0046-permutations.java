class Solution {
    LinkedList<Integer> temp;
    HashSet<Integer> inTemp;
    List<List<Integer>> retList;
    public List<List<Integer>> permute(int[] nums) {
        temp = new LinkedList<>();
        inTemp = new HashSet<>();
        retList = new ArrayList<>();

        recur(nums);
        return retList;
    }

    void recur(int[] nums)
    {
        if(nums.length == temp.size())
            {
                LinkedList sec_list = new LinkedList(); 
		        sec_list = (LinkedList) temp.clone(); 
                retList.add(sec_list);
            }
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                
                if(!inTemp.contains(nums[i]))
                {
                    temp.add(nums[i]);
                    inTemp.add(nums[i]);
                    recur(nums);
                    temp.removeLast();
                    inTemp.remove(nums[i]);
                }
            }
        }
    }
}