class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '*')
			{
				st.pop();
			}
			else
			{
				st.push(s.charAt(i));
			}
		}
		
		StringBuilder retStr = new StringBuilder();
		int size = st.size();
		int i = 0;
		while(i < size) {
			retStr.append(st.pop());
			i++;
		}
		return retStr.reverse().toString();
    }
}