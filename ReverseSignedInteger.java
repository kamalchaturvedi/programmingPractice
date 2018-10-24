class ReverseSignedInteger {
    public int reverse(int x) {
        StringBuffer stringRep = new StringBuffer(String.valueOf(x));
        long numberToReturn = 0;
        stringRep = stringRep.reverse();
        if(x < 0){
            numberToReturn = (-1)*Long.valueOf(stringRep.substring(0, stringRep.length() - 1));
            if(numberToReturn < Long.valueOf(Integer.MIN_VALUE)){
                return 0;
            }
        } else {
        numberToReturn = Long.valueOf(stringRep.toString());
            if(numberToReturn > Long.valueOf(Integer.MAX_VALUE)){
                return 0;
            }
        }
        return (int)(numberToReturn);
    }
}
