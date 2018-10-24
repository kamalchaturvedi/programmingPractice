class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        boolean[][] map = new boolean[s.length()][s.length()];
        int maxSize = 0, isSameValue = 1;
        String maxSubstring = "", tempString = "";
        if(s.length() == 1){
            return s;
        }
        for(int i = 0;i<s.length();i++){
            map[i][i]=true;
            if(s.charAt(0) != s.charAt(i))
                isSameValue = 0;
        }
        if(isSameValue == 1){
            return s;
        }
        for(int i = 0;i< (s.length()-1);i++){
            for(int j = i;j<s.length();j++){
                tempString = s.substring(i,j+1);
                if(isPalindrome(0,j-i,map,tempString)){
                        if((j-i+1) >maxSize){
                            maxSize = (j-i+1);
                            maxSubstring = tempString;
                        }
                }
            }
        }
        return maxSubstring;
    }
    boolean isPalindrome(int start, int end, boolean[][] map, String tempString){
        if(start == end){
            return map[start][end];
        }
        if(map[start][end]){
            return true;
        }
        if(start > end){
            return true;
        }
        //System.out.println(start+" "+end+" "+ tempString);
        if(tempString.charAt(start) != tempString.charAt(end)){
            map[start][end] = false;
            return map[start][end];
        }
        else {
            return isPalindrome(start+1, end-1, map, tempString);
        }
    }
}
