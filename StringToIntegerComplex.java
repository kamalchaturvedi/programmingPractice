import java.math.BigInteger;
class StringToIntegerComplex {
    public int myAtoi(String str) {
        int index = 0,output = 0;
        StringBuffer buffer = new StringBuffer();
        while((index < str.length()) && (str.charAt(index)== ' ')){
            ++index;
        }
        if((index < str.length()) && (str.charAt(index)== '-' || str.charAt(index)== '+')){
           buffer.append(str.charAt(index));
            ++index; 
        }
        while((index < str.length()) && ((str.charAt(index) >= '0' && str.charAt(index) <= '9'))){
            buffer.append(str.charAt(index));
            ++index;
        }
        try{
            output = Integer.parseInt(buffer.toString());
        }catch(Exception e){
            try{
            BigInteger bigOutput = new BigInteger(buffer.toString());
            if(bigOutput.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0){
                return Integer.MAX_VALUE;
            } else if (bigOutput.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0){
                return Integer.MIN_VALUE;
            }
            } catch(Exception j){
            }
        }
        return output;
    }
}
