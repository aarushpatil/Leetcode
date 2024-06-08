class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('1', "abc");
                map.put('1', "abc");


        for(int i = 0; i < digits.length(); i++)
        {
            String d = "" + digits.charAt(i);
            if(d.equals("1"))
            {

            }
            else if(d.equals("2"))
            {
                list.add("abc");
            }
            else if(d.equals("3"))
            {
                list.add("def");
            }
            else if(d.equals("4"))
            {
                list.add("ghi");
            }
            else if(d.equals("5"))
            {
                list.add("jkl");
            }
            else if(d.equals("6"))
            {
                list.add("mno");
            }
            else if(d.equals("7"))
            {
                list.add("pqrs");
            }
            else if(d.equals("8"))
            {
                list.add("tuv");
            }
            else if(d.equals("9"))
            {
                list.add("wxyz");
            }
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