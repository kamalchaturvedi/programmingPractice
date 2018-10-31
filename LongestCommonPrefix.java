class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        char currentChar;
        StringBuffer longestPrefix = new StringBuffer();
        int index = 0;
        boolean isCurrentCharPrefix = true;
        while(true){
            isCurrentCharPrefix = true;
            if((strs.length > 0) && (index < strs[0].length())){
                currentChar = strs[0].charAt(index);
                for(int i = 1;i< strs.length;i++){
                    if(index < strs[i].length()){
                        if(strs[i].charAt(index) != currentChar){
                            isCurrentCharPrefix = false;
                            break;
                        }
                    } else{
                        isCurrentCharPrefix = false;
                        break;
                    }     
                }
                if(isCurrentCharPrefix){
                    longestPrefix.append(currentChar);
                    ++index;
                }
                else
                    break;
            } else
                break;
        }
        return longestPrefix.toString();
    }
}
