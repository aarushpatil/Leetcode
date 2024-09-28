class Solution {
    public String removeDigit(String number, char digit) {
        int latestDigInd = 0;
        for(int i = 0; i < number.length(); i++)
        {
            if(number.charAt(i) == digit)
            {
                latestDigInd = i;
                if(i + 1 < number.length() && number.charAt(i + 1) - number.charAt(i) > 0)
                {
                    break;
                }
            }
        }

        return number.substring(0, latestDigInd) + number.substring(latestDigInd + 1);
    }
}
//4342, digit = 4

//iterate left to right
//if current char matches digit
    //check if next char > current char
    //if it is then remove and return

//if not found then return removing the last seen digit?