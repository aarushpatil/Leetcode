class Solution {
    public int numRabbits(int[] answers) {
      // create a response - frequency map
      Map<Integer,Integer> frequencies = new HashMap<Integer, Integer>();
      for(int i = 0; i < answers.length; i++)
      {
         if (frequencies.containsKey(answers[i]))
         {
           frequencies.put(answers[i], frequencies.getOrDefault(answers[i], 0) + 1);
         } else {
           frequencies.put(answers[i], 1);
         }
      }

      int result = 0;
      // Iterate through map
      for (Map.Entry<Integer,Integer> e : frequencies.entrySet()) {
        int response = e.getKey();
        int freq = e.getValue();
        //[2,2,2,2,1] returns 8 
        //freq = 4, response = 2
        //4 > 2+1
        
        /* 
          if (response == 0) {
              result += freq;
              continue;
          }
        */
        
        if (freq > response+1) {
          // modulo
          int groupLimit = response + 1;
          boolean oneMore = freq % groupLimit != 0;
          int numGroups = freq / groupLimit; 
          if(oneMore) numGroups++;
          
          result += numGroups * (response+1);
        } else {
          result += response + 1;
        }
      }
      
      return result;
    }
    // [1,0,1,0,0] returns 6 expected 5
}