class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<String>();
        String[] wordMapping = {"","abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int[] inputDigits = new int[digits.length()]; 
        int counter = 0;
        if(digits.length() > 0) {
            for(char x:digits.toCharArray()){
                inputDigits[counter] = Character.getNumericValue(x);
                ++counter;
            }
            findAllCombinations(0, wordMapping, inputDigits, output,"");
        }
        return output;
    }
    
    void findAllCombinations(int inputIndex, String[] wordMapping,int[] inputDigits, List<String> output, String val){
        if(val.length() == inputDigits.length){
            output.add(val);
            return;
        }
        if(inputIndex >= inputDigits.length){
            return;
        } else {
            char[] currentCharArray = wordMapping[inputDigits[inputIndex]-1].toCharArray();
            int index = 0;
            while(index < currentCharArray.length){
                findAllCombinations(inputIndex + 1, wordMapping, inputDigits, output, val+currentCharArray[index]);
                ++index;
            }
        }
    }
}
