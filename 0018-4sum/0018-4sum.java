class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Long, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            freqMap.put((long)nums[i], freqMap.getOrDefault((long)nums[i], 0) + 1);
        }
        List<List<Integer>> sol = new ArrayList<>();
        HashSet<String> seen = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                for(int k = j + 1; k < nums.length; k++)
                {
                    long s = nums[i];
                    s += nums[j];
                    s += nums[k];
                    long miss = target - s;
                    if(freqMap.containsKey(miss))
                    {
                        int count = 1;
                        if(miss == nums[i])
                            count++;
                        if(miss == nums[j])
                            count++;
                        if(miss == nums[k])
                            count++;
                        if(freqMap.get(miss) >= count)
                        {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add((int)miss);
                            Collections.sort(list);
                            String str = list.toString();
                            if(!seen.contains(str)) //not already seen
                            {
                                sol.add(list);
                                seen.add(str);
                            }
                        }
                    }
                }
            }
        }
        return sol;
    }
}