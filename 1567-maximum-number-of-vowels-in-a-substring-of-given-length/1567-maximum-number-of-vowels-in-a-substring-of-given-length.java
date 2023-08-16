class Solution {
    public int maxVowels(String s, int k) {
        //open hashmap fill it with window of length k
        //move through window subtract 1 from currVowelCount if leftmost is vowel, and add 1 from currVowelCount if rightmost is a vowel

        //store maxVowels in a variable and check max(maxVowels, currVowelCount) every loop iteration

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');


        //open a window
        int l = 0;
        int r = 0;

        int currVowelCount = 0;   
        while(r < k)
        {
            if(vowels.contains(s.charAt(r)))
            {
                currVowelCount++;
            }
            r++;
        }
        r--;

        int maxVowels = currVowelCount;
        System.out.println("init: " + maxVowels +"\n\n l,r: (" + l + ", " + r + ")" );

        while(r < s.length() - 1)
        {
            if(vowels.contains(s.charAt(l)))
            {
                currVowelCount--;
            }
            if(vowels.contains(s.charAt(r + 1)))
            {
                currVowelCount++;
                System.out.println(r);
            }
            maxVowels = Math.max(maxVowels, currVowelCount);
            l++;
            r++;
        }
        return maxVowels;
    }
}