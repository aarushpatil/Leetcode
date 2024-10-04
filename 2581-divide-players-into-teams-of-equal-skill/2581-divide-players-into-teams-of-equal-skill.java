class Solution {
    public long dividePlayers(int[] skill) {
        double sum = 0;
        HashMap<Integer, LinkedList<Integer>> skillMap = new HashMap<>();
        for(int i = 0; i < skill.length; i++)
        {
            sum += skill[i];
            LinkedList<Integer> list = skillMap.getOrDefault(skill[i], new LinkedList<>());
            list.addLast(i);
            skillMap.put(skill[i], list);
        }

        // System.out.println(skillMap);
        // for(Map.Entry e : skillMap)
        // {
        //     System.out.println(e.getKey() + ": " + e.getValue())
        // }

        double temp = ((sum / skill.length) * 2);
        if(temp % 1 != 0) return -1;
        int teamSkill = (int)temp;
        long ans = 0;

        // System.out.println(teamSkill);

        for(int i = 0; i < skill.length; i++)
        {
            int curr = skill[i];
            if(curr == -1)
            {
                continue;
            }

            //make pair and -1 out the array
            int other = teamSkill - skill[i];
            
            //remove curr from map and array
            skill[i] = -1;
            skillMap.get(curr).removeFirst();
            
            if(skillMap.containsKey(other) && skillMap.get(other).size() > 0)
            {
                //it exists, remove it
                int indexRemoved = skillMap.get(other).removeFirst();
                skill[indexRemoved] = -1;

                ans += other * curr;
            }
            else
            {
                return -1;
            }
        }
        return ans;
    }
}