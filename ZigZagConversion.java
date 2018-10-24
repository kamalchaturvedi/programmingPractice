class Solution {
    public String convert(String s, int numRows) {
        int columnCount = (s.length()/numRows);
        if(numRows > 1){
            columnCount += (numRows - 2)*(columnCount);
        }
        int index = 0,row=0,col=0;
        StringBuffer output = new StringBuffer(s.length());
        if((s.length()%numRows) > 0){
            columnCount = columnCount + 1;
        }
        
        char[][] mapping = new char[numRows][columnCount];
        int colIndex = 0;
        for(colIndex = 0;colIndex<columnCount;colIndex +=((numRows > 1) ? numRows-1: 1)){
            for(row= 0;row<numRows;row++){
                if(index >= s.length())
                    break;
                mapping[row][colIndex] = s.charAt(index);
                ++index;
            }
            for(col=colIndex+1,row=(numRows-2);(row > 0);col++,row--){
                if(index >= s.length())
                    break;
                mapping[row][col] = s.charAt(index);
                ++index;
            }
            if(index >= s.length())
                    break;
        }
        for(int j = 0;j< numRows;j++){
            for(int i = 0;i< columnCount;i++){
                if(mapping[j][i]!= '\u0000'){
                    output.append(mapping[j][i]);
                }
            }
        }
        return output.toString();
    }
}
