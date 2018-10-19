class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> complementCheck = new HashMap<Integer, Integer>();
        int complement = 0;
        int[] outputArray = new int[2];
        for(int i =0;i<nums.length;i++){
            complement = target - nums[i];
            if(complementCheck.containsKey(complement)){
                outputArray[0]=i;
                outputArray[1]= complementCheck.get(complement);
                return outputArray;
            }
            complementCheck.put(nums[i], i);
        }
        return outputArray;
    }
}
