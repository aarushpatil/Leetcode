class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder output = new StringBuilder();
        int spaceInd = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(spaceInd < spaces.length && spaces[spaceInd] == i)
            {
                output.append(" ");
                spaceInd++;
            }
            output.append(""+s.charAt(i));
        }

        return output.toString();
    }
}