class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        for(int i = 0; i < digits.length(); i++)
        {
            char d = digits.charAt(i);
            list.add(map.get(d));
        }
        if(list.size() == 0)
        {
            return list;
        }
        ArrayList<String> tempList = new ArrayList<>();

        for(char t : list.get(0).toCharArray())
        {
            tempList.add("" + t);
        }
        return makeList(list, tempList);
    }

    private ArrayList<String> makeList(ArrayList<String> list, ArrayList<String> tempList)
    {
        for(int i = 1; i < list.size(); i++)
        {
            String curr = list.get(i);
            ArrayList<String> newList = new ArrayList<>();
            for(int k = 0; k < tempList.size(); k++) //string char loop//
            {
                // char c = curr.charAt(j);
                for(int j = 0; j < curr.length(); j++) //for every item in tempList need to add c
                {
                    char c = curr.charAt(j);
                    newList.add("" + tempList.get(k) + c);
                }
            }
            tempList = newList;
        }
        return tempList;
    }

}