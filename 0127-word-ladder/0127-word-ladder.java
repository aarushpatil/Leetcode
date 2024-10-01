class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //setup graph
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        // System.out.println(apartByOne);

        for(int i = 0; i < wordList.size(); i++)
        {
            if(beginWord.equals(wordList.get(i)))
            {
                // wordList.remove(i);
                break;
            }
        }

        for(int i = 0; i < wordList.size() - 1; i++)
        {
            for(int k = i + 1; k < wordList.size(); k++)
            {
                String a = wordList.get(i);
                String b = wordList.get(k);
                if(apartByOne(a, b))
                {
                    ArrayList<String> temp = map.getOrDefault(a, new ArrayList<>());
                    temp.add(b);
                    map.put(a, temp);

                    temp = map.getOrDefault(b, new ArrayList<>());
                    temp.add(a);
                    map.put(b, temp);
                }
            }

            if(apartByOne(beginWord, wordList.get(i)))
            {
                ArrayList<String> temp = map.getOrDefault(beginWord, new ArrayList<>());
                temp.add(wordList.get(i));
                map.put(beginWord, temp);
            }

        }

        if(apartByOne(beginWord, wordList.get(wordList.size() - 1)))
        {
            ArrayList<String> temp = map.getOrDefault(beginWord, new ArrayList<>());
            temp.add(wordList.get(wordList.size()-1));
            map.put(beginWord, temp);
        }

        // printGraph(map);

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        HashMap<String, Integer> depthMap = new HashMap<>();
        depthMap.put(beginWord, 1);

        // int depth = 0;
        q.add(beginWord);
        while(!q.isEmpty())
        {
            String curr = q.poll();
            if(!visited.contains(curr))
            {
                visited.add(curr);
                ArrayList<String> neighbors = map.getOrDefault(curr, new ArrayList<>());
                for(String str : neighbors)
                {
                    //add to queue
                    q.add(str);
                    depthMap.put(str, Math.min(depthMap.getOrDefault(str, Integer.MAX_VALUE), depthMap.get(curr) + 1));
                }
                // depth++;
            }
        }
        System.out.println("\n\n" + depthMap);
        return depthMap.getOrDefault(endWord, 0);
    }

    void printGraph(HashMap<String, ArrayList<String>> map)
    {
        for(Map.Entry<String, ArrayList<String>> e : map.entrySet())
        {
            System.out.print("\nkey: " + e.getKey() + "\t");
            for(String nei : e.getValue())
            {
                System.out.print(", " + nei);
            }
        }
    }

    static boolean apartByOne(String a, String b)
    {
        int count = 0;
        for(int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i) != b.charAt(i))
            {
                count++;
            }
        }
        
        return count == 1;
    }
}