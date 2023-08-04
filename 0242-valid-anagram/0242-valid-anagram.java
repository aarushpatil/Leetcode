class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }


//         HashMap<Character, Integer> map1 = new HashMap<>();

//         for(int i = 0; i < s.length(); i++){
//             //first time adding this value
//             if(!map1.containsKey(s.charAt(i))){
//                 map1.put(s.charAt(i), 0);
//             }
//             else{
//                 map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
//             }
//         }
// System.out.println(map1);
//         for(int i = 0; i < t.length(); i++){
//             if(!map1.containsKey(t.charAt(i))){
//                 return false;
//             }
//             if(map1.get(t.charAt(i)) < 1){
//                 map1.remove(t.charAt(i));
//             }
//             else{
//                 map1.put(t.charAt(i), map1.get(t.charAt(i)) - 1);
//             }
//     }
//     return map1.isEmpty();

        int[] charMap = new int[26];

        for(int i = 0; i < s.length(); i++){
            int num = s.charAt(i);
            charMap[num - 97] = charMap[num - 97] + 1;
        }

        for(int i = 0; i < t.length(); i++){
            int num = t.charAt(i);
            charMap[num - 97] = charMap[num - 97] - 1;
        }

        for(int i = 0; i < charMap.length; i++){
            if(charMap[i] != 0){
                return false;
            }
        }
        return true;
    }
}