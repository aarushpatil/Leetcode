
class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n+1];
    dp[0] = true;

    for (int i = 1; i <= n; ++i){
      for (String word : wordDict){
        if (i - word.length() < 0) continue;
        int start = i - word.length();
        // if(start == 0 || dp[start-1]){
        //   dp[i] = compare(s, start, i, word);
        // }
        System.out.println(Arrays.toString(dp));
        if (dp[start] && compare(s, start, i - 1, word)) {
            dp[i] = true;
            break;
        }
      }
    }
    return dp[n];
  }

  private boolean compare(String s, int start, int end, String word){
    if(end - start + 1 != word.length()) return false;
    for(int i = start; i <= end; ++i){
      if(s.charAt(i) != word.charAt(i - start)) return false;
    }
    return true;
  }
}