class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str = "";
        int minLen = 201;
        for(int i = 0; i < strs.length; i++){
            minLen = Math.min(minLen, strs[i].length());
        }
System.out.println(minLen);

        for(int j = 0; j < minLen; j++){
            int i = 1;
            for(i = 1; i < strs.length; i++){
                if(strs[i].charAt(j) != strs[i-1].charAt(j)){
                    return str;
                }
            }
            str += strs[i-1].charAt(j);
        }
        return str;
    }
}